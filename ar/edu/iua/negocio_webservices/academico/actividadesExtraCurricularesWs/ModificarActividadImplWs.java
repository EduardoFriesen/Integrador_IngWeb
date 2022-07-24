package ar.edu.iua.negocio_webservices.academico.actividadesExtraCurricularesWs;

import ar.edu.iua.Excepciones.ActividadEx.CrearActividadEx;
import ar.edu.iua.Excepciones.ActividadEx.ModificarActividadEx;
import ar.edu.iua.modelo.academico.actividadesExtraCurriculares.Actividad;
import ar.edu.iua.persistencia.BaseDeDatos;

public class ModificarActividadImplWs implements ModificarActividadWs {

    public boolean modificar(Actividad actividad) throws CrearActividadEx, ModificarActividadEx {
        boolean b = false;   
        CrearActividadWs crearActividad = new CrearActividadImplWs(); 
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
