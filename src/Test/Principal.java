package Test;
import Ejercicio.Banco;
import Ejercicio.Cliente;
import Ejercicio.Empresa;
import Ejercicio.Persona;
//import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        ArrayList<Persona> cliente1 = new ArrayList<>();                                                                 
//        ArrayList<Empresa> empresa1 = new ArrayList<>();                                               
        
        System.out.print("Ingresar nombre del banco: ");
        String nombreBanco = scanner.nextLine();                                                      //Almacenará la entrada del usuario.
        Banco banco = new Banco(nombreBanco);                                                        //se utiliza el constructor (creando el objeto)

        System.out.print("Ingresar la cantidad de clientes a registrar: ");
        int cantC = scanner.nextInt();
        scanner.nextLine();
        
        for(int i = 0; i < cantC; i++){
            System.out.println("\n########## Datos del cliente ##########");
            System.out.print("Ingrese el nombre del cliente: ");
            String nomCliente = scanner.nextLine();
            System.out.print("Ingrese numero de identificacion del cliente: ");
            String cedCliente = scanner.nextLine();
            System.out.print("Ingrese la edad del cliente: ");
            int edad = scanner.nextInt();
            scanner.nextLine();
            Persona nuevoCliente = new Persona(cedCliente, edad, nomCliente);                   
            banco.adCliente(nuevoCliente);                                                          //agrega cliente
            //cliente1.add(new Persona(cedulaCliente, nombreCliente, edad));
        }
        
        System.out.print("\nIngresar la cantidad de empresas a registrar: ");
        int cantE = scanner.nextInt();
        scanner.nextLine();
        
        for(int i = 0; i < cantE; i++){    
            System.out.println("\n########## Datos de la empresa ##########");
            System.out.print("Ingrese el nombre de la empresa: ");                                       //Ingresar información de las empresas
            String nomEmpresa = scanner.nextLine();
            System.out.print("Ingrese el representante de la empresa: ");
            String repreEmpresa = scanner.nextLine();
            System.out.print("Ingrese el NIT de la empresa: ");
            String nitEmpresa = scanner.nextLine();
                                                                                                                                //Se agregan los argumentos
            Empresa nuevoEmpleado = new Empresa(nitEmpresa, repreEmpresa, nomEmpresa);                     //Crear un cliente Empresa, Se usa el constructor.    
            banco.adCliente(nuevoEmpleado);                                                                                 //nuevClie, se agrega al banco por medio de (addClie)   
        }                                                                                                
            
        int opcion;
        do {
            System.out.println("\nMenu");
            System.out.println("1. Todos los nombres de los clientes");
            System.out.println("2. Nombres y numero de identificacion de los clientes");
            System.out.println("3. Nombre y representante de cada empresa");
            System.out.println("4. Nombres de los clientes menores de edad");
            System.out.println("5. Nombre y edad del cliente mas joven");
            System.out.println("6. Nombre y edad del cliente mas viejo");
            System.out.println("7. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("\nNombres de todos los clientes del banco: ");
                    for (int i = 0; i < banco.obtenerNumClientes(); i++) {                                             //numero total de clientes en el banco
                        Cliente cliente = banco.obtenerCliente(i);                                             //Obtiene el cliente en la posición i del banco y lo guarda en "cliente"
                        if (cliente instanceof Persona) {                                                             //verifica  si el cliente obtenido, es una instancia de clase "Persona"
                            System.out.println("Cliente: " + cliente.obtenerNombre());
                        }
                            else if (cliente instanceof Empresa) {
                            System.out.println("Empresa: " + cliente.obtenerNombre());
                        }
                    }
                    break;              
                
                case 2:
                    System.out.println("\nNombres y numero de identificacion de los clientes:");
                    for (Cliente cliente : banco.obtenerClientes()) {                                                       //bucle for-each, que recorre todos los clientes del banco. 
                        if (cliente instanceof Persona){
                            Persona persona = (Persona) cliente;                                                            //convierte cliente a una instancia de Persona
                            System.out.println("Nombre: " + persona.obtenerNombre() + ", Numero de identificacion: " + persona.obtenerIdentificacion());
                        }
                    }
                    break;
                    
                    
                case 3:
                    System.out.println("\nNombre y representante de cada empresa:");
                    for (Cliente cliente : banco.obtenerClientes()) {
                        if (cliente instanceof Empresa) {
                            Empresa empresa = (Empresa) cliente;
                            System.out.println("Nombre: " + empresa.obtenerNombre()+ ", Representante: " + empresa.obtenerRepresentante());
                        }
                    }
                    break;
                    
                     
                case 4:
                    System.out.println("\nNombres de clientes menores de edad:");
                    for (Cliente cliente : banco.obtenerClientes()) {
                        if (cliente instanceof Persona) {
                            Persona persona = (Persona) cliente;
                            if (persona.getEdad() < 18)
                                System.out.println("Nombre: " + persona.obtenerNombre() + ", Edad: " + persona.getEdad());
                        }
                    }
                    break;

                
                case 5:
                    System.out.println("\nNombre y edad del cliente mas joven:");
                    Cliente clienteMasJoven = null;
                        for (Cliente cliente : banco.obtenerClientes()) {
                            if (cliente instanceof Persona) {
                                if (clienteMasJoven == null || ((Persona) cliente).obtenerEdad() < ((Persona) clienteMasJoven).obtenerEdad())
                                    clienteMasJoven = cliente;
                            }
                        }
                        if (clienteMasJoven != null)
                            System.out.println("Nombre: " + clienteMasJoven.obtenerNombre() + ", Edad: " + ((Persona) clienteMasJoven).getEdad());
                        break;        

                    
                case 6:
                    System.out.println("\nNombre y edad del cliente mas viejo:");
                    Cliente clienteMasViejo = null;
                    for (Cliente cliente : banco.obtenerClientes()) {
                        if (cliente instanceof Persona) {
                            if (clienteMasViejo == null || ((Persona) cliente).obtenerEdad() > ((Persona) clienteMasViejo).obtenerEdad())
                                clienteMasViejo = cliente;
                        }
                    }
                    if (clienteMasViejo != null)
                        System.out.println("Nombre: " + clienteMasViejo.obtenerNombre()+ ", Edad: " + ((Persona) clienteMasViejo).getEdad());
                    break;
                    

                case 7:
                    System.out.println("\nSaliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Ingrese un numero entre 1 y 7.");
            }
        } while (opcion != 7);

    }
}
    

