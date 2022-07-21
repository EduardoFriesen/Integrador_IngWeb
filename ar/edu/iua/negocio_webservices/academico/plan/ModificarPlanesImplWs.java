package ar.edu.iua.negocio_webservices.academico.plan;

import java.util.List;

import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanImplWs;

public class ModificarPlanesImplWs implements ModificarPlanesWs{
    @Override
    public boolean modificar(List<PlanImplWs> planes) throws ModificarPlanEx {
        ModificarPlanWs modificador = new ModificarPlanImplWs();
        CrearPlanWs validar = new CrearPlanImplWs();
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

        for(PlanImplWs plan : planes){
            bandera = modificador.modificar(plan);
            if(!bandera) return bandera;
        }
        return bandera;
    }
}
