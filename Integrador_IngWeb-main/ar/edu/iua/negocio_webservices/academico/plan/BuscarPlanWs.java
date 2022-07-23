package ar.edu.iua.negocio_webservices.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.BuscarPlanEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;

public interface BuscarPlanWs {
    PlanWs buscar(int anio) throws BuscarPlanEx; 
}
