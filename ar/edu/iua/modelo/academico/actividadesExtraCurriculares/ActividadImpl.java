package ar.edu.iua.modelo.academico.actividadesExtraCurriculares;


public class ActividadImpl extends Actividad{
    
    private Integer codigo;
    private String nombre;
    private Estado estado;
    private Double cargaHoraria;

    private enum Estado {
        BORRADOR,
        ACTIVO,
        NO_ACTIVO
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = (nombre != null && nombre.trim().length() > 0) ? nombre.trim() : null;
        this.nombre = nombre;
    }

    public void setEstadoBorrador() {
        estado = Estado.BORRADOR;
    }

    public void setEstadoActivo() {
        estado = Estado.ACTIVO;
    }

    public void setEstadoNoActivo() {
        estado = Estado.NO_ACTIVO;
    }

    public boolean isEstadoBorrador() {
        return estado == Estado.BORRADOR;
    }

    public boolean isEstadoActivo() {
        return estado == Estado.ACTIVO;
    }

    public boolean isEstadoNoActivo() {
        return estado == Estado.NO_ACTIVO;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ActividadImpl other = (ActividadImpl) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    public String toString() {
        String cargaHoraria = this.cargaHoraria != null ? "(" + this.cargaHoraria + ")" : "";
        String nombre = this.nombre != null ? this.nombre : "";

        return (nombre + " " + cargaHoraria).trim();
    }

    @Override
    public String toStringFull() {

        String s = (nombre != null ? nombre.toString() : "") + "\n" + (nombre != null ? nombre.toString() : "") + "\n" +
        (codigo != null ? codigo.toString() : "") + "\n" + (cargaHoraria != null ? cargaHoraria.toString() : "") + "\n";

        return s.trim();
    }

}
