package ar.edu.iua.webServices.Controladores.plan;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import ar.edu.iua.Excepciones.modeloEx.BuscarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;
import ar.edu.iua.negocio_webservices.academico.plan.BuscarPlanesImplWs;
import ar.edu.iua.util.Traductor;
import ar.edu.iua.webServices.Util.utilWebServices;

public class BuscarPlanesHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String contextPath = exchange.getHttpContext().getPath();
        URI uri = exchange.getRequestURI();
        String path = uri.toString().replaceFirst(contextPath, "");
        Map<String, String> params = utilWebServices.leerParametrosConsulta(path);
        String body = utilWebServices.leerBody(exchange);

        try {
            ejecutarRespuesta(exchange, params, body);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            String msg = "504 ERROR INTERNO";
            exchange.sendResponseHeaders(504, 0);
            OutputStream os = exchange.getResponseBody();
            os.write(msg.getBytes());
            os.close();
        }

    }

    private void ejecutarRespuesta(HttpExchange exchange, Map<String, String> params, String body)
            throws IOException {

        BuscarPlanesImplWs buscador = new BuscarPlanesImplWs();
        List<List<PlanWs>> resultados = new ArrayList<>();
        Gson gson = new Gson();
        String msg = "";

        try {
            for (int i = 0; i < params.values().size(); i++) {
                Object[] array = params.values().toArray();
                String value = (String) array[i];
                String valor = Traductor.TraducirCadena(value);
                resultados.add(buscador.buscar(valor));
            }

            msg += gson.toJson(resultados);

        } catch (BuscarPlanEx e) {
            System.out.println(e.getMessage());
            msg = "204 NO CONTENT: no hay resultados para la busqueda";
            exchange.sendResponseHeaders(204, 0);
            OutputStream os = exchange.getResponseBody();
            os.write(msg.getBytes());
            os.close();
        }

        msg = Traductor.TraducirCadena(msg);

        exchange.sendResponseHeaders(200, msg.length());
        OutputStream os = exchange.getResponseBody();
        os.write(msg.getBytes());
        os.close();

    }

}
