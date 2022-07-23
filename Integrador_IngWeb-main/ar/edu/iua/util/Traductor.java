package ar.edu.iua.util;

public class Traductor {
   
    static public String TraducirCadena(String cadena){

        cadena = cadena.replace('ñ', 'n');
        cadena = cadena.replace('á','a');
        cadena = cadena.replace('é','e');
        cadena = cadena.replace('í','i');
        cadena = cadena.replace('ó','o');
        cadena = cadena.replace('ú','u');
        cadena = cadena.replace('ü','u');
        cadena = cadena.replaceAll("'", "");

        cadena.trim().toLowerCase();
        return cadena;
    }
}
