package ar.edu.iua.modelo.academico.actividadesExtraCurriculares;

import ar.edu.iua.modelo.Objeto;
import ar.edu.iua.modelo.academico.plan.AnioPlan;

public abstract class Actividad extends Objeto{
    
    abstract public AnioPlan getAnio();

    abstract void setAnio(AnioPlan anio);

    abstract public Integer getCodigo();

    abstract public void setCodigo(Integer codigo);

    abstract public String getNombre();

    abstract public void setNombre(String nombre);

    abstract public Double getCargaHoraria();

    abstract public void setCargaHoraria(Double cargaHoraria);


}
