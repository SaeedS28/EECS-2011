/**
 * A map ADT which defines the methods required for a map.
 * @author Saad
 *
 */
public interface Map<K, V> {
	
	/**
	 * Returns the size of the map
	 * @return the size
	 */
	public int size();
	
	/**
	 * Checks to see if the map is empty
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Creates a new Entry (if one doesn't already exist) and and adds it to the map.
	 * Otherwise, updates the value of the existing entry.
	 * @param key the key for the entry.
	 * @param value the value associated with the key
	 * @return the old value associated with key, null if the entry does not exist.
	 * @throws InvalidKeyException if the key is invalid
	 */
	public V put(K key, V value) throws InvalidKeyException;
	
	/**
	 * Removes an already-existing entry.
	 * @param key the key for the entry to be removed
	 * @return the value associated with the removed entry
	 * @throws InvalidKeyException if the key is invalid.
	 */
	public V remove(K key) throws InvalidKeyException;
	
	/**
	 * Returns the value associated with key.
	 * @param key the key
	 * @return the value
	 * @throws InvalidKeyException if the key is invalid.
	 */
	public V get(K key) throws InvalidKeyException;
	
	/**
	 * Returns the collection of keys for iteration
	 * @return a collection of keys
	 */
	public Iterable<K> keySet();
	
	/**
	 * Returns the collection of values for iteration
	 * @return a collection of values
	 */
	public Iterable<V> values();
	
	/**
	 * Returns the set of entries for iteration
	 * @return a collection of entries
	 */
	public Iterable<Entry<K,V>> entrySet();
}
