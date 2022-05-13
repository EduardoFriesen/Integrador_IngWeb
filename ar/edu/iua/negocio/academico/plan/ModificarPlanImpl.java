package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.academico.plan.Plan;

public class ModificarPlanImpl implements ModificarPlan {

    public boolean modificar(Plan plan) {

        CrearPlan crearPlan = new CrearPlanImpl();
            boolean b = crearPlan.crear(plan);
            if(b == false) return false;
        
        return true;

    }
}
