package engine;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import client.Pi;
import balancer.CalculatorRegistry;
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
			Registry registry = LocateRegistry.getRegistry("localhost", 1099); //als Port wurde 1009 gewaehlt
			CalculatorRegistry cr = (CalculatorRegistry) registry.lookup("balancer");
			cr.addComputeEngine(engine);
			System.out.println("ComputeEngine bound");
		} catch (Exception e) {
			System.err.println("ComputeEngine exception:");
			e.printStackTrace();
		}
	}

	@Override
	public BigDecimal calculatePi(int decimalPlaces) throws RemoteException {
		return new Pi().calculatePi(decimalPlaces);
	}
}