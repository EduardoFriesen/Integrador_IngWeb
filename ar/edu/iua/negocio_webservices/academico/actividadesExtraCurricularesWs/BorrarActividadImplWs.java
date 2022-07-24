package ar.edu.iua.negocio_webservices.academico.actividadesExtraCurricularesWs;

import ar.edu.iua.Excepciones.ActividadEx.BorrarActividadEx;
import ar.edu.iua.modelo_webservices.academico.actividadesExtraCurriculaesWs.ActividadWs;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BorrarActividadImplWs implements BorrarActividadWs {

    @Override
    public boolean borrar(ActividadWs actividadWs) throws BorrarActividadEx{
        for(int ii = 0; ii < BaseDeDatos.actividades.size(); ii++){
            if(!actividadWs.equals(null)){
                try {
                    if(BaseDeDatos.getActividad(ii).getNombre().equals(actividadWs.getNombre()) && BaseDeDatos.getActividad(ii).isEstadoBorrador()){
                        BaseDeDatos.removePlan(ii);
                        return true;
                    }
                    else{
                        if(!BaseDeDatos.getActividad(ii).getNombre().equals(actividadWs.getNombre()))
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
