package ar.edu.iua.negocio_webservices.academico.plan;

import java.util.List;

import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanImplWs;

public interface ModificarPlanesWs {
    boolean modificar(List<PlanImplWs> planes) throws ModificarPlanEx;  
}
