package ar.edu.iua.interfazusuario;

import ar.edu.iua.Excepciones.modeloEx.BuscarPlanEx;

public interface BuscarEImprimirPlanes {
    

    // este metodo debe imprimir un listado de planes segun los terminos de busqueda
    // se valora que la impresion sea tabulada, con columnas o en forma de tarjetas
    
    // ej columnas
        //          PLAN        Años        Materias        ESTADO
        //          ----        ----        --------       -------- 
        //          2018          5            42          ACTIVO  
        //          2013          7            2           BORRADOR  

    // ej tarjetas
        //      -------------------------------------
        //      |  Plan de estudios 2108 (ACTIVO)   |         
        //      -------------------------------------
        //      -------------------------------------
        //      |  Plan de estudios 2013 (BORRADOR) |         
        //      -------------------------------------

    void buscar(String terminos) throws BuscarPlanEx;
    
}
