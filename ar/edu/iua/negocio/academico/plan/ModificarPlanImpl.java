package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class ModificarPlanImpl implements ModificarPlan {

    public boolean modificar(Plan plan) throws CrearPlanEx, ModificarPlanEx {
        boolean b = false;   
        CrearPlan crearPlan = new CrearPlanImpl(); 
        try{
            
            b = crearPlan.crear(plan);
            }catch (CrearPlanEx e1){
              throw new ModificarPlanEx(e1.getMessage());  
            }
            if(b){
                for(int i = 0; i < BaseDeDatos.planes.size(); i++){
                if(BaseDeDatos.planes.get(i).getAnio().equals(plan.getAnio())){
                    try {
                        BaseDeDatos.planes.set(i, (Plan)plan.clone());
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
