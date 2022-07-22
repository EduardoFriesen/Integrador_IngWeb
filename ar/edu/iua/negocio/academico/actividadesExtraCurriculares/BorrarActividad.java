package ar.edu.iua.negocio.academico.actividadesExtraCurriculares;

import ar.edu.iua.Excepciones.ActividadEx.BorrarActividadEx;
import ar.edu.iua.modelo.academico.actividadesExtraCurriculares.Actividad;

public interface BorrarActividad {
    boolean borrar(Actividad actividad) throws BorrarActividadEx;
}
