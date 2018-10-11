/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seminaryrmiclient.logica;

import com.seminary.remote.HostPc;
import com.seminary.remote.InterfaceManagerClient;
import com.seminary.remote.InterfaceManagerServer;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ariel Arnedo
 */
public class Client {
    
    private final ClientManager clientManager;
    private InterfaceManagerServer severManager;
    private String ipAddress;
    private String nameHost;
    

    public Client() throws RemoteException, AlreadyBoundException {
        this.clientManager = new ClientManager();
        initComponents();
        startConnectionClient();
    }
    
    private void initComponents(){
        try {
            ipAddress = java.net.InetAddress.getLocalHost().getHostAddress();
            nameHost = java.net.InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void startConnectionClient() throws RemoteException, AlreadyBoundException{
        InterfaceManagerClient stub = (InterfaceManagerClient) UnicastRemoteObject.exportObject(clientManager, 0);        
        Registry registry = LocateRegistry.createRegistry(5556);
        registry.bind("Control", stub);
    }
    
    public void connect() throws RemoteException, NotBoundException{
        Registry registro = LocateRegistry.getRegistry(5555);
        severManager = (InterfaceManagerServer) registro.lookup("ServerManager");
    }
    
    public boolean sendInformationClient() throws RemoteException{
        return severManager.sendSuccessfulConnection(atributeHost()) > 0;
    }
    
    private HostPc atributeHost(){
        return new HostPc(ipAddress, nameHost);
    }
    
}
