package ar.edu.iua.modelo_webservices.academico.actividadesExtraCurriculaesWs;

import ar.edu.iua.modelo.Objeto;

public abstract class AlumnoWs extends Objeto {
    
    abstract public Integer getId();

    abstract public void setId(int id);

    abstract public String getNombre();

    abstract public void setNombre(String nombre);

    abstract public String getApellido();

    abstract public void setApellido(String apellido);

}
