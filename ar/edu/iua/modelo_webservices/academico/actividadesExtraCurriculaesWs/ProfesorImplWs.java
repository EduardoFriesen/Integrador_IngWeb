package ar.edu.iua.modelo_webservices.academico.actividadesExtraCurriculaesWs;

public class ProfesorImplWs extends ProfesorWs{
    
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String nacionalidad;

    public ProfesorImplWs(Integer id, String nombre, String apellido, Integer edad, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }
    public ProfesorImplWs(){
        
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNacionalidad(String nacionalidad){
        this.nacionalidad = nacionalidad;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    // getters
    public Integer getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public Integer getEdad(){
        return edad;
    }

    public String getNacionalidad(){
        return nacionalidad;
    }
    public String getApellido() {
        return apellido;
    }



    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
            ProfesorImplWs other = (ProfesorImplWs) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public String toString() {
        String id = this.id != null ? this.id + "" : "";
        String nombre = this.nombre != null ? this.nombre : "";

        return (nombre + " " + id).trim();
    }

    public String toStringFull() {

        String s = (id != null ? this.id : "") + "\n" + (nombre != null ? nombre.toString() : "") + "\n" +
        (edad != null ? this.edad : "") + "\n" + (nacionalidad != null ? nacionalidad.toString() : "") + "\n";

        return s.trim();
    }

    
    public String fullToJson() {
        
        return null;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}

