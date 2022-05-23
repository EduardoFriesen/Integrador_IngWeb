package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BuscarPlanImpl implements BuscarPlan {

    public Plan buscar(int anio) {
        for(int ii = 0; ii < BaseDeDatos.planes.size(); ii++){
            if(BaseDeDatos.planes.get(ii).getAnio().intValue() == anio){
                System.out.println(BaseDeDatos.planes.get(ii).getAnio());
                return BaseDeDatos.planes.get(ii);
            }
        }
        return null;
    }
    
}