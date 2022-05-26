package ar.edu.iua.negocio.academico.plan;

import java.util.List;

import ar.edu.iua.Excepciones.modeloEx.BorrarPlanEx;
import ar.edu.iua.modelo.academico.plan.Plan;

public class BorrarPlanesImpl implements BorrarPlanes {
    
    @Override
    public boolean borrar(List<Plan> planes) throws BorrarPlanEx {
        boolean bandera = false;
        
        for(int ii = 0; ii < planes.size(); ii++){
            if(planes.get(ii) == null) throw new BorrarPlanEx("El plan " + planes.get(ii).getAnio() + " es nulo");
            if(!planes.get(ii).isEstadoBorrador()) throw new BorrarPlanEx("El plan " + planes.get(ii).getAnio() + " no esta en estado borrador");
        }
        
        for(int ii = 0; ii < planes.size(); ii++){
            BorrarPlanImpl borrador = new BorrarPlanImpl();
            bandera = borrador.borrar(planes.get(ii));
            if(!bandera){
                return bandera;
            }
        }
        return bandera;
    } 
}
