package ar.edu.iua.persistencia;

import java.util.ArrayList;
import java.util.List;

import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.modelo_webservices.academico.PlanWs;

public class BaseDeDatos {

    private static List<Plan> planes = new ArrayList<Plan>();

    private static List<Plan> planesWebServices = new ArrayList<Plan>();

    public static Plan getPlan (int index) throws CloneNotSupportedException{
        
        try {
            return (Plan)planes.get(index).clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneNotSupportedException(e.getMessage());
        }  
    }

    public static boolean setPlan (int index, Plan plan){
        boolean bandera = false;
        try {
            planes.set(index, (Plan)plan.clone());
            bandera = true;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return bandera;
    }
    
    public static boolean addPlan (Plan plan){
        boolean bandera = false;
        try {
            planes.add((Plan) plan.clone());
            bandera = true;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return bandera;
    }

    public static void removePlan (int index){
        planes.remove(index);
    }

    public static List<Plan> getList (){
        List<Plan> clonePlanes = new ArrayList<>();
        for(Plan plan:planes){
            try {
                clonePlanes.add((Plan)plan.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return clonePlanes;
    }

    public static int planesSizeWs(){
        return planesWebServices.size();
    }

    public static PlanWs getPlanWs (int index) throws CloneNotSupportedException{
        return (PlanWs)planesWebServices.get(index).clone();
    }
    
}
