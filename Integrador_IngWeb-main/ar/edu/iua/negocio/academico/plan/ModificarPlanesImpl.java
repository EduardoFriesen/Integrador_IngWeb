package ar.edu.iua.negocio.academico.plan;

import java.util.List;

import ar.edu.iua.modelo.academico.plan.Plan;

public class ModificarPlanesImpl implements ModificarPlanes {

    public boolean modificar(List<Plan> planes) {
        ModificarPlan b = new ModificarPlanImpl();

        for (int i = 0; i < planes.size(); i++) {
            if (planes != null) {
                if (b.modificar(planes.get(i)) == false) {
                    return b.modificar(planes.get(i));
                }
            }
        }
        return true;
    }

}
