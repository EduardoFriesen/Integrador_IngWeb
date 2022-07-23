package ar.edu.iua.modelo_webservices.academico;

public class MateriaImplWs extends MateriaWs{

    private Integer codigo;
    private String nombre;
    private Double cargaHoraria;

    public MateriaImplWs(){

    }
    
    public MateriaImplWs(Integer codigo, String nombre, Double cargaHoraria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cargaHoraria = cargaHoraria;
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
        nombre = (nombre != null && nombre.trim().length() > 0 ) ? nombre.trim() : null;
        this.nombre = nombre;
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
        MateriaImplWs other = (MateriaImplWs) obj;
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

    public String toStringFull() {

        String s = (nombre != null ? nombre.toString() : "") + "\n" +
        (codigo != null ? codigo.toString() : "") + "\n" + (cargaHoraria != null ? cargaHoraria.toString() : "") + "\n";

        return s.trim();
    }

    public String fullToJson() {

        String s = (nombre != null ? " \"nombre\" : \"" + nombre.toString() + "\" ," : "") + "\n" +
        (codigo != null ? " \"codigo\" : " + codigo.toString() + " ," : "") + "\n" + (cargaHoraria != null ? " \"Carga Horaria\" : " + cargaHoraria.toString() + " \n}" : "") + "\n";

        return s.trim();
    }

}
