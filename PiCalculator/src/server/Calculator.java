package server;

import java.math.BigDecimal;
import java.rmi.RemoteException;

/** Dies ist das Interface fuer den RMI-Server.
 * @author FOCK
 *
 */
public interface Calculator extends java.rmi.Remote{
	/**
	 * @param anzahl_nachkommastellen
	 * @return
	 * @throws RemoteException
	 */
	public BigDecimal pi(int anzahl_nachkommastellen) throws RemoteException;
}
