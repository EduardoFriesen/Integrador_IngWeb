package ar.edu.iua.persistencia;

import java.util.ArrayList;
import java.util.List;

import ar.edu.iua.modelo.academico.actividadesExtraCurriculares.Actividad;
import ar.edu.iua.modelo.academico.plan.Plan;
import ar.edu.iua.modelo_webservices.academico.PlanWs;
import ar.edu.iua.modelo_webservices.academico.actividadesExtraCurriculaesWs.ActividadWs;

public class BaseDeDatos {

    public static List<Plan> planes = new ArrayList<Plan>();

    public static List<Actividad> actividades = new ArrayList<Actividad>();

    public static List<PlanWs> planesWebServices = new ArrayList<PlanWs>();

    public static List<ActividadWs> actividadesWs = new ArrayList<ActividadWs>();

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

    public static Actividad getActividad (int index) throws CloneNotSupportedException{
        
        try {
            return (Actividad)actividades.get(index).clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneNotSupportedException(e.getMessage());
        }  
    }

    public static boolean setActividad (int index, Actividad actividad){
        boolean bandera = false;
        try {
            actividades.set(index, (Actividad)actividad.clone());
            bandera = true;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return bandera;
    }
    
    public static boolean addActividad (Actividad actividad){
        boolean bandera = false;
        try {
            actividades.add((Actividad) actividad.clone());
            bandera = true;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return bandera;
    }

    public static void removeActividad (int index){
        actividades.remove(index);
    }

    public static List<Actividad> getListActividades (){
        List<Actividad> clonePlanes = new ArrayList<>();
        for(Actividad actividad:actividades){
            try {
                clonePlanes.add((Actividad)actividad.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return clonePlanes;
    }

    public static int planesSizeWs (){
        return planesWebServices.size();
    }

    public static PlanWs getPlanWs (int index) throws CloneNotSupportedException{
        
        return (PlanWs)planesWebServices.get(index).clone();
    }

    public static boolean setPlanWs (int index, PlanWs plan) throws CloneNotSupportedException{
        boolean bandera = false;
    
        planesWebServices.set(index, (PlanWs) plan.clone());
        bandera = true;
        
        return bandera;
    }
    
    public static boolean addPlanWs (PlanWs plan) throws CloneNotSupportedException{
        boolean bandera = false;
        
        planesWebServices.add((PlanWs) plan.clone());
        bandera = true;

        return bandera;
    }

    public static void removePlanWs (int index){
        planesWebServices.remove(index);
    }

    public static List<PlanWs> getListWs () throws CloneNotSupportedException{
        List<PlanWs> clonePlanes = new ArrayList<>();
        for(PlanWs plan:planesWebServices){
            clonePlanes.add((PlanWs)plan.clone());
        }
        return clonePlanes;
    }

    public static int actividadesSizeWs (){
        return actividadesWs.size();
    }

    public static ActividadWs getActividadesWs (int index) throws CloneNotSupportedException{
        
        return (ActividadWs)planesWebServices.get(index).clone();
    }

    public static boolean setActividadWs (int index, ActividadWs actividad) throws CloneNotSupportedException{
        boolean bandera = false;
    
        actividadesWs.set(index, (ActividadWs) actividad.clone());
        bandera = true;
        
        return bandera;
    }
    
    public static boolean addActividadWs (ActividadWs actividad) throws CloneNotSupportedException{
        boolean bandera = false;
        
        actividadesWs.add((ActividadWs) actividad.clone());
        bandera = true;

        return bandera;
    }

    public static void removeActividadWs (int index){
        actividadesWs.remove(index);
    }

    public static List<ActividadWs> getListActividadWs () throws CloneNotSupportedException{
        List<ActividadWs> clonePlanes = new ArrayList<>();
        for(ActividadWs actividad:actividadesWs){
            clonePlanes.add((ActividadWs)actividad.clone());
        }
        return clonePlanes;
    }
}
