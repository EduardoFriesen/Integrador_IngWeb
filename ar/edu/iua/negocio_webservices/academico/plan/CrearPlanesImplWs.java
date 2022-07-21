package ar.edu.iua.negocio_webservices.academico.plan;

import java.util.List;

import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanImplWs;

public class CrearPlanesImplWs implements CrearPlanesWs {
    public boolean crear(List<PlanImplWs> planes) throws CrearPlanEx {

        CrearPlanWs crearPlan = new CrearPlanImplWs();

        for (PlanImplWs plan : planes) {
            boolean b = crearPlan.crear(plan);
            if(b == false) return false;
        }
        return true;
    }
}
