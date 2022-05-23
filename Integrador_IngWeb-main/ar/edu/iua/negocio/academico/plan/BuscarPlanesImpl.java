package ar.edu.iua.negocio.academico.plan;

import java.util.ArrayList;
import java.util.List;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;
import ar.edu.iua.util.Traductor;

public class BuscarPlanesImpl implements BuscarPlanes {
    public List<Plan> buscar(String terminos) {
        List<Plan> planesBuscados = new ArrayList<Plan>();

        terminos = Traductor.TraducirCadena(terminos);
        String[] arrayTerm = terminos.trim().toLowerCase().split(" ");
        
        vuelta: for (Plan plan : BaseDeDatos.planes) {
            String toStringFull = plan.toStringFull().toLowerCase();
            for (String termino : arrayTerm) {
                if (toStringFull.contains(termino.toLowerCase())) {
                    planesBuscados.add(plan);
                    continue vuelta;
                }
            }
        }
        return planesBuscados;
    }

}