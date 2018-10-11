/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seminaryrmiclient.logica;

import com.seminary.remote.InterfaceManagerClient;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import seminaryrmiclient.util.PropertyPc;


/**
 *
 * @author Ariel Arnedo
 */
public class ClientManager implements InterfaceManagerClient{
    
    @Override
    public void apagar() throws RemoteException {
//        try {
//            PropertyPc.getAtributoCliente().apagar();
//        } catch (Exception ex) {
//            throw new RemoteException("Error al apagar el equipo", ex);
//        }
        System.out.println("Apagar");
    }

    @Override
    public void reiniciar() throws RemoteException {
//        try {
//            PropertyPc.getAtributoCliente().reiniciar();
//        } catch (Exception ex) {
//            throw new RemoteException("Error al reiniciar el equipo", ex);
//        }
        System.out.println("Reiniciar");
    }

    @Override
    public int bloquear() throws RemoteException {
        System.out.println("bloquer");
        return 1;
    }

    @Override
    public int desbloquear() throws RemoteException {
        System.out.println("desbloquear");
        return  1;
    }

    @Override
    public int sendMessage(String string) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
