package test;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import engine.ComputeEngine;
import engine.CopyOfComputeEngine;
import static org.junit.Assert.*;

/**
 * @author FOCK
 *
 */
public class testComputeEngine {
	ComputeEngine c;
	CopyOfComputeEngine c1;

	/**
	 * 
	 */
	@Before
	public void init() {
		this.c = new ComputeEngine();
		this.c1 = new CopyOfComputeEngine();
	}

	/**
	 * @throws RemoteException
	 * 
	 */
	@Test
	public void testPi() throws RemoteException {
			Double d1 = c.calculatePi(3).doubleValue();
			Double d2 = c1.calculatePi(3).doubleValue();
			assertEquals(3.141, d1, 0.001);
			assertEquals(3.141, d2, 0.001);
	}
	
}
