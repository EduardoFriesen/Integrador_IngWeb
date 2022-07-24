package ar.edu.iua.negocio_webservices.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;
import ar.edu.iua.persistencia.BaseDeDatos;

public class ModificarPlanImplWs implements ModificarPlanWs{
    public boolean modificar(PlanWs plan) throws  ModificarPlanEx {
        boolean b = false;   
        CrearPlanWs crearPlan = new CrearPlanImplWs(); 
        try{
            
            b = crearPlan.crear(plan);
            }catch (CrearPlanEx e1){
              throw new ModificarPlanEx(e1.getMessage());  
            }
            if(b){
                for(int i = 0; i < BaseDeDatos.planes.size(); i++){
                if(BaseDeDatos.planes.get(i).getAnio().equals(plan.getAnio())){
                    try {
                        BaseDeDatos.planesWebServices.set(i, (PlanWs)plan.clone());
                    } catch (CloneNotSupportedException e) {
                        throw new ModificarPlanEx("No se pudo acceder al indice " + i );
                    }
                    return false;
                }
            }
        }

        return true;
    }
}
