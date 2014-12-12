package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author FOCK
 *
 */
public class ComputeEngine   {

    /**
     * 
     */
    public ComputeEngine() {
        super();
    }

 

    /**
     * @param args
     */
    public static void main(String[] args) {
    	String policy = "grant{permission java.security.AllPermission;};";
		System.setProperty("java.security.policy", policy.toString());
		  /*if (System.getSecurityManager() == null) {
        System.setSecurityManager(new SecurityManager());
    }*/
        try {
            String name = "Hallo";
            ComputePi engine = new ComputePi();

            Compute stub =
                (Compute) UnicastRemoteObject.exportObject(engine, 0);

            Registry registry = LocateRegistry.getRegistry();

           registry.bind(name, stub);

            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}