package Ejercicio;

public class Banco {
    protected String nombre;
    protected int numDeClientes;
    protected Cliente[] cliente;

    public Banco(String nombre){                                                //Nombre del banco y el array cliente
        this.nombre = nombre;
        cliente = new Cliente [50];
        this.numDeClientes = 0;
    }


    public String obtNombre(){                                                  //Devuelve el nombre
        return nombre;
    }
    
    
    public void cambiarNombre (String nom){                                     //Cambiar el nombre del banco
        this.nombre = nom;
    }
    

    public void adCliente (Cliente clie){                                      //Agrega clientes
        if (numDeClientes < cliente.length) {                                  //El numero de cliente, es menor a la longitud del Array
            cliente[numDeClientes] = clie;                                     //Agrega el cliente en la posicion "numDeClientes"
            numDeClientes++;
        } else {
            System.out.println("No se pueden agregar más clientes");
        }
    }

    
    public int obtenerNumClientes (){                                           //Devuelve el número de clientes en el banco.
      return numDeClientes;
    }
    
    
    public Cliente obtenerCliente (int posicion){                               //Devuelve el cliente en la posición especificada.
        return cliente[posicion];
    }
    
    
    public Cliente [] obtenerClientes(){                                        //Devuelve el array de clientes
      return cliente;
    }
}