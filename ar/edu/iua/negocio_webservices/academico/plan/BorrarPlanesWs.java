package ar.edu.iua.negocio_webservices.academico.plan;

import java.util.List;

import ar.edu.iua.Excepciones.modeloEx.BorrarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanImplWs;

public interface BorrarPlanesWs {
    boolean borrar(List<PlanImplWs> plan) throws BorrarPlanEx; 
}
