package ar.edu.iua.util;

import ar.edu.iua.Excepciones.modeloEx.VerificadorEx;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.modelo_webservices.academico.PlanWs;

public class VerificarIntegridad {
    

    static public boolean verificadorIntegridadPlan(Plan plan) throws VerificadorEx{

        //Verificacion del Plan

        if(plan == null) throw new VerificadorEx("Error. El plan es nulo. VerificarIntegridad.java");//Plan no puede ser null
        if(plan.getAnio() == null && !plan.isEstadoBorrador()) throw new VerificadorEx("Error. El anio es nulo y el plan no es borrador. VerificarIntergidad.java"); //No se permite plan con anio nulo, excepto que sea un borrador
        if(plan.getAnio().intValue() < 1990 || plan.getAnio().intValue()>2040) throw new VerificadorEx("Error. El anio del plan no se encuentra en el rango establecido. VerificarIntegridad.java"); //No se permite plan con anio 1990 < anio < 2040
        if((plan.getAnios()==null || plan.getAnios().size()==0) && !plan.isEstadoBorrador()) throw new VerificadorEx("Error. El listado de anios tiene un elemento nulo y el plan no es borrador. VerificarIntergidad.java");//No se permite listado de anios null o vacio, excepto que sea un borrador
        for(int ii = 0; ii < plan.getAnios().size(); ii++){ //Recorre el listado de aniosPlan
            if(!plan.getAnios().get(ii).getPlan().equals(plan)) throw new VerificadorEx("Error. El anio no corresponde al del plan. VerificarIntegridad.java"); //No se permite un anio con plan distinto al que pertenece
            if(plan.getAnios().get(ii).getNumero() == null && !plan.isEstadoBorrador())throw new VerificadorEx("Error. El numero de anio es nulo y el estado no es borrador. VerificarIntegridad.java"); //No se permite que el numero de anio sea null, excepto que sea un borrador
            if(plan.getAnios().get(ii).getNumero() != null){
                if(plan.getAnios().get(ii).getNumero().intValue()<=0) throw new VerificadorEx("Error. El numero de anio es menor o igual a cero y el estado no es borrador. VerificarIntegridad.java"); //No se permite que el numero de anio sea menor igual a 0
                if(plan.getAnios().get(ii).getNumero().intValue() < 1) throw new VerificadorEx("Error. El anio no comienza en 1. VerificarIntegridad.java");//anio comienza en 1
                if(plan.getAnios().get(ii).getNumero().intValue() != ii+1) throw new VerificadorEx("Error. El orden de los anios no es secuencial. VerificarIntegridad.java");//anios orden secuencial
                for(int jj = 0; jj < plan.getAnios().size();jj++){
                    if(ii != jj){
                        if(plan.getAnios().get(ii).getNumero().equals(plan.getAnios().get(jj).getNumero())) throw new VerificadorEx("Error. Existen anios con el mismo numero. VerificarIntegridad.java");//No se permiten anios con el mismo numero
                    } 
                }
            }
            if(plan.getAnios().get(ii).getNombre() == null && !plan.isEstadoBorrador()) throw new VerificadorEx("Error. El anio no tiene nombre y el estado no es borrador. VerificarIntegridad.java");//No se permite un anio sin nombre excepto que sea borrador
            if((plan.getAnios().get(ii).getMaterias() ==null || plan.getAnios().get(ii).getMaterias().size() == 0) && !plan.isEstadoBorrador()) throw new VerificadorEx("Error. El listado de materias es nulo y el estado no es borrador. VerificarIntegridad.java");//No se permite un listado de materias null o vacio excepto que sea borrador
            for(int kk = 0;kk < plan.getAnios().get(ii).getMaterias().size();kk++){
                if(!plan.getAnios().get(ii).getMaterias().get(kk).getAnio().equals(plan.getAnios().get(ii)))throw new VerificadorEx("Error. El anioPlan no es igual al del plan. VerificarIntegridad.java");//No se permite que una materia tenga un anioPlan distinto al que pertenece
                if((plan.getAnios().get(ii).getMaterias().get(kk).getCodigo() == null) && !plan.isEstadoBorrador())throw new VerificadorEx("Error. Existen materias con codigo null y el estado no es borrador. VerificarIntegridad.java");//No se permite una materia de codigo null, excepto que sea borrador
                if(plan.getAnios().get(ii).getMaterias().get(kk).getCodigo() != null){
                    if(plan.getAnios().get(ii).getMaterias().get(kk).getCodigo().intValue() <= 0) throw new VerificadorEx("Error. El codigo de la materia es menor o igual a cero. VerificarIntegridad.java");//No se permite materia con el codigo menor igual a 0
                    if(plan.getAnios().get(ii).getMaterias().get(kk).getCodigo().intValue() < 1) throw new VerificadorEx("Error. El codigo de la materia no empieza en 1. VerificarIntegridad.java");//Codigo materia comienza en 1
                }
                if(kk!=0){
                    String actual = plan.getAnios().get(ii).getMaterias().get(kk).getCodigo().toString().substring(plan.getAnios().get(ii).getMaterias().get(kk).getCodigo().toString().length()-2);
                    String anterior = plan.getAnios().get(ii).getMaterias().get(kk-1).getCodigo().toString().substring(plan.getAnios().get(ii).getMaterias().get(kk).getCodigo().toString().length()-2);
                    if(actual.equals(anterior)) throw new VerificadorEx("Error. El orden de la materias no es secuencialVerificarIntegridad.java"); //Orden de las materias secuencial
                }
                for(int hh = 0; hh < plan.getAnios().get(ii).getMaterias().size(); hh++){
                    if(kk!=hh){
                        if(plan.getAnios().get(ii).getMaterias().get(hh).getCodigo().equals(plan.getAnios().get(ii).getMaterias().get(kk).getCodigo())) throw new VerificadorEx("Error. Existen materias con el mismo codigo. VerificarIntegridad.java");//No se permiten materias con el mismo codigo
                    }
                }
                if((plan.getAnios().get(ii).getMaterias().get(kk).getNombre() == null) && !plan.isEstadoBorrador()) throw new VerificadorEx("Error. Existen materias con nombre nulo y el estado no es borrador. VerificarIntegridad.java");//No se permiten materias con nombre null, excepto que sea borrador
                if((plan.getAnios().get(ii).getMaterias().get(kk).getCargaHoraria() == null) && !plan.isEstadoBorrador()) throw new VerificadorEx("Error. La carga horario es nula y el estado no es borrador. VerificarIntegridad.java");//No se permiten materias con carga horaria null, excepto que sea borrador 
                if(plan.getAnios().get(ii).getMaterias().get(kk).getCargaHoraria() != null){
                    if(plan.getAnios().get(ii).getMaterias().get(kk).getCargaHoraria().doubleValue() <= 0.0) throw new VerificadorEx("Error. La carga horaria es menor o igual a cero. VerificarIntegridad.java");//No se permiten materias con carga horaria <=0
                }
            }
        }

        return true;
    } 


    static public boolean verificarIntegridadPlanWs (PlanWs plan) throws VerificadorEx{
        //Verificacion del Plan

        if(plan == null) throw new VerificadorEx("Error. El plan es nulo. VerificarIntegridad.java");//Plan no puede ser null
        if(plan.isEstadoNulo())throw new VerificadorEx("Error. El plan no tiene estado. VerificarIntegridad.java"); //No se permiten planes sin estado
        if(plan.getAnio() == null && !plan.isEstadoBorrador()) throw new VerificadorEx("Error. El anio es nulo y el plan no es borrador. VerificarIntergidad.java"); //No se permite plan con anio nulo, excepto que sea un borrador
        if(plan.getAnio().intValue() < 1990 || plan.getAnio().intValue()>2040) throw new VerificadorEx("Error. El anio del plan no se encuentra en el rango establecido. VerificarIntegridad.java"); //No se permite plan con anio 1990 < anio < 2040
        if((plan.getAnios()==null || plan.getAnios().size()==0) && !plan.isEstadoBorrador()) throw new VerificadorEx("Error. El listado de anios tiene un elemento nulo y el plan no es borrador. VerificarIntergidad.java");//No se permite listado de anios null o vacio, excepto que sea un borrador
        for(int ii = 0; ii < plan.getAnios().size(); ii++){ //Recorre el listado de aniosPlan
            if(plan.getAnios().get(ii).getNumero() == null && !plan.isEstadoBorrador())throw new VerificadorEx("Error. El numero de anio es nulo y el estado no es borrador. VerificarIntegridad.java"); //No se permite que el numero de anio sea null, excepto que sea un borrador
            if(plan.getAnios().get(ii).getNumero() != null){
                if(plan.getAnios().get(ii).getNumero().intValue()<=0) throw new VerificadorEx("Error. El numero de anio es menor o igual a cero y el estado no es borrador. VerificarIntegridad.java"); //No se permite que el numero de anio sea menor igual a 0
                if(plan.getAnios().get(ii).getNumero().intValue() < 1) throw new VerificadorEx("Error. El anio no comienza en 1. VerificarIntegridad.java");//anio comienza en 1
                if(plan.getAnios().get(ii).getNumero().intValue() != ii+1) throw new VerificadorEx("Error. El orden de los anios no es secuencial. VerificarIntegridad.java");//anios orden secuencial
                for(int jj = 0; jj < plan.getAnios().size();jj++){
                    if(ii != jj){
                        if(plan.getAnios().get(ii).getNumero().equals(plan.getAnios().get(jj).getNumero())) throw new VerificadorEx("Error. Existen anios con el mismo numero. VerificarIntegridad.java");//No se permiten anios con el mismo numero
                    } 
                }
            }
            if(plan.getAnios().get(ii).getNombre() == null && !plan.isEstadoBorrador()) throw new VerificadorEx("Error. El anio no tiene nombre y el estado no es borrador. VerificarIntegridad.java");//No se permite un anio sin nombre excepto que sea borrador
            if((plan.getAnios().get(ii).getMaterias() ==null || plan.getAnios().get(ii).getMaterias().size() == 0) && !plan.isEstadoBorrador()) throw new VerificadorEx("Error. El listado de materias es nulo y el estado no es borrador. VerificarIntegridad.java");//No se permite un listado de materias null o vacio excepto que sea borrador
            for(int kk = 0;kk < plan.getAnios().get(ii).getMaterias().size();kk++){
                if((plan.getAnios().get(ii).getMaterias().get(kk).getCodigo() == null) && !plan.isEstadoBorrador())throw new VerificadorEx("Error. Existen materias con codigo null y el estado no es borrador. VerificarIntegridad.java");//No se permite una materia de codigo null, excepto que sea borrador
                if(plan.getAnios().get(ii).getMaterias().get(kk).getCodigo() != null){
                    if(plan.getAnios().get(ii).getMaterias().get(kk).getCodigo().intValue() <= 0) throw new VerificadorEx("Error. El codigo de la materia es menor o igual a cero. VerificarIntegridad.java");//No se permite materia con el codigo menor igual a 0
                    if(plan.getAnios().get(ii).getMaterias().get(kk).getCodigo().intValue() < 1) throw new VerificadorEx("Error. El codigo de la materia no empieza en 1. VerificarIntegridad.java");//Codigo materia comienza en 1
                }
                if(kk!=0){
                    String actual = plan.getAnios().get(ii).getMaterias().get(kk).getCodigo().toString().substring(plan.getAnios().get(ii).getMaterias().get(kk).getCodigo().toString().length()-2);
                    String anterior = plan.getAnios().get(ii).getMaterias().get(kk-1).getCodigo().toString().substring(plan.getAnios().get(ii).getMaterias().get(kk).getCodigo().toString().length()-2);
                    if(actual.equals(anterior)) throw new VerificadorEx("Error. El orden de la materias no es secuencialVerificarIntegridad.java"); //Orden de las materias secuencial
                }
                for(int hh = 0; hh < plan.getAnios().get(ii).getMaterias().size(); hh++){
                    if(kk!=hh){
                        if(plan.getAnios().get(ii).getMaterias().get(hh).getCodigo().equals(plan.getAnios().get(ii).getMaterias().get(kk).getCodigo())) throw new VerificadorEx("Error. Existen materias con el mismo codigo. VerificarIntegridad.java");//No se permiten materias con el mismo codigo
                    }
                }
                if((plan.getAnios().get(ii).getMaterias().get(kk).getNombre() == null) && !plan.isEstadoBorrador()) throw new VerificadorEx("Error. Existen materias con nombre nulo y el estado no es borrador. VerificarIntegridad.java");//No se permiten materias con nombre null, excepto que sea borrador
                if((plan.getAnios().get(ii).getMaterias().get(kk).getCargaHoraria() == null) && !plan.isEstadoBorrador()) throw new VerificadorEx("Error. La carga horario es nula y el estado no es borrador. VerificarIntegridad.java");//No se permiten materias con carga horaria null, excepto que sea borrador 
                if(plan.getAnios().get(ii).getMaterias().get(kk).getCargaHoraria() != null){
                    if(plan.getAnios().get(ii).getMaterias().get(kk).getCargaHoraria().doubleValue() <= 0.0) throw new VerificadorEx("Error. La carga horaria es menor o igual a cero. VerificarIntegridad.java");//No se permiten materias con carga horaria <=0
                }
            }
        }

        return true;
    }

  
}
