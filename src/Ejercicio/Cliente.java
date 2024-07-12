package Ejercicio;

public abstract class Cliente {
    protected String nombre;   

//Metodo constructor
    public Cliente(String nombre) {
        this.nombre = nombre; 
}

//Metodo
    public String obtenerNombre(){
        return nombre;
}
    
//Metodo Abstracto
    public abstract String obtenerIdentificacion();  
}
