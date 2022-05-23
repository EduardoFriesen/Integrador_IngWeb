package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.EX.BorrarPlanEx;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BorrarPlanImpl implements BorrarPlan {

    public boolean borrar(Plan plan) throws BorrarPlanEx{
        for (int i = 0; i < BaseDeDatos.planes.size(); i++) {
            if (plan != null && plan.isEstadoBorrador()) {
                if (BaseDeDatos.planes.get(i).getAnio().equals(plan.getAnio())
                        && BaseDeDatos.planes.get(i).isEstadoBorrador()) {
                    BaseDeDatos.planes.remove(i);
                    return true;
                }
            } else if (plan == null){
                throw new BorrarPlanEx("El plan es nulo");
            }
        }
        throw new BorrarPlanEx("No se pudo borrar el plan");
    }
}
