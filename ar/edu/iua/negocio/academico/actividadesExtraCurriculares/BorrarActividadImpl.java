package ar.edu.iua.negocio.academico.actividadesExtraCurriculares;

import ar.edu.iua.Excepciones.ActividadEx.BorrarActividadEx;
import ar.edu.iua.modelo.academico.actividadesExtraCurriculares.Actividad;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BorrarActividadImpl implements BorrarActividad {

    @Override
    public boolean borrar(Actividad actividad) throws BorrarActividadEx{
        for(int ii = 0; ii < BaseDeDatos.actividades.size(); ii++){
            if(!actividad.equals(null)){
                try {
                    if(BaseDeDatos.getActividad(ii).getNombre().equals(actividad.getNombre()) && BaseDeDatos.getActividad(ii).isEstadoBorrador()){
                        BaseDeDatos.removePlan(ii);
                        return true;
                    }
                    else{
                        if(!BaseDeDatos.getActividad(ii).getNombre().equals(actividad.getNombre()))
                            throw new BorrarActividadEx("Actividad no encontrada");
                        if(!BaseDeDatos.getActividad(ii).isEstadoBorrador())
                            throw new BorrarActividadEx("Estado de la actividad diferente a borrardor");
                    }
                } catch (CloneNotSupportedException e) {
                    throw new BorrarActividadEx("no se pudo obtener la actividad" + ii);
                }
            }
            else{
                throw new BorrarActividadEx("La actividad es nula");
            }
        }
        return false;
    }   
}
