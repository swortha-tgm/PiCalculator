package engine;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import compute.Compute;
import compute.Task;

/**
 * Diese Klasse dient als Server. Sie verarbeitet die Anfragen der Clients
 * 
 * @author FOCK
 *
 */
public class ComputeEngine implements Compute {

	/**
	 * Konstruktor
	 */
	public ComputeEngine() {
		super();
	}

	/**
	 * Diese Methode ist fuer die Berechnung zustaendigs
	 */
	public <T> T executeTask(Task<T> t) {
		return t.execute();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setProperty("java.security.policy",
					"file:./policy/pi.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			String name = "Compute";
			Compute engine = new ComputeEngine();
			Compute stub = (Compute) UnicastRemoteObject
					.exportObject(engine, 0);
			Registry registry = LocateRegistry.getRegistry(1099);
			registry.rebind(name, stub);
			System.out.println("ComputeEngine bound");
		} catch (Exception e) {
			System.err.println("ComputeEngine exception:");
			e.printStackTrace();
		}
	}
}