package ar.edu.iua.negocio_webservices.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;

public interface ModificarPlanWs {
    boolean modificar(PlanWs plan) throws ModificarPlanEx;    
}
