package ar.edu.iua.negocio_webservices.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.BorrarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BorrarPlanImplWs implements BorrarPlanWs {

    public boolean borrar(PlanWs plan) throws BorrarPlanEx{
        for(int ii = 0; ii < BaseDeDatos.planesSizeWs(); ii++){
            if(!plan.equals(null)){
                try {
                    if(BaseDeDatos.getPlanWs(ii).getAnio().equals(plan.getAnio()) && BaseDeDatos.getPlanWs(ii).isEstadoBorrador()){
                        BaseDeDatos.removePlanWs(ii);
                        return true;
                    }
                } catch (CloneNotSupportedException e) {
                    throw new BorrarPlanEx("No se pudo obtener el plan " + ii + " en BorrarPlanImpl ln 13");
                }
            }
            else{
                throw new BorrarPlanEx("El plan es nulo. BorrarPlan.java ln 11");
            }
        }
        throw new BorrarPlanEx("No se encuentra el plan o no es borrador. BorrarPlan.java ln 12");
    }   
}
