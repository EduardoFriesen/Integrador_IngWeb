package ar.edu.iua.negocio_webservices.academico.actividadesExtraCurricularesWs;

import ar.edu.iua.Excepciones.ActividadEx.BuscarActividadEx;
import ar.edu.iua.modelo.academico.actividadesExtraCurriculares.Actividad;

public interface BuscarActividadWs {
    Actividad buscar(String nombre) throws BuscarActividadEx;
}
