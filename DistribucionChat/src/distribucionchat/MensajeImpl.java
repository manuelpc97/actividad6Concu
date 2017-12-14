/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distribucionchat;

/**
 *
 * @author Juan Leonardo
 */
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ListIterator;
import java.util.Vector;

public class MensajeImpl extends UnicastRemoteObject implements Mensaje {

    private Vector<Mensaje> clienteObj = null;
    public ClienteGUI cGUI;

    public MensajeImpl() throws RemoteException {
        clienteObj = new Vector<Mensaje>();
    }

    public MensajeImpl(ClienteGUI cGUI) throws RemoteException {
        clienteObj = new Vector<Mensaje>();
        this.cGUI = cGUI;
    }

    public void publicar(String mensaje, int num) throws RemoteException {
        System.out.println("Mensaje: " + mensaje);
        ListIterator cliOI = clienteObj.listIterator();
        while (cliOI.hasNext()) {
            Mensaje m = ((Mensaje) cliOI.next());
            m.publicarACliente(mensaje, num);
        }

    }

    public ClienteGUI getGUI() {
        return cGUI;
    }

    public void publicarACliente(String mensaje, int num) throws RemoteException {
        if (num == 0 || cGUI.cliente.id == num) {
            cGUI.actualizarTexto(mensaje);
        }
    }

    public void registrar(Mensaje mensajeObj) throws RemoteException {
        clienteObj.add(mensajeObj);
        this.cGUI = mensajeObj.getGUI();
    }
}
