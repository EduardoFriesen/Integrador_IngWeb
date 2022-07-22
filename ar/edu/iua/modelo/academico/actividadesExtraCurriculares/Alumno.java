package ar.edu.iua.modelo.academico.actividadesExtraCurriculares;

import ar.edu.iua.modelo.Objeto;

public abstract class Alumno extends Objeto {
    
    abstract public Integer getId();

    abstract public void setId(int id);

    abstract public String getNombre();

    abstract public void setNombre(String nombre);

    abstract public String getApellido();

    abstract public void setApellido(String apellido);

}
