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
	private int counter = 0;

	public CalculatorBalancer() throws RemoteException, AlreadyBoundException {
		super();
		System.out.println("Balancer is online...");
		System.out.println("Now you can add some Server/ComputeEngines");
		this.cr = new CalculatorRegistryImpl();

		Registry registry = LocateRegistry.createRegistry(1099);
		registry.bind("balancer", this.cr);
		registry.bind("Compute", this);
	}

	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException {
		new CalculatorBalancer();
	}

	@Override
	public BigDecimal calculatePi(int decimalPlaces) throws RemoteException {
		int help = cr.getServerList().size();
		if (counter == help)
			counter = 0;
		System.out.println(help);
		System.out.println("Counter 1: " + counter);
		Compute c = cr.getServerList().get(counter);
		counter += 1;
		System.out.println("Leite Anfrage an " + c.toString());
		
		System.out.println("Counter 2: " + counter);
		return c.calculatePi(decimalPlaces);
	}

}
