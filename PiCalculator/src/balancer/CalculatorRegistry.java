package balancer;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import compute.Compute;


public interface CalculatorRegistry extends Remote, Serializable{
	public void addComputeEngine(Compute ce) throws RemoteException;
	public void removeComputeEngine(Compute ce) throws RemoteException;
} 
