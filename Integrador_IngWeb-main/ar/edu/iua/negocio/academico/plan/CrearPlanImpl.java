package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.modelo.academico.plan.AnioPlan;
import ar.edu.iua.modelo.academico.plan.Materia;
//import ar.edu.iua.modelo.academico.plan.Materia;
import ar.edu.iua.modelo.academico.plan.Plan;

public class CrearPlanImpl implements CrearPlan {

    public boolean crear(Plan plan) throws CrearPlanEx {
        if(plan == null){
            throw new CrearPlanEx("El plan es nulo.");//Plan no puede ser null
        }
        if (!plan.isEstadoActivo() && !plan.isEstadoNoActivo() && !plan.isEstadoBorrador()) {
            return false;
        }
        if (plan.getAnios() == null && !plan.isEstadoBorrador()) {
            throw new CrearPlanEx("plan anio null");
        }
        if (plan.getAnio().intValue() < 1990 && plan.getAnio().intValue() > 2040) {
            throw new CrearPlanEx("plan anio mal");
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getNombre() == null && !plan.isEstadoBorrador()) {
                throw new CrearPlanEx("plan nombre null");
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getMaterias() == null && !plan.isEstadoBorrador()) {
                throw new CrearPlanEx("plan materias null");
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getNumero() <= 0) {
                throw new CrearPlanEx("plan numero negativo");
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getNumero() == null && !plan.isEstadoBorrador()) {
                throw new CrearPlanEx("plan numero null");
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getMaterias() == null && !plan.isEstadoBorrador()) {
                throw new CrearPlanEx("plan materias null");
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getCodigo() == null && !plan.isEstadoBorrador()) {
                    throw new CrearPlanEx("plan codigo null");
                }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getCodigo() <= 0) {
                    throw new CrearPlanEx("plan materia negativa");
                }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getNombre() == null && !plan.isEstadoBorrador()) {
                    throw new CrearPlanEx("plan nombre materia null");
                }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getCargaHoraria() == null && !plan.isEstadoBorrador()) {
                    throw new CrearPlanEx("plan carga horaria null");
                }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getCargaHoraria() <= 0) {
                    throw new CrearPlanEx("plan materia carga 0");
                }
        }

        return true;
    }
}
