package balancer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import compute.Compute;



public class CalculatorRegistryImpl extends UnicastRemoteObject implements CalculatorRegistry {
	private List<Compute> servers;
	
	
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
	public List<Compute> getServerList() {
		return servers;
	}

}
