package ar.edu.iua.modelo.academico.actividadesExtraCurriculares;

import ar.edu.iua.modelo.Objeto;

public abstract class Profesor extends Objeto{

    abstract public Integer getCodigo();

    abstract public void setCodigo(Integer cod);

    abstract public String getNombre();

    abstract public void setNombre(String nombre);

    abstract public String getApellido();

    abstract public void setApellido(String apellido);

    abstract public String getDni();

    abstract public void setDni(String dni); 
    
    
}
