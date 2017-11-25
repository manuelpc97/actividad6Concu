/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribucionchat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Juan Leonardo
 */
public interface Mensaje extends Remote {    
    void publicar(String mensaje) throws RemoteException;
    void publicarACliente(String mensaje) throws RemoteException;
    void registrar(Mensaje mensajeObj) throws RemoteException;
}
