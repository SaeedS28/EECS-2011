import java.util.Comparator;

/**
 * A concrete class which implements the adaptable priority queue interface
 * @author Saad
 *
 *  
 */
public class HeapAdaptablePriorityQueue<K, V> extends HeapPriorityQueue<K, V> implements AdaptablePriorityQueue<K, V> {

	protected static class AdaptablePQEntry<K,V> extends PQEntry<K,V>{
		private int index;
		
		public AdaptablePQEntry(K key, V value, int j){
			super(key,value);
			index=j;
		}
		
		public void setIndex(int j){
			index=j;
		}
		
		public int getIndex(){
			return index;
		}
	}
	
	public HeapAdaptablePriorityQueue(){
		super();
	}
	
	public HeapAdaptablePriorityQueue(Comparator<K> comp){
		super(comp);
	}
	
	@Override
	public void remove(Entry<K, V> e) throws IllegalArgumentException{
		AdaptablePQEntry<K,V> locator=validate(e);
		int j=locator.getIndex();
		if(j==heap.size()-1){
			heap.remove(heap.size()-1);
		}
		else{
			swap(j,heap.size()-1);
			heap.remove(heap.size()-1);
			bubble(j);
		}
	}

	@Override
	public void replaceKey(Entry<K, V> e, K key) throws IllegalArgumentException {
		AdaptablePQEntry<K,V> locator=validate(e);
		checkKey(key);
		locator.setKey(key);
		bubble(locator.getIndex());
	}

	@Override
	public void replaceValue(Entry<K, V> e, V value) throws IllegalArgumentException{
		AdaptablePQEntry<K,V> locator=validate(e);
		locator.setValue(value);
	}

	protected void swap(int i, int j){
		super.swap(i, j);
		((AdaptablePQEntry<K,V>)heap.get(i)).setIndex(i);
		((AdaptablePQEntry<K,V>)heap.get(j)).setIndex(j);
	}

	/**
	 * Checks the validity of the given entry
	 * @param entry the entry to be checked
	 * @return the casted entry
	 * @throws IllegalArgumentException if the entry cannot be casted
	 */
	protected AdaptablePQEntry<K,V> validate(Entry<K,V> entry) throws IllegalArgumentException{
		if(!(entry instanceof AdaptablePQEntry)){
			throw new IllegalArgumentException("Invalid entry");
		}
		AdaptablePQEntry<K,V> locator=(AdaptablePQEntry<K,V>)entry;
		int j=locator.getIndex();
		if(j>=heap.size()||heap.get(j)!=locator){
			throw new IllegalArgumentException("Invalid entry");
		}
		return locator;
	}

	protected void bubble(int j){
		if(j>0 && compare(heap.get(j),heap.get(parent(j)))<0){
			upheap(j);
		}
		else{
			downheap(j);
		}
	}
	
	public Entry<K,V> insert(K key,V value) throws IllegalArgumentException{
		checkKey(key);
		Entry<K,V> newest=new AdaptablePQEntry<>(key,value,heap.size());
		heap.add(newest);
		upheap(heap.size()-1);
		return newest;
	}
}
