package ar.edu.iua.negocio.academico.plan;

import java.util.List;

import ar.edu.iua.modelo.EX.BorrarPlanEx;
import ar.edu.iua.modelo.academico.plan.Plan;
//import ar.edu.iua.persistencia.BaseDeDatos;

public class BorrarPlanesImpl implements BorrarPlanes {

    public boolean borrar(List<Plan> planes) throws BorrarPlanEx {
        boolean bandera = false;
        for(int i = 0; i < planes.size(); i++){
            BorrarPlanImpl borrador = new BorrarPlanImpl();
            bandera = borrador.borrar(planes.get(i));
            if(!bandera){
                return bandera;
            }
        }
        return bandera;
    } 
}
