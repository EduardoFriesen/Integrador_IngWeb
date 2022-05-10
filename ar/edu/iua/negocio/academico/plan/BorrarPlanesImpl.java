package ar.edu.iua.negocio.academico.plan;

import java.util.List;

import ar.edu.iua.modelo.academico.plan.Plan;

public class BorrarPlanesImpl implements BorrarPlanes {

    public boolean borrar(List<Plan> plan) {
        if (plan != null && ((Plan) plan).isEstadoBorrador()) {
            return true;
        } else {
            return false;
        }
    }

}
