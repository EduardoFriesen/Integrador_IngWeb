package ar.edu.iua.util;

import java.util.List;

import ar.edu.iua.interfazusuario.BuscarEImprimirPlanes;
import ar.edu.iua.interfazusuario.BuscarEImprimirPlanesImpl;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.negocio.academico.plan.BuscarPlan;
import ar.edu.iua.negocio.academico.plan.BuscarPlanImpl;
import ar.edu.iua.negocio.academico.plan.CrearPlanes;
import ar.edu.iua.negocio.academico.plan.CrearPlanesImpl;
import ar.edu.iua.negocio.academico.plan.ModificarPlan;
import ar.edu.iua.negocio.academico.plan.ModificarPlanImpl;
import java.util.Scanner;
import ar.edu.iua.persistencia.BaseDeDatos;

public class Pruebas {


    public void probar() {

        List<Plan> planes = GenerarEjemplosDePlanes.generar(5, false);

        System.out.println("\n\nSe crearon " + planes.size() + " planes.");

        Scanner teclado = new Scanner(System.in);

        CrearPlanes crearPlanes = new CrearPlanesImpl();

        boolean ok = crearPlanes.crear(planes);
        
        System.out.println("\n\nSe crearon " +BaseDeDatos.planes.size() + " planes.");

        if (ok) {
            GenerarEjemplosDePlanes.imprimirPlanes(BaseDeDatos.planes);
        }

        ModificarPlan modificarPlan = new ModificarPlanImpl();

        BaseDeDatos.planes.get(0).setAnio(2050);
        BaseDeDatos.planes.get(1).setAnio(2003);

        boolean okk = modificarPlan.modificar(BaseDeDatos.planes.get(0));
        System.out.println("Se modifico el plan " + planes.get(0) + " ? = " + (okk ? "SI" : "NO"));

        okk = modificarPlan.modificar(planes.get(1));
        System.out.println("Se modifico el plan " + planes.get(1) + " ? = " + (okk ? "SI" : "NO"));

        GenerarEjemplosDePlanes.imprimirPlanes(BaseDeDatos.planes);

        BuscarEImprimirPlanes buscarEImprimirPlanes = new BuscarEImprimirPlanesImpl();

        BuscarPlan buscarPlan = new BuscarPlanImpl();
        
        System.out.println("Ingrese valores de busqueda");
        System.out.println(buscarPlan.buscar(teclado.nextInt()));
        
        
        //buscarEImprimirPlanes.buscar(teclado.next());

        
    }

}
