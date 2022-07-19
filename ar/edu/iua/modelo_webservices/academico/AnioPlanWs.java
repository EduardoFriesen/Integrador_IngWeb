package ar.edu.iua.modelo_webservices.academico;

import java.util.List;

import ar.edu.iua.modelo.Objeto;

public abstract class AnioPlanWs extends Objeto {

    abstract public Integer getNumero();

    abstract public void setNumero(Integer numero);

    abstract public String getNombre();

    abstract public void setNombre(String nombre);

    abstract public List<MateriaImplWs> getMaterias();

    abstract public void setMaterias(List<MateriaImplWs> materias);

}
