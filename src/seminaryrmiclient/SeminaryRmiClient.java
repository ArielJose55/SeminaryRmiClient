/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seminaryrmiclient;


import com.seminary.remote.InterfaceManagerClient;
import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.PropertyPermission;
import java.util.logging.Level;
import java.util.logging.Logger;
import seminaryrmiclient.logica.Client;
import seminaryrmiclient.util.PropertyPc;
import seminaryrmiclient.vista.MainFrameClient;

/**
 *
 * @author Ariel Arnedo
 */
public class SeminaryRmiClient {

    
    
    public static void main(String[] args) {
        PropertyPc.setCodeBase(InterfaceManagerClient.class);
        
         
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrameClient(new Client()).setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(SeminaryRmiClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AlreadyBoundException ex) {
                    Logger.getLogger(SeminaryRmiClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
//        
//        try{
//            String nombre="Control";
//            //Instanciar el registro RMI
//            Registry registro=LocateRegistry.getRegistry(5555);
//            //Instanciar un objeto de la clase del servidor
//            InterfaceManeger corredor = (InterfaceManeger) registro.lookup(nombre);
//           
//            corredor.apagar();
//            }catch (Exception e){
//                System.err.println("Excepción en el cliente de la bolsa:");
//                e.printStackTrace();
//            }
    }
//    
}
