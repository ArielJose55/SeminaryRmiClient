/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seminaryrmiclient.util;

import com.seminary.remote.HostPc;

/**
 *
 * @author Ariel Arnedo
 */
public class PropertyPc {
    
    public static final int MENSAJE_DE_CHAT = 0;
    public static final int MENSAJE_DE_BLOQUEO = 1;
    
    private static PropertyPc cliente = null;
    
    private PropertyHost sistemaOperativo;

    public PropertyPc() {
        String os = System.getProperty("os.name");
        if(os.startsWith("Windows")){
            sistemaOperativo = PropertyHost.WINDOWS;
        }else if(os.compareTo("Linux i386") == 0 || os.compareTo("Linux amd64") == 0){
            sistemaOperativo = PropertyHost.LINUX;
        }else if(os.compareTo("Mac OS X") == 0){
            sistemaOperativo = PropertyHost.MAC; 
        }
    }
    
    public static PropertyPc getAtributoCliente(){
        if(cliente == null){
            cliente = new PropertyPc();
        }
        return cliente;
    }
    
    public static void main(String ard[]){
        PropertyPc.setCodeBase(HostPc.class);
    }
    
    public static void setCodeBase(Class <?> c){
        String path = c.getProtectionDomain().getCodeSource().getLocation().toString();
        String pathCodebase = System.getProperty("java.rmi.server.codebase");
        if(pathCodebase != null && pathCodebase.compareTo("") != 0){
            path = pathCodebase + " " + path;
        }
        System.setProperty("java.rmi.server.codebase" , path );
    }
    
    public void apagar() throws Exception{
        if(sistemaOperativo.equals(PropertyHost.WINDOWS)){
            Runtime.getRuntime().exec("shutdown -s");
        }else if(sistemaOperativo.equals(PropertyHost.LINUX)){
            Runtime.getRuntime().exec("halt");
        }else if(sistemaOperativo.equals(PropertyHost.MAC)){
            Runtime.getRuntime().exec("sudo halt");
        }else{
            throw new Exception("Sistema Operativo no compatible");
        }
    }
    
    public void reiniciar() throws Exception{
        if(sistemaOperativo.equals(PropertyHost.WINDOWS)){
            Runtime.getRuntime().exec("shutdown -r");
        }else if(sistemaOperativo.equals(PropertyHost.LINUX)){
            Runtime.getRuntime().exec("shutdown -r now");
        }else if(sistemaOperativo.equals(PropertyHost.MAC)){
            Runtime.getRuntime().exec("sudo reboot");
        }else{
            throw new Exception("Sistema Operativo no compatible");
        }
    }
    
    public PropertyHost getSistemaOperativo(){
        return sistemaOperativo;
    }

}
