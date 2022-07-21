package ar.edu.iua.negocio_webservices.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanImplWs;

public interface ModificarPlanWs {
    boolean modificar(PlanImplWs plan) throws ModificarPlanEx;  
}
