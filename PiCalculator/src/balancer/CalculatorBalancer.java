package balancer;
import java.math.BigDecimal;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import client.Pi;
import compute.Compute;
import compute.Task;
import engine.ComputeEngine;

/**
 * 
 * @author Simon Wortha
 *
 */
public class CalculatorBalancer extends UnicastRemoteObject implements Compute {
	private CalculatorRegistryImpl cr;
	
	public CalculatorBalancer() throws RemoteException, AlreadyBoundException {
		super(); 
		this.cr = new CalculatorRegistryImpl();
		
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.bind("balancer", this.cr);
		registry.bind("Compute", this);
	}
	
	
	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		new CalculatorBalancer();
	}



	@Override
	public BigDecimal calculatePi(int decimalPlaces) throws RemoteException {
		// TODO
		Compute c = cr.getServerList().get(0);
		
		
		
		
		System.out.println("Leite Anfrage an " + c.toString());
		return c.calculatePi(decimalPlaces);
	}
	
}
