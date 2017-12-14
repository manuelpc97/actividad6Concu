/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribucionchat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Juan Leonardo
 */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author Juan Leonardo
 */
public class Servidor {

    

    public class Server {
        ArrayList<Cliente> lista = new ArrayList();
        Control control = new Control();
        int contador = 0;

        public Server() {
        }
        
        public void iniciarServidor() {
            try {
                // Crear el repositorio en el puerto 1099
                Registry registry = LocateRegistry.createRegistry(1099);
                // Crea un nuevo servicio y lo registra en el repositorio
                registry.rebind("miMensaje", new MensajeImpl());
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("El sistema esta listo");
            control.server = this;
            control.pack();
            control.setVisible(true);
        }
    }
    
    Server server;
    public void start(){
        server = new Server();
        server.iniciarServidor();
    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.start();

    }

}
