package ar.edu.iua.modelo_webservices.academico;

import java.util.ArrayList;
import java.util.List;

//import ar.edu.iua.modelo.academico.plan.AnioPlan;

public class AnioPlanImplWs extends AnioPlanWs{
    private Integer numero;
    private String nombre;
    private List<MateriaImplWs> materias = new ArrayList<>();

    public AnioPlanImplWs(){}

    public AnioPlanImplWs(Integer numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = (nombre != null && nombre.trim().length() > 0) ? nombre.trim() : null;
        this.nombre = nombre;
    }

    public List<MateriaImplWs> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaImplWs> materias) {
        this.materias = materias;
    }

    // ----

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AnioPlanImplWs other = (AnioPlanImplWs) obj;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

    public String toString() {
        return nombre != null ? nombre : (numero != null ? "Año " + numero : "Año sin identificación");
    }

    public String toStringFull() {

        String z = (numero != null ? numero.toString() : "") + "\n" + (nombre != null ? nombre.toString() : "") + "\n";

        for (MateriaWs materia : materias) {
            String m = materia.toStringFull().trim();
            z += (m.length() > 0) ? m + "\n" : "";
        }

        return z.trim();
    }

    public String toJsonFull() {

        String z = (numero != null ? "{\n \"anio\" : " + numero.toString() + " ," : "") + "\n" + 
                    (nombre != null ? " \"nombre\" : \"" + nombre.toString() + "\" ," : "") + "\n" + "\"materias\" : [";


        for (int ii = 0; ii < materias.size(); ii++) {
            String m = materias.get(ii).fullToJson();
            if(ii == materias.size()-1){
                z += (m.length() > 0) ? m + "\n" : "";
            }
            else{
                z += (m.length() > 0) ? m + "," : "";
            }
        }

        z += " ]\n }";

        return z.trim();
    }

    public Object clone() throws CloneNotSupportedException {
        AnioPlanWs anio = (AnioPlanWs) super.clone();
        List<MateriaImplWs> auxMaterias = new ArrayList<>();
        for (MateriaWs materia : this.materias) {
            if (materia != null) {
                auxMaterias.add((MateriaImplWs) materia.clone());
            }
        }
        anio.setMaterias(auxMaterias);
        return anio;
    }

    public String fullToJson() {
        return null;
    }
}
