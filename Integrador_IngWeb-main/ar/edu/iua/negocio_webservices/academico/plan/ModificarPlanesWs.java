package ar.edu.iua.negocio_webservices.academico.plan;

import java.util.List;

import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;

public interface ModificarPlanesWs {
    boolean modificar(List<PlanWs> planes) throws ModificarPlanEx;    
    
}