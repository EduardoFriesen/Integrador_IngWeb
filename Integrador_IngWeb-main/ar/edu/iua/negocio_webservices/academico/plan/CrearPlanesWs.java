package ar.edu.iua.negocio_webservices.academico.plan;

import java.util.List;

import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanImplWs;

public interface CrearPlanesWs {
    boolean crear(List<PlanImplWs> planes) throws CrearPlanEx;
}
