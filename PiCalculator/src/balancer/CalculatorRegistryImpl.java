package balancer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import compute.Compute;

/**
 * @author Simon Wortha
 * @version 20150107
 * 
 * Regestry
 */
public class CalculatorRegistryImpl extends UnicastRemoteObject implements CalculatorRegistry {
	private List<Compute> servers;

	/**
	 * @throws RemoteException
	 */
	public CalculatorRegistryImpl() throws RemoteException {
		super();
		this.servers = new ArrayList<>();
	}

	@Override
	public void addComputeEngine(Compute c) throws RemoteException {
		System.out.println("adding new server");
		servers.add(c);
	}

	@Override
	public void removeComputeEngine(Compute c) throws RemoteException {
		servers.remove(c);

	}

	/**
	 * @return gibt die Liste der Server zurueck
	 */
	public List<Compute> getServerList() {
		return servers;
	}

}
