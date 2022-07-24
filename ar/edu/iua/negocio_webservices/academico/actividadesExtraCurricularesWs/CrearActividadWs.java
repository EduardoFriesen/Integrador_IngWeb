package ar.edu.iua.negocio_webservices.academico.actividadesExtraCurricularesWs;

import ar.edu.iua.Excepciones.ActividadEx.CrearActividadEx;
import ar.edu.iua.modelo.academico.actividadesExtraCurriculares.Actividad;

public interface CrearActividadWs{
    boolean crear(Actividad actividad) throws CrearActividadEx;
}
