package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.BuscarPlanEx;
import ar.edu.iua.modelo.academico.plan.Plan;

public interface BuscarPlan {
    
    Plan buscar(int anio) throws BuscarPlanEx;
    
}
