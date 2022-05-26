package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.BorrarPlanEx;
import ar.edu.iua.modelo.academico.plan.Plan;

public interface BorrarPlan {
    /*
        Este metodo requiere que se quite de la base de datos un plan
        Se debe validar y retornar false si:
            - plan no puede ser null            
            - No se permite borrar un plan, excepto si el estado es BORRADOR

    */
    boolean borrar(Plan plan) throws BorrarPlanEx;
    
    
}
