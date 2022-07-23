package ar.edu.iua.modelo_webservices;

public abstract class objetoWebServices implements Cloneable {

    abstract public int hashCode();

    abstract public boolean equals(Object obj);

    abstract public String toString();

    abstract public String fullToString ();

    abstract public String fullToJson();


    @Override
    public Object clone() throws CloneNotSupportedException {
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }
}
