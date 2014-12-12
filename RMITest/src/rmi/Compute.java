package rmi;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author FOCK
 *
 */
public interface Compute extends Remote {
	/**
	 * @param anzahl_nachkommastellen
	 * @return
	 */
	public BigDecimal pi(int anzahl_nachkommastellen);
}