package ar.edu.iua.negocio.academico.actividadesExtraCurriculares;

import ar.edu.iua.Excepciones.ActividadEx.BuscarActividadEx;
import ar.edu.iua.modelo.academico.actividadesExtraCurriculares.Actividad;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BuscarActividadImpl implements BuscarActividad {

    @Override
    public Actividad buscar(String nombre) throws BuscarActividadEx{
        for(int ii = 0; ii < BaseDeDatos.actividades.size(); ii++){
            try {
                if(BaseDeDatos.getActividad(ii).getNombre() == nombre){
                    return BaseDeDatos.getActividad(ii);
                }
            } catch (CloneNotSupportedException e) {
                throw new BuscarActividadEx("No se pudo obtener el plan " + ii );
            }
        }
        throw new BuscarActividadEx("No se encontro el plan");
    }
    
}
