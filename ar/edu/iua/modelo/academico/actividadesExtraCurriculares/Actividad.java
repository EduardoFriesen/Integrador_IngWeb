package ar.edu.iua.modelo.academico.actividadesExtraCurriculares;

import ar.edu.iua.modelo.Objeto;

public abstract class Actividad extends Objeto{
    

    abstract public Integer getCodigo();

    abstract public void setCodigo(Integer codigo);

    abstract public String getNombre();

    abstract public void setNombre(String nombre);

    abstract public void setEstadoBorrador();

    abstract public void setEstadoActivo();

    abstract public void setEstadoNoActivo();

    abstract public boolean isEstadoBorrador();

    abstract public boolean isEstadoActivo();

    abstract public boolean isEstadoNoActivo();

    abstract public Double getCargaHoraria();

    abstract public void setCargaHoraria(Double cargaHoraria);


}
