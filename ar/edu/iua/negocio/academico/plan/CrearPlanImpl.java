package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.modelo.academico.plan.AnioPlan;
import ar.edu.iua.modelo.academico.plan.Materia;
import ar.edu.iua.modelo.academico.plan.Plan;

public class CrearPlanImpl implements CrearPlan {

    public boolean crear(Plan plan) {
        if (plan == null) {
            System.out.println("plan null");
            return false;
        }
        if (!plan.isEstadoActivo() && !plan.isEstadoNoActivo() && !plan.isEstadoBorrador()) {
            System.out.println("plan sin estado");
            return false;
        }
        if (plan.getAnios() == null && !plan.isEstadoBorrador()) {
            System.out.println("plan anio null");
            return false;
        }
        if (plan.getAnio().intValue() < 1990 && plan.getAnio().intValue() > 2040) {
            System.out.println("plan anio mal");
            return false;
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getNombre() == null && !plan.isEstadoBorrador()) {
                System.out.println("plan nombre null");
                return false;
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getMaterias() == null && !plan.isEstadoBorrador()) {
                System.out.println("plan materias null");
                return false;
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getNumero() <= 0) {
                System.out.println("plan numero negativo");
                return false;
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getNumero() == null && !plan.isEstadoBorrador()) {
                System.out.println("plan numero null");
                return false;
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            if (anio.getMaterias() == null && !plan.isEstadoBorrador()) {
                System.out.println("plan materias null");
                return false;
            }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getCodigo() == null && !plan.isEstadoBorrador()) {
                    System.out.println("plan codigo null");
                    return false;
                }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getCodigo() <= 0) {
                    System.out.println("plan materia negativa");
                    return false;
                }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getNombre() == null && !plan.isEstadoBorrador()) {
                    System.out.println("plan nombre materia null");
                    return false;
                }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getCargaHoraria() == null && !plan.isEstadoBorrador()) {
                    System.out.println("plan carga horaria null");
                    return false;
                }
        }
        for (AnioPlan anio : plan.getAnios()) {
            for (Materia materia : anio.getMaterias())
                if (materia.getCargaHoraria() <= 0) {
                    System.out.println("plan materia carga 0");
                    return false;
                }
        }

        return true;
    }
}
