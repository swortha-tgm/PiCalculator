package engine;
 
import java.rmi.Remote;
import java.rmi.RemoteException;

import compute.Task;
 
/** Erbt von Remote um eine RemoteException zu werfen
 * @author FOCK
 *
 */
public interface Compute extends Remote {
    /**
     * @param t
     * @return
     * @throws RemoteException
     */
    <T> T executeTask(Task<T> t) throws RemoteException;
}