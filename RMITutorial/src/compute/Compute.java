package compute;
 
import java.rmi.Remote;
import java.rmi.RemoteException;
 
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