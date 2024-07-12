package Ejercicio;

public class Empresa extends Cliente{
    private String nit;
    private String representante;
    
//Constructor
    public Empresa (String nit, String representante, String nombre){
        super (nombre);
        this.nit = nit;
        this.representante = representante;
    }

    
//Get y set  
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }
    
    
    
    
//Metodo  
    public String obtenerIdentificacion(){   
        return nit;
    }
    
    
//Metodo    
    public String obtenerRepresentante(){ 
        return representante;    
    }
    
//Metodo
    public String cambiarRepresentante(String nuevoRepre){
        this.representante = nuevoRepre;
        return representante;
    }
    
       
//    public String mostrar(){
//        return "Empresa" + "\nnit: " + this.nit
//                        + "\nrepresentante: " + this.representante;
    
 
}
