package ar.edu.iua.webServices.Controladores.plan;

import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ar.edu.iua.Excepciones.modeloEx.BorrarPlanEx;
import ar.edu.iua.Excepciones.modeloEx.BuscarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanImplWs;
import ar.edu.iua.modelo_webservices.academico.PlanWs;
import ar.edu.iua.negocio_webservices.academico.plan.BorrarPlanesImplWs;
import ar.edu.iua.negocio_webservices.academico.plan.BorrarPlanesWs;
import ar.edu.iua.negocio_webservices.academico.plan.BuscarPlanImplWs;
import ar.edu.iua.webServices.Util.utilWebServices;

public class BorrarPlanesHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String contextPath = exchange.getHttpContext().getPath();
        URI uri = exchange.getRequestURI();
        String path = uri.toString().replaceFirst(contextPath, "");
        Map<String, String> params = utilWebServices.leerParametrosConsulta(path);
        String body = utilWebServices.leerBody(exchange);

        try {
            ejecutarRespuesta(exchange, params, body);
        } catch (BuscarPlanEx|IOException e) {
            System.out.println(e.getMessage());
            String msg = "504 ERROR INTERNO";
            exchange.sendResponseHeaders(504,0);
            OutputStream os = exchange.getResponseBody();
            os.write(msg.getBytes());
            os.close();
        }

    }

    private void ejecutarRespuesta(HttpExchange exchange,Map<String, String> params,String body) throws BuscarPlanEx,IOException{
        List<PlanWs> borrados = new ArrayList<>();
        
        for (String value : params.values()) {
            PlanWs plan = new PlanImplWs();
            BuscarPlanImplWs buscador = new BuscarPlanImplWs();
            plan = buscador.buscar(Integer.parseInt(value));
            borrados.add(plan);
        }

        BorrarPlanesWs borrador = new BorrarPlanesImplWs();
        try {
            borrador.borrar(borrados);
        } catch (BorrarPlanEx e) {
            System.out.println(e.getMessage());
            String msg = "409 ERROR DE CONFLICTO: no se pudieron borrar los planes";
            exchange.sendResponseHeaders(409,msg.length());
            OutputStream os = exchange.getResponseBody();
            os.write(msg.getBytes());
            os.close();
        }

        String msg = "200: Se borraron los planes";
        exchange.sendResponseHeaders(200, msg.length());
        OutputStream os = exchange.getResponseBody();
        os.write(msg.getBytes());
        os.close();
    }
    

}
