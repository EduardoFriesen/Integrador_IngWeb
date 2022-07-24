package ar.edu.iua.negocio_webservices.academico.actividadesExtraCurricularesWs;

import ar.edu.iua.Excepciones.ActividadEx.BorrarActividadEx;
import ar.edu.iua.modelo_webservices.academico.actividadesExtraCurriculaesWs.ActividadWs;


public interface BorrarActividadWs {
    boolean borrar(ActividadWs actividadWs) throws BorrarActividadEx;
}
