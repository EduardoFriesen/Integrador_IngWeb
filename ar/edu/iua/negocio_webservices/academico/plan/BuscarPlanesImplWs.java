package ar.edu.iua.negocio_webservices.academico.plan;

import java.util.ArrayList;
import java.util.List;

import ar.edu.iua.Excepciones.modeloEx.BuscarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;
import ar.edu.iua.persistencia.BaseDeDatos;
import ar.edu.iua.util.Traductor;

public class BuscarPlanesImplWs implements BuscarPlanesWs{
    public List<PlanWs> buscar(String terminos) throws BuscarPlanEx{
        List<PlanWs> planesBuscados = new ArrayList<>();
        if(terminos != null){
            terminos = Traductor.TraducirCadena(terminos);
            String[] terminosArray = terminos.trim().toLowerCase().split(" ");
            for(int ii = 0; ii < BaseDeDatos.planes.size(); ii++){
                PlanWs plan = null;
                try {
                    plan = BaseDeDatos.getPlanWs(ii);
                } catch (CloneNotSupportedException e) {
                    throw new BuscarPlanEx("No se pudo obtener el plan " + ii);
                }
                String toStringFullPlan = plan.toStringFull().toLowerCase();
                toStringFullPlan = Traductor.TraducirCadena(toStringFullPlan);
                for(String termino : terminosArray){
                    if(toStringFullPlan.contains(termino)){
                        planesBuscados.add(plan);
                        break;
                    }
                }
            }
        }
        else if(terminos == null || terminos.length()==0){
            throw new BuscarPlanEx("No se ingresaron terminos.");
        }
        
        return planesBuscados;
    }
}
