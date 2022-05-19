package ar.edu.iua.negocio.academico.plan;

import java.util.List;

import ar.edu.iua.modelo.EX.CrearPlanEx;
import ar.edu.iua.modelo.academico.plan.Plan;

public class CrearPlanesImpl implements CrearPlanes {

    public boolean crear(List<Plan> planes) throws CrearPlanEx {

        CrearPlan crearPlan = new CrearPlanImpl();

        for (Plan plan : planes) {
            boolean b = crearPlan.crear(plan);
            if(b == false) return false;
        }
        return true;
    }

}
