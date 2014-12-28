package compute;
 
/** Interface
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