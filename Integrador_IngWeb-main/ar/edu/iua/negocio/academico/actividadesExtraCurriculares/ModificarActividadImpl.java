package ar.edu.iua.negocio.academico.actividadesExtraCurriculares;

import ar.edu.iua.Excepciones.ActividadEx.CrearActividadEx;
import ar.edu.iua.Excepciones.ActividadEx.ModificarActividadEx;
import ar.edu.iua.modelo.academico.actividadesExtraCurriculares.Actividad;
import ar.edu.iua.persistencia.BaseDeDatos;

public class ModificarActividadImpl implements ModificarActividad {

    public boolean modificar(Actividad actividad) throws CrearActividadEx, ModificarActividadEx {
        boolean b = false;   
        CrearActividad crearActividad = new CrearActividadImpl(); 
        try{
            
            b = crearActividad.crear(actividad);
            }catch (CrearActividadEx e1){
              throw new ModificarActividadEx(e1.getMessage());  
            }
            if(b){
                for(int i = 0; i < BaseDeDatos.actividades.size(); i++){
                if(BaseDeDatos.actividades.get(i).getNombre().equals(actividad.getNombre())){
                    try {
                        BaseDeDatos.actividades.set(i, (Actividad)actividad.clone());
                    } catch (CloneNotSupportedException e) {
                        throw new ModificarActividadEx("No se pudo acceder al indice " + i );
                    }
                    return false;
                }
            }
        }

        return true;
    }
}
