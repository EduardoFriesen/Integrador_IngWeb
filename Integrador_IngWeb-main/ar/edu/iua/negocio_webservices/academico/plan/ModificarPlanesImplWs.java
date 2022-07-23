package ar.edu.iua.negocio_webservices.academico.plan;

import java.util.List;

import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
import ar.edu.iua.Excepciones.modeloEx.VerificadorEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;
import ar.edu.iua.util.VerificarIntegridad;

public class ModificarPlanesImplWs implements ModificarPlanesWs {

    public boolean modificar(List<PlanWs> planes) throws ModificarPlanEx {
        ModificarPlanWs modificador = new ModificarPlanImplWs();
        Boolean bandera = false;

        for(int ii = 0; ii < planes.size(); ii++){
            if(planes != null){
                //bandera = modificador.modificar(planes.get(ii));
                try {
                    bandera = VerificarIntegridad.verificarIntegridadPlanWs(planes.get(ii));
                } catch (VerificadorEx e) {
                    throw new ModificarPlanEx(e.getMessage());
                }
                if(!bandera){
                    return bandera;
                }
            }
        }

        for(PlanWs plan : planes){
            bandera = modificador.modificar(plan);
            if(!bandera) return bandera;
        }
        return bandera;
    }
}
