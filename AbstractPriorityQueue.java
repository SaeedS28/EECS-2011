import java.util.Comparator;

/**
 * An abstract class which implements some of the map interface's methods
 * @author Saad
 *
 */
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

	/**
	 * A class which implements the Entry interface
	 * @author Saad
	 *
	 */
	protected static class PQEntry<K,V> implements Entry<K,V>{
		private K key;
		private V value;
		
		public PQEntry(K key, V value){
			this.key=key;
			this.value=value;
		}
		
		protected void setKey(K k){
			this.key=k;
		}
		
		protected void setValue(V v){
			this.value=v;
		}
		
		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}
	}
	private Comparator<K> comp;//A comparator object for comparing
	
	/**
	 * A constructor which initializes the AbstrectPriorityQueue part of the
	 * object which will be used by the concrete classes
	 * @param c a user-defined comparator
	 */
	protected AbstractPriorityQueue(Comparator<K> c){
		comp=c;
	}
	
	/**
	 * Default cTor
	 */
	protected AbstractPriorityQueue(){
		this(new DefaultComparator<K>());
	}
	
	/**
	 * Compares two entries and returns the result as an integer
	 * @param a the first entry
	 * @param b the second entry
	 * @return an integer which represents the total order relationship
	 */
	protected int compare(Entry<K,V> a, Entry<K,V> b){
		return comp.compare(a.getKey(), b.getKey());
	}
	
	/**
	 * Checks to see if the key is valid or not
	 * @param key the key to test
	 * @return true if the key is valid
	 * @throws IllegalArgumentException if the key is invalid
	 */
	protected boolean checkKey(K key) throws IllegalArgumentException{
		try{
			return(comp.compare(key, key)==0);
		}catch(ClassCastException e){
			throw new IllegalArgumentException("Invalid key");
		}
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}
}
