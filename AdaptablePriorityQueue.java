/**
 * An interface which defines the methods which an adaptable 
 * priority queue must define
 * @author Saad
 *
 */
public interface AdaptablePriorityQueue<K, V> extends PriorityQueue<K,V> {
	
	/**
	 * Removes and returns any key within the priority queue.
	 * @param e the entry to be removed
	 * @throws IllegalArgumentException if the the arguments passed are illegal
	 */
	public void remove(Entry<K,V> e) throws IllegalArgumentException;
	
	/**
	 * Replaces the key of an entry
	 * @param e the entry
	 * @param key the new key
	 * @throws IllegalArgumentException if the key is invalid
	 */
	public void replaceKey(Entry<K,V> e, K key) throws IllegalArgumentException;
	
	/**
	 * Replaces the value of an entry
	 * @param e entry
	 * @param value the new value
	 * @throws IllegalArgumentException if the arguments are invalid
	 */
	public void replaceValue(Entry<K,V> e, V value) throws IllegalArgumentException;
}
