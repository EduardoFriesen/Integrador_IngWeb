package ar.edu.iua.negocio_webservices.academico.actividadesExtraCurricularesWs;

import ar.edu.iua.Excepciones.ActividadEx.CrearActividadEx;
import ar.edu.iua.Excepciones.ActividadEx.ModificarActividadEx;
import ar.edu.iua.modelo.academico.actividadesExtraCurriculares.Actividad;

public interface ModificarActividadWs {
    boolean modificar(Actividad actividad) throws CrearActividadEx, ModificarActividadEx;
}
