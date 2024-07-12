package Ejercicio;

public class Persona extends Cliente{
    private String cedula;
    private int edad;
 
    
//Metodo constructor    
    public Persona (String cedula,int edad, String nombre){
        super(nombre);
        this.cedula = cedula;
        this.edad = edad;
    }
    

////Get y set      
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
        
    
//Metodo
    @Override
    public String obtenerIdentificacion(){
        return cedula;
    }   

//Metodo
    public int obtenerEdad(){
        return edad;
     }

//Metodo
//    public void cumplirAños() {
//        edad++;
//    }
    
//    public String mostrar(){
//        return "Empresa" + "\nCedula: " + this.cedula
//                        + "\nEdad: " + this.edad;

}
