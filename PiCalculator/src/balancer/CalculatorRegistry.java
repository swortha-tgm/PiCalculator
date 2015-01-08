package balancer;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import compute.Compute;

/**
 * @author Wortha Simon
 * 
 *         Calculator Registry Interface
 */
public interface CalculatorRegistry extends Remote, Serializable {
	/**
	 * @param ce
	 *            der Server der geadded wird
	 * @throws RemoteException
	 */
	public void addComputeEngine(Compute ce) throws RemoteException;

	/**
	 * @param ce
	 *            der Server der geloescht werden soll
	 * @throws RemoteException
	 */
	public void removeComputeEngine(Compute ce) throws RemoteException;
}
