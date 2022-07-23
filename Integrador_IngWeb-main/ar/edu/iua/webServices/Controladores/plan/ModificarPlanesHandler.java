package ar.edu.iua.webServices.Controladores.plan;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanImplWs;
import ar.edu.iua.modelo_webservices.academico.PlanWs;
import ar.edu.iua.negocio_webservices.academico.plan.ModificarPlanesImplWs;
import ar.edu.iua.webServices.Util.utilWebServices;

public class ModificarPlanesHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange exchange) throws IOException {
		
        String contextPath = exchange.getHttpContext().getPath();
        URI uri = exchange.getRequestURI();
        String path = uri.toString().replaceFirst(contextPath, "");
        Map<String, String> params = utilWebServices.leerParametrosConsulta(path);
        String body = utilWebServices.leerBody(exchange);

        try{
            ejecutarRespuesta(exchange, params, body);
        }catch(Exception e){
            System.out.println(e.getMessage());
            String msg = "504 ERROR INTERNO";
            exchange.sendResponseHeaders(504,0);
            OutputStream os = exchange.getResponseBody();
            os.write(msg.getBytes());
            os.close();
        }
		
	}
    private void ejecutarRespuesta(HttpExchange exchange,Map<String, String> params,String body) throws IOException{

        PlanImplWs[] planArray = new Gson().fromJson(body, PlanImplWs[].class);
        List<PlanWs> modificados = Arrays.asList(planArray);

        ModificarPlanesImplWs modificador = new ModificarPlanesImplWs();

        try {
			modificador.modificar(modificados);
		} catch (ModificarPlanEx e) {
			System.out.println(e.getMessage());
            String msg = "409 ERROR DE CONFLICTO: no se pudieron modificar los planes";
            exchange.sendResponseHeaders(204,0);
            OutputStream os = exchange.getResponseBody();
            os.write(msg.getBytes());
            os.close();
		}

        String msg = "200: Se modificaron los planes";
        exchange.sendResponseHeaders(200, msg.length());
        OutputStream os = exchange.getResponseBody();
        os.write(msg.getBytes());
        os.close();
    }
    
}
