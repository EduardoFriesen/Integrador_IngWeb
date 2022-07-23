package ar.edu.iua.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ar.edu.iua.modelo.academico.plan.AnioPlan;
import ar.edu.iua.modelo.academico.plan.Materia;
//import ar.edu.iua.modelo.academico.plan.Materia;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.persistencia.BaseDeDatos;

public class Printeador {
    static public void PrintBusqueda(List<Plan> buscados) {

        int anio = 0;
        int opcion = 0;
        Scanner consola = new Scanner(System.in);

        do {    
            System.out.println("+------------------+");
            System.out.println("| " + "Menu de opciones" + " |");
            System.out.println("+------------------+");                                                   
            System.out.println("+-------------------------------------------------+");
            System.out.println("| " + "Ingrese [3] Para ver la Base de Datos. " + "         |");
            System.out.println("| " + "Ingrese [2] Para ver las Materias por su Anio. " + " |");
            System.out.println("| " + "Ingrese [1] Para ver los Planes. " + "               |");
            System.out.println("| " + "Ingrese [0] Para salir e iniciar el servidor" + "    |");
            System.out.println("+-------------------------------------------------+");
                opcion = consola.nextInt();
            if (opcion != 0) {

                if (opcion == 3) {
                    PrintPlan(BaseDeDatos.planes);

                } else if (opcion == 2) {
                    System.out.println("+-------------------------------------------------+");
                    System.out.println("| " + "Ingrese el numero de anio para ver sus materias" + " |");
                    System.out.println("+-------------------------------------------------+");
                    anio = consola.nextInt();
                    PrintPlanDetalle(anio, buscados);
                
                } else if (opcion == 1) {
                    System.out.println("+-----------------------------------------------------------------+");
                    System.out.println("|\t" + "PLAN\t      ANIOS\t     MATERIAS\t\tESTADO" + "    |");
                    System.out.println("+-----------------------------------------------------------------+");

                    for (int ii = 0; ii < buscados.size(); ii++) {
                        Plan plan = buscados.get(ii);
                        int materias = ContarMaterias(plan);
                        String estado = DevolverEstado(plan);
                        if (estado == "BORRADOR"){
                            System.out.println("|\t" + plan.getAnio().intValue() + "\t\t" + plan.getAnios().size() + "\t\t" + materias + "\t\t" + estado +  "  |");
                        } else {
                            System.out.println("|\t" + plan.getAnio().intValue() + "\t\t" + plan.getAnios().size() + "\t\t" + materias + "\t\t" + estado + "    |");
                        }
                        }
                        System.out.println("+-----------------------------------------------------------------+");
               
                } else {
                    System.out.println("+-----------------------+");
                    System.out.println("| Ingrese opcion valida |");
                    System.out.println("+-----------------------+");
                }
            }
            } while (opcion != 0);
                System.out.println("+-----------------------+");
                System.out.println("| Iniciando Servidor... |");
                System.out.println("+-----------------------+");
                consola.close();
            }

    static void PrintPlanDetalle(int anio, List<Plan> buscados) {

        List<Plan> plan1 = new ArrayList<>();

        for (int ii = 0; ii < buscados.size(); ii++) {
            Plan plan = buscados.get(ii);
            if (plan.getAnio().intValue() == anio) {
                plan1.add(plan);
                PrintPlan(plan1);
                break;
            } else if (ii == buscados.size() - 1) {
                System.out.println("No se encontro el plan. Ingrese un valor valido.");
            }
        }
    }

    static public void PrintPlan(List<Plan> planes) {
        for (Plan plan1 : planes) {
            System.out.println("\n" + plan1);
            for (AnioPlan anio : plan1.getAnios()) {
                System.out.println("\t" + anio);
                for (Materia materia : anio.getMaterias()) {
                    System.out.println("\t\t" + String.format("%1$" + 2 + "s", materia.getCodigo())
                            + " - " + materia);
                }
                if (anio.getMaterias().size() == 0) {
                    System.out.println("\t\tA este año no se le cargaron materias!!");
                }
            }
            if (plan1.getAnios().size() == 0) {
                System.out.println("\tA este plan no se le cargaron años!!");
            }
        }
    }

    static private int ContarMaterias(Plan plan) {
        int cantidad = 0;
        for (AnioPlan anio : plan.getAnios()) {
            cantidad = anio.getMaterias().size() + cantidad;
        }
        return cantidad;
    }

    static private String DevolverEstado(Plan plan) {

        if (plan.isEstadoActivo()) {
            return "ACTIVO";
        }
        if (plan.isEstadoBorrador()) {
            return "BORRADOR";
        }
        if (plan.isEstadoNoActivo()) {
            return "NO ACTIVO";
        } else {
            return null;
        }
    }

}
