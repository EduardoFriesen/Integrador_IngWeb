package ar.edu.iua.negocio_webservices.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.BorrarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;

public interface BorrarPlanWs {
    boolean borrar(PlanWs planes) throws BorrarPlanEx;    
    
}
