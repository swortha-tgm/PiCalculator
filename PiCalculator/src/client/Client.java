package client;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.Calculator;

/**
 * @author FOCK
 *
 */
public class Client {
	/**
	 * @param ip
	 * @param digits
	 */
	public Client(String ip, int digits) {
		try {
			
			System.out.println("starting client...");
			Registry registry = LocateRegistry.getRegistry(ip);
			Calculator piServer = (Calculator) registry.lookup("Calculator");
			BigDecimal pi = piServer.pi(digits);
			System.out.println("Client: " + pi.toString());
		} catch (RemoteException e) { 
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}
}