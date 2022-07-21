package ar.edu.iua.negocio_webservices.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.BorrarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanImplWs;

public interface BorrarPlanWs {
    boolean borrar(PlanImplWs plan) throws BorrarPlanEx;
}
