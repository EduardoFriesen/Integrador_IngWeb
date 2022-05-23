package ar.edu.iua.negocio.academico.plan;

import java.util.List;

import ar.edu.iua.modelo.academico.plan.Plan;

public interface BorrarPlanes {

    /*
        Este metodo requiere que se quite de la base de datos un listado de planes
        Se debe validar y retornar false si:
            - planes no puede ser null            
            - Ver las mismas reglas de BorrarPlan.borrar(Plan plan)

    */
    boolean borrar(List<Plan> plan);    
    
}
