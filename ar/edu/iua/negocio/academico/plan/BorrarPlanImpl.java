package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BorrarPlanImpl implements BorrarPlan {

    public boolean borrar(Plan plan) {
        for (int i = 0; i < BaseDeDatos.planes.size(); i++) {
            if (plan != null && plan.isEstadoBorrador()) {
                if (BaseDeDatos.planes.get(i).getAnio().equals(plan.getAnio())
                        && BaseDeDatos.planes.get(i).isEstadoBorrador()) {
                    BaseDeDatos.planes.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
}
