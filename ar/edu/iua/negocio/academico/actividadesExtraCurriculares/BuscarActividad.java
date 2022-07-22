package ar.edu.iua.negocio.academico.actividadesExtraCurriculares;

import ar.edu.iua.Excepciones.ActividadEx.BuscarActividadEx;
import ar.edu.iua.modelo.academico.actividadesExtraCurriculares.Actividad;

public interface BuscarActividad {
    Actividad buscar(String nombre) throws BuscarActividadEx;
}
