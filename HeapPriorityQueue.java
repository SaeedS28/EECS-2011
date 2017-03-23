import java.util.ArrayList;
import java.util.Comparator;

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

	protected ArrayList<Entry<K,V>> heap=new ArrayList<>();//background container for the heap
	
	//Ctors
	
	/**
	 * The default constructor
	 */
	public HeapPriorityQueue(){
		super();
	}
	
	/**
	 * Creates an object with a user-defined comparator
	 * @param comp custom comparator
	 */
	public HeapPriorityQueue(Comparator<K> comp){
		super(comp);
	}
	
	/**
	 * Returns the index of the parent of the passed index
	 * @param j index
	 * @return the index of the parent
	 */
	protected int parent(int j){
		return (j-1)/2;
	}
	
	/**
	 * Returns the index of the left child of the passed index
	 * @param j the index
	 * @return the index of the left child
	 */
	protected int left(int j){
		return 2*j+1;
	}
	
	/**
	 * Returns the index of the right child of the passed index
	 * @param j the index
	 * @return the index of the right child
	 */
	protected int right(int j){
		return 2*j+2;
	}
	
	/**
	 * Returns a boolean which depends on whether the element at the given index
	 * has a left child
	 * @param j the index
	 * @return true if the index has a left child
	 */
	protected boolean hasLeft(int j){
		return left(j)<heap.size();
	}
	
	/**
	 * Returns a boolean which depends on whether the element at the given index
	 * has a right child
	 * @param j the index
	 * @return true if the index has a right child
	 */
	protected boolean hasRight(int j){
		return right(j)<heap.size();
	}
	
	@Override
	public int size() {
		return heap.size();
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K,V> newest=new PQEntry<>(key,value);
		heap.add(newest);
		upheap(heap.size()-1);
		return newest;
	}

	@Override
	public Entry<K, V> min() {
		if(heap.isEmpty()){
			return null;
		}
		return heap.get(0);
	}

	@Override
	public Entry<K, V> removeMin() {
		if(heap.isEmpty()){
			return null;
		}
		Entry<K,V> answer=heap.get(0);
		swap(0,heap.size()-1);
		heap.remove(heap.size()-1);
		downheap(0);
		return answer;
	}
	
	/**
	 * Swaps two elements at the given indices
	 * @param i the first index
	 * @param j the second index
	 */
	protected void swap(int i, int j){
		Entry<K,V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}

	/**
	 * Performs the upheap operation until the heap property  has been restored
	 * @param j then index from where to perform the upheap operation
	 */
	protected void upheap(int j){
		while(j>0){
			int p=parent(j);
			if(compare(heap.get(j),heap.get(p))>=0){
				break;
			}
			swap(j,p);
			j=p;
		}
	}
	
	/**
	 * Performs the downheap operation until the heap property  has been restored
	 * @param j then index from where to perform the downheap operation
	 */
	protected void downheap(int j){
		while(hasLeft(j)){
			int leftIndex=left(j);
			int smallChildIndex=leftIndex;
			if(hasRight(j)){
				int rightIndex=right(j);
				if(compare(heap.get(leftIndex),heap.get(rightIndex))>0){
					smallChildIndex=rightIndex;
				}
			}
			if(compare(heap.get(smallChildIndex),heap.get(j))>=0){
				break;
			}
			swap(j,smallChildIndex);
			j=smallChildIndex;
		}
	}
}
