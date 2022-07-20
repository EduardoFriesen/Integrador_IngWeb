package ar.edu.iua.negocio_webservices.academico.plan;

import java.util.List;

import ar.edu.iua.Excepciones.modeloEx.BuscarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;

public interface BuscarPlanesWs {
    List<PlanWs> buscar(String terminos) throws BuscarPlanEx;
}
