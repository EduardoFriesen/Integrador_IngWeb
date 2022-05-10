package ar.edu.iua.negocio.academico.plan;

import java.util.List;

import ar.edu.iua.modelo.academico.plan.Plan;

public class ModificarPlanesImpl implements ModificarPlanes {

    public boolean modificar(List<Plan> planes) {
        CrearPlan crearPlan = new CrearPlanImpl();

        for (Plan plan : planes) {
            boolean b = crearPlan.crear(plan);
            if(b == false) return false;
        }
        return true;
    }
    
}
