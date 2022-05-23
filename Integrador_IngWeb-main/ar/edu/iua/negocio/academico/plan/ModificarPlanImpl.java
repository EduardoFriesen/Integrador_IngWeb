package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class ModificarPlanImpl implements ModificarPlan {

    public boolean modificar(Plan plan) {

        CrearPlan crearPlan = new CrearPlanImpl();
            boolean b = crearPlan.crear(plan);
            if(b){
                for(int i = 0; i < BaseDeDatos.planes.size(); i++){
                if(BaseDeDatos.planes.get(i).getAnio().equals(plan.getAnio())){
                    try {
                        BaseDeDatos.planes.set(i, (Plan)plan.clone());
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    return false;
                }
            }
        }

        return true;
    }
}
