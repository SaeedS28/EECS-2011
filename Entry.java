/**
 * An  interface which encapsulates an entry
 * @author Saad
 *
 */
public interface Entry<K, V> {

	/**
	 * Returns the key associated with the entry
	 * @return the key
	 */
	public K getKey();
	
	/**
	 * Returns the value associated with the entry
	 * @return the key
	 */
	public V getValue();
}
