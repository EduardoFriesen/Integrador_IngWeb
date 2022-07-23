package ar.edu.iua.negocio.academico.plan;

import java.util.List;

import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
import ar.edu.iua.modelo.academico.plan.Plan;

public class ModificarPlanesImpl implements ModificarPlanes {

    @Override
    public boolean modificar(List<Plan> planes) throws ModificarPlanEx, CrearPlanEx {
        ModificarPlan modificador = new ModificarPlanImpl();
        CrearPlan validar = new CrearPlanImpl();
        Boolean bandera = false;

        for(int ii = 0; ii < planes.size(); ii++){
            if(planes != null){
                try {
                    bandera = validar.crear(planes.get(ii));
                } catch (CrearPlanEx e) {
                    throw new ModificarPlanEx(e.getMessage());
                }
                if(!bandera){
                    return bandera;
                }
            }
        }

        for(Plan plan : planes){
            bandera = modificador.modificar(plan);
            if(!bandera) return bandera;
        }
        return bandera;
    }
}
