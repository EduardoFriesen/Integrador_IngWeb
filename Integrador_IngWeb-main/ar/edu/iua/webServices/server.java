package ar.edu.iua.webServices;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import ar.edu.iua.Excepciones.web_services_ex.*;
import ar.edu.iua.webServices.Controladores.plan.BorrarPlanHandler;
import ar.edu.iua.webServices.Controladores.plan.BorrarPlanesHandler;
import ar.edu.iua.webServices.Controladores.plan.BuscarPlanHandler;
import ar.edu.iua.webServices.Controladores.plan.BuscarPlanesHandler;
import ar.edu.iua.webServices.Controladores.plan.CrearPlanHandler;
import ar.edu.iua.webServices.Controladores.plan.CrearPlanesHandler;
import ar.edu.iua.webServices.Controladores.plan.ModificarPlanHandler;
import ar.edu.iua.webServices.Controladores.plan.ModificarPlanesHandler;



public class server {


    public static void startServer() throws serverEx{

        try{
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            //plan
            server.createContext("/buscarPlan", new BuscarPlanHandler()); //http://localhost:8080/buscarPlan
            server.createContext("/buscarPlanes", new BuscarPlanesHandler() ); //http://localhost:8080/buscarPlanes
            server.createContext("/borrarPlan", new BorrarPlanHandler()); //http://localhost:8080/borrarPlan
            server.createContext("/borrarPlanes", new BorrarPlanesHandler()); //http://localhost:8080/borrarPlanes
            server.createContext("/crearPlan", new CrearPlanHandler()); //http://localhost:8080/crearPlan
            server.createContext("/crearPlanes", new CrearPlanesHandler()); //http://localhost:8080/crearPlanes
            server.createContext("/modificarPlan", new ModificarPlanHandler()); //http://localhost:8080/modificarPlan
            server.createContext("/modificarPlanes", new ModificarPlanesHandler()); //http://localhost:8080/modificarPlanes
           
            
            
            server.setExecutor(null); // creates a default executor
            server.start();            
            
            System.out.print("Servidor escuchando en ");
            System.out.print(server.getAddress().getHostName().equals("0:0:0:0:0:0:0:0") ? "localhost" : server.getAddress().getHostString());            
            System.out.print(":");
            System.out.print(server.getAddress().getPort());
            System.out.println();


        }
        catch(IOException e){
            throw new serverEx("404: Not found");
        }

    }

}
