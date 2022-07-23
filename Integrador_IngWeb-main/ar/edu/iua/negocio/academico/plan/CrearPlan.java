package ar.edu.iua.negocio.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.modelo.academico.plan.Plan;

public interface CrearPlan {

    /*
        Este metodo requiere que se guarde en la base de datos un plan
        Se debe validar y retornar false si:
            -+++++ plan no puede ser null  +++
            - +++++No se permite recibir un plan sin estado++
            - ++++No se permite un plan con año null, excepto si el estado es BORRADOR ++
            - ++++No se permite un plan con año < 1990 y > 2040++
            - ++++No se permite un listado de años null o vacio, excepto si el estado del plan es BORRADOR ++
            - *****No se permite un año con el att plan != del plan que se recibe [ej. plan.getAnios().get(0).getPlan().equals(plan) == false, es error ]-- no entiendo
            - ++++No se permite un año con el att numero <= 0, recordar que si el estado del plan es BORRADOR, este att puede ser null, pero nunca <= 0 ++
            - *****Los numeros de los años en el listado de años debe ser secuancial, comenzando en 1
            - *****No se puede repetir años con el mismo numero, en el mismo plan
            - ++++No se permite que un año del plan no tenga nombre, excepto si el estado del plan es BORRADOR ++
            - +++++No se permiten años con un listado de materias null o vacio, excepto si el estado del plan es BORRADOR
            - *****No se permite una materia con el att anioPlan != del anioPlan al q pertenece [ej. anioPlan.getMaterias().get(0).getAnioPlan().equals(anioPlan) == false, es error ]
            - *****No se permite una materia con el att codigo <= 0, recordar que si el estado del plan es BORRADOR, este att puede ser null, pero nunca <= 0 
            - *****Los numeros de las materias en el listado de materias de un año debe ser secuancial, comenzando en 1
            - *****No se permiten materias con el mismo codigo, en el mismo plan
            - ++++No se permite que una materia no tenga nombre, excepto si el estado del plan es BORRADOR 
            - ++++No se permite que una materia no tenga carga horaria, excepto si el estado del plan es BORRADOR 
            - ++++No se permite que una materias tenga carga horaria < 0, recordar que si el estado del plan es BORRADOR, este att puede ser null, pero nunca <= 0 
    */
    

    boolean crear(Plan plan) throws CrearPlanEx; 















    
}
