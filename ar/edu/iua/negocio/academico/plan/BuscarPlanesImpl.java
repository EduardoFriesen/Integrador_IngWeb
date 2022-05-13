package ar.edu.iua.negocio.academico.plan;

import java.util.ArrayList;
import java.util.List;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class BuscarPlanesImpl implements BuscarPlanes {
    public List<Plan> buscar(String terminos) {
        List<Plan> r = new ArrayList<Plan>();
        String[] arrayTerm = terminos.split(" ");
        vuelta:
        for (Plan p : BaseDeDatos.planes) {
            String toStringFull = p.toStringFull().toLowerCase();
            for (String termino : arrayTerm) {
                if (toStringFull.contains(termino.toLowerCase())) {
                    r.add(p);
                    continue vuelta;
                }
            }
        }
        return r;
    }

}
