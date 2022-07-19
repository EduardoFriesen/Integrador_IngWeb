package ar.edu.iua.modelo_webservices.academico;

import ar.edu.iua.modelo.Objeto;

public abstract class MateriaWs extends Objeto{
    abstract public Integer getCodigo();

    abstract public void setCodigo(Integer codigo);

    abstract public String getNombre();

    abstract public void setNombre(String nombre);

    abstract public Double getCargaHoraria();

    abstract public void setCargaHoraria(Double cargaHoraria);
}
