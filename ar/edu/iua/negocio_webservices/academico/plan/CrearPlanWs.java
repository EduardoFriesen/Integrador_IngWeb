package ar.edu.iua.negocio_webservices.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;

public interface CrearPlanWs {
    boolean crear(PlanWs plan) throws CrearPlanEx;    
}
