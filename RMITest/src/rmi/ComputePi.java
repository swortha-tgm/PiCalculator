package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.math.BigDecimal;

/**
 * @author FOCK
 *
 */
public class ComputePi implements Compute{
    /**
     * @param args
     */
    public static void main(String args[]) {
    	String policy = "grant{permission java.security.AllPermission;};";
		System.setProperty("java.security.policy", policy.toString());
        /*if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }*/
        try {
            String name = "Hallo";
            Registry registry = LocateRegistry.getRegistry("192.168.175.1");
            Compute comp = (Compute) registry.lookup(name);
            Pi task = new Pi(Integer.parseInt("5"));
            BigDecimal pi = comp.pi(5);
            System.out.println(pi); 
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }

	

	@Override
	public BigDecimal pi(int anzahl_nachkommastellen) {
		return null;
		
	}    
}