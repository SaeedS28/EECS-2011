package a1;

public interface Queue<E> {
	/** inserts an element at the end of the queue **/
	public void enqueue(E e);
	
	/** removes and returns the element at the front of the queue **/
	public E dequeue();
	
	/** returns the element at the front without removing it **/
	public E front();
	
	/** returns the number of elements stored **/
	public int size();
	
	/** indicates whether no elements are stored **/
	public boolean isEmpty();
}
