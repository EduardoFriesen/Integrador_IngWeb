package ar.edu.iua;

import ar.edu.iua.Excepciones.modeloEx.BuscarPlanEx;
import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
import ar.edu.iua.util.Pruebas;

public class Main {

    public static void main(String[] args) throws CrearPlanEx, BuscarPlanEx, ModificarPlanEx {
        System.out.println("Comienzo de main\n\n");

        Pruebas pruebas = new Pruebas();
        pruebas.probar();


        System.out.println("\n\nFin de main");
    }

}