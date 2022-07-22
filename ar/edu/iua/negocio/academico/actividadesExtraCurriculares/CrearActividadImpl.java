package ar.edu.iua.negocio.academico.actividadesExtraCurriculares;

import ar.edu.iua.Excepciones.ActividadEx.CrearActividadEx;
import ar.edu.iua.modelo.academico.actividadesExtraCurriculares.Actividad;

public class CrearActividadImpl implements CrearActividad{
    
    public boolean crear(Actividad actividad) throws CrearActividadEx {
        if(actividad == null){
            throw new CrearActividadEx("La actividad es nula.");
        }
        if (!actividad.isEstadoActivo() && !actividad.isEstadoNoActivo() && !actividad.isEstadoBorrador()) {
            throw new CrearActividadEx("La actividad no posee Estado.");
        }
        if(actividad.getNombre() == null && !actividad.isEstadoBorrador()){
            throw new CrearActividadEx("La actividad no posee Nombre.");
        }
        if(actividad.getCodigo() == null && !actividad.isEstadoBorrador()){
            throw new CrearActividadEx("La actividad no posee Codigo.");
        }
        if(actividad.getCargaHoraria() == null && !actividad.isEstadoBorrador()){
            throw new CrearActividadEx("La actividad no posee Carga Horaria.");
        }
        return true;
    }
}
