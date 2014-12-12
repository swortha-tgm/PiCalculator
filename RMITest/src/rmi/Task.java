package rmi;
/**
 * @author FOCK
 *
 * @param <T>
 */
public interface Task<T> {
    /**
     * @return
     */
    T execute();
}