package ar.edu.iua.negocio_webservices.academico.plan;

import java.util.List;

import ar.edu.iua.Excepciones.modeloEx.BorrarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;

public class BorrarPlanesImplWs implements BorrarPlanesWs{
    @Override
    public boolean borrar(List<PlanWs> planes) throws BorrarPlanEx {
        boolean bandera = false;
        
        for(int ii = 0; ii < planes.size(); ii++){
            if(planes.get(ii) == null) throw new BorrarPlanEx("El plan " + planes.get(ii).getAnio() + " es nulo");
            if(!planes.get(ii).isEstadoBorrador()) throw new BorrarPlanEx("El plan " + planes.get(ii).getAnio() + " no esta en estado borrador");
        }
        
        for(int ii = 0; ii < planes.size(); ii++){
            BorrarPlanImplWs borrador = new BorrarPlanImplWs();
            bandera = borrador.borrar(planes.get(ii));
            if(!bandera){
                return bandera;
            }
        }
        return bandera;
    } 
}
