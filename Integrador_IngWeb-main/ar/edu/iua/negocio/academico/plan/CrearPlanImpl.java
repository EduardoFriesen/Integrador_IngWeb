package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.EX.CrearPlanEx;
import ar.edu.iua.modelo.academico.plan.AnioPlan;
import ar.edu.iua.modelo.academico.plan.Materia;
import ar.edu.iua.modelo.academico.plan.Plan;

public class CrearPlanImpl implements CrearPlan {

    public boolean crear(Plan plan) throws CrearPlanEx{
        if (plan == null) {
            throw new CrearPlanEx("El plan es nulo");
        }
        if (!plan.isEstadoActivo() && !plan.isEstadoNoActivo() && !plan.isEstadoBorrador()) {
            throw new CrearPlanEx("El plan sin Estado");
        }
        if (plan.getAnios() == null && !plan.isEstadoBorrador()) {
            throw new CrearPlanEx("Anio plan nulo");
        }
        if (plan.getAnio().intValue() < 1990 && plan.getAnio().intValue() > 2040) {
            throw new CrearPlanEx("Anio Plan Incorrecto");
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getNombre() == null && !plan.isEstadoBorrador()) {
                throw new CrearPlanEx("Nombre del plan Nulo");
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getMaterias() == null && !plan.isEstadoBorrador()) {
                throw new CrearPlanEx("Plan materia nulo");
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getNumero() <= 0) {
                throw new CrearPlanEx("numero plan menor que 0");
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getNumero() == null && !plan.isEstadoBorrador()) {
                throw new CrearPlanEx("numero plan nulo");
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getMaterias() == null && !plan.isEstadoBorrador()) {
                throw new CrearPlanEx("plan materias nula");
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getCodigo() == null && !plan.isEstadoBorrador()) {
                    throw new CrearPlanEx("codigo plan nulo");
                }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getCodigo() <= 0) {
                    throw new CrearPlanEx("numero materia menor que 0");
                }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getNombre() == null && !plan.isEstadoBorrador()) {
                    throw new CrearPlanEx("plan nombre materia nulo");
                }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getCargaHoraria() == null && !plan.isEstadoBorrador()) {
                    throw new CrearPlanEx("carga horaria nula");
                }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getCargaHoraria() <= 0) {
                    throw new CrearPlanEx("Carga horaria nula");
                }
        }

        return true;
    }
}
