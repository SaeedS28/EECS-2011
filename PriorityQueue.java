/**
 * An interface which defines all the methods required by the priority queue.
 * @author Saad
 *
 */
public interface PriorityQueue<K, V> {
	
	/**
	 * Gets the size of the priority queue.
	 * @return the size of the priority queue
	 */
	public int size();
	
	/**
	 * Returns whether or the priority queue is empty
	 * @return true if queue is empty, false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Inserts an entry in the priority queue based on ordering
	 * @param key the key
	 * @param value the value
	 * @return the entry just stored for future reference
	 * @throws IllegalArgumentException if the arguments provided are invalid
	 */
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException;
	
	/**
	 * Finds and retrieves the minimum entry
	 * @return the minmum entry.
	 */
	public Entry<K,V> min();
	
	/**
	 * Finds and removes the minimum entry within the priority queue
	 * @return the removed entry
	 */
	public Entry<K,V> removeMin();
}
