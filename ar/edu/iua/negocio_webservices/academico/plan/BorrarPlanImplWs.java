package ar.edu.iua.negocio_webservices.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.BorrarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanImplWs;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BorrarPlanImplWs implements BorrarPlanWs{
    @Override
    public boolean borrar(PlanImplWs plan) throws BorrarPlanEx{
        for(int ii = 0; ii < BaseDeDatos.planes.size(); ii++){
            if(!plan.equals(null)){
                try {
                    if(BaseDeDatos.getPlan(ii).getAnio().equals(plan.getAnio()) && BaseDeDatos.getPlan(ii).isEstadoBorrador()){
                        BaseDeDatos.removePlan(ii);
                        return true;
                    }
                    else{
                        if(!BaseDeDatos.getPlan(ii).getAnio().equals(plan.getAnio()))
                            throw new BorrarPlanEx("Plan no encontrado");
                        if(!BaseDeDatos.getPlan(ii).isEstadoBorrador())
                            throw new BorrarPlanEx("Estado de plan diferente a borrardor");
                    }
                } catch (CloneNotSupportedException e) {
                    throw new BorrarPlanEx("no se pudo obtener el plan" + ii);
                }
            }
            else{
                throw new BorrarPlanEx("El plan es nulo");
            }
        }
        return false;
    }   
}
