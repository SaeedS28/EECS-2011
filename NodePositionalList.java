//Code from Assignment 2, Question 2
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodePositionalList<E> implements PositionalList<E>, Iterable<E> {

	/**
	 * This is the node class which allows the user to create a double-ended node.
	 * @author Saad
	 *
	 * @param <E> a generic variable.
	 */
	public static class DNode<E> implements Position<E>{
		private E element; //The element stored at this node
		private DNode<E> prev; //The reference to the previous node
		private DNode<E> next; //The reference to the next node;		
		
		/**
		 * Creates a new node and assigns it the given attributes.
		 * @param e the element to be assigned to the list.
		 * @param p the node that will be referenced prior to the current node.
		 * @param n the node that will be referenced after the current node.
		 */
		public DNode(E e, DNode<E> p, DNode<E> n){
			element=e;
			prev=p;
			next=n;
		}
		
		public E getElement() throws IllegalStateException {
			if(next==null){
				throw new IllegalStateException("Position no longer valid");
			}
			return element;
		}
		
		/**
		 * Returns the reference of the node that is linked prior to the current node.
		 * @return the reference of the previous node.
		 */
		public DNode<E> getPrev(){
			return prev;
		}
		
		/**
		 * Returns the reference of the node that is linked after the current node.
		 * @return the reference of the next node.
		 */
		public DNode<E> getNext(){
			return next;
		}
		
		/**
		 * This method allows the user to set the element of the current node.
		 * @param e the element to be set.
		 */
		public void setElement(E e){
			element=e;
		}
		
		/**
		 * This method allows the user to set the node that precedes the current node.
		 * @param p a double-ended node.
		 */
		public void setPrev(DNode<E> p){
			prev=p;
		}
		
		/**
		 * This method allows the user to set the node that succeeds the current node.
		 * @param n a double-ended node.
		 */
		public void setNext(DNode<E> n){
			next=n;
		}
	}
	//End of nested Node class
	
	//instance variables of the PositionalList
	private DNode<E> header; //header node
	private DNode<E> trailer; //trailer node
	private int size=0; //number of elements in the list
	
	/**
	 * Constructs a new empty list.
	 */
	public NodePositionalList(){
		header = new DNode<>(null, null, null);
		trailer = new DNode<>(null, header, null);
		header.setNext(trailer);
	}
	
	/**
	 * Checks whether the passed position is valid.
	 * @param v the position to be valid.
	 * @return the position as a node.
	 * @throws InvalidPositionException if the position is null or isn't an instance of DNode.
	 */
	protected DNode<E> checkPosition(Position<E> v) throws InvalidPositionException{
		if (v == null || !(v instanceof DNode))
			throw new InvalidPositionException("The position is invalid");
		return (DNode<E>) v;
	}
	
	//Returns the given node as a Position (or null, if it is a sentinel.
	private Position<E> position(DNode<E> node){
		if(node == header || node == trailer){
			return null;
		}
		return node;
	}

	//Adds element e to the linked list between the given nodes.
	private Position<E> addBetween(E e, DNode<E> previous, DNode<E> nextOne){
		DNode<E> newest = new DNode<E>(e, previous, nextOne);
		previous.setNext(newest);
		nextOne.setPrev(newest);
		size++;
		return newest;
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public Position<E> first() {
		return position(header.getNext());
	}

	public Position<E> last() {
		return position(trailer.getPrev());
	}

	public Position<E> before(Position<E> p) throws InvalidPositionException {
		DNode<E> node = checkPosition(p);
		return position(node.getPrev());
	}

	public Position<E> after(Position<E> p) throws InvalidPositionException {
		DNode<E> node = checkPosition(p);
		return position(node.getNext());		
	}

	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}

	public Position<E> addBefore(Position<E> p, E e) throws InvalidPositionException{
		DNode<E> node = checkPosition(p);
		return addBetween(e, node.getPrev(), node);
	}

	public Position<E> addAfter(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> node= checkPosition(p);
		return addBetween(e, node, node.getNext());
	}

	public E set(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> node = checkPosition(p);
		E oldElement = node.getElement();
		node.setElement(e);
		return oldElement;
	}

	public E remove(Position<E> p) throws InvalidPositionException {
		DNode<E> node = checkPosition(p);
		DNode<E> predecessor = node.getPrev();
		DNode<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null); // help with garbage collection
		node.setNext(null); // and convention for defunct node
		node.setPrev(null);
		return answer;
	}
	
	/**
	 * Returns a string representation of the PositionalList.
	 * @return string representation of the list.
	 */
	public String toString(){
		StringBuilder s1 = new StringBuilder();
		Iterator<E> it = iterator();
		
		s1.append("{ ");
		while(it.hasNext()){
			s1.append(it.next());
			s1.append(" ");
		}
		s1.append("}");
		return s1.toString();
	}
	
	private class PositionIterator implements Iterator<Position<E>>  {
		private Position<E> cursor = first(); //position of the next element to report
		private Position<E> recent = null; // element at this position might later be removed
		
		public boolean hasNext(){
			return cursor != null;
		}
		
		public Position<E> next() throws NoSuchElementException{
			if(cursor==null){
				throw new NoSuchElementException("Nothing to report");
			}
			recent=cursor;
			cursor = after(cursor);
			return recent;
		}
		
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("This doesn't work");
		}
	}
	//End of PositionIterator class
	
	private class PositionIterable implements Iterable<Position<E>>{
		public Iterator<Position<E>> iterator(){
			return new PositionIterator();	
		}
	}
	//end of PositionIterable Class
	
	/**
	 * Returns an iterable representation of the list's positions.
	 * @return an iterable representation of positions.
	 */
	public Iterable<Position <E>> position(){
		return new PositionIterable();
	}
	
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> postIterator = new PositionIterator();
		public boolean hasNext(){
			return postIterator.hasNext();
		}
		
		public E next(){
			return postIterator.next().getElement();
		}
		
		public void remove(){
			postIterator.remove();
		}
	}
	/**
	 * Returns an iterator of the elements stored in the list.
	 * @return an iterator.
	 */
	public Iterator<E> iterator() {
		return new ElementIterator();
	}
}