package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.BuscarPlanEx;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BuscarPlanImpl implements BuscarPlan {

    @Override
    public Plan buscar(int anio) throws BuscarPlanEx{
        for(int ii = 0; ii < BaseDeDatos.planes.size(); ii++){
            try {
                if(BaseDeDatos.getPlan(ii).getAnio().intValue() == anio){
                    return BaseDeDatos.getPlan(ii);
                }
            } catch (CloneNotSupportedException e) {
                throw new BuscarPlanEx("No se pudo obtener el plan " + ii );
            }
        }
        throw new BuscarPlanEx("No se encontro el plan");
    }
    
}