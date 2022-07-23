package ar.edu.iua.negocio.academico.actividadesExtraCurriculares;

import ar.edu.iua.Excepciones.ActividadEx.CrearActividadEx;
import ar.edu.iua.Excepciones.ActividadEx.ModificarActividadEx;
import ar.edu.iua.modelo.academico.actividadesExtraCurriculares.Actividad;

public interface ModificarActividad {
    boolean modificar(Actividad actividad) throws CrearActividadEx, ModificarActividadEx;
}
