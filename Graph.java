
public interface Graph<V, E> {
	
	/**
	 * Returns an array of the two end vertices of the passed edge
	 * @param e the edge
	 * @return an array representing the two end vertices 
	 */
	public Vertex<V>[] endVertices(Edge<E> e);
	
	/**
	 * Returns the vertex opposite to v on the same edge
	 * @param v the vertex
	 * @param e the edge
	 * @return the opposite vertex
	 */
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e);
	
	/**
	 * Returns a boolean value representing whether 2 vertices are adjacent
	 * @param u one vertex
	 * @param v another vertex
	 * @return true if adjacent, false otherwise
	 */
	public boolean areAdjacent(Vertex<V> u, Vertex<V> v);
	
	/**
	 * Replace the vertex or the edge with another edge or vertex.
	 * @param p thing position of the thing being replaced
	 * @param o the thing to replace.
	 * @return the old object.
	 */
	public Object replace(Position<?> p, Object o);
	
	/**
	 * Replaces the element of the passed vertex
	 * @param v The vertex to be passed
	 * @param o the element 
	 * @return the previously stored element
	 * @throws InvalidPositionException if the vertex is invalid.
	 */
	public V replace(Vertex<V> v, V o);
	
	/**
	 * Replaces the element of the passed edge
	 * @param e the edge to passed
	 * @param o the element
	 * @return the previously stored element
	 * @throws InvalidPositionException if the edge is invalid
	 */
	public E replace(Edge<E> e, E o);
	
	/**
	 * Inserts a vertex storing an object
	 * @param o the object to be stored in the vertex
	 * @return the added vertex
	 */
	public Vertex<V> insertVertex(V o);
	
	/**
	 * Takes two vertices and connects them with a new edge
	 * which holds data.
	 * @param v vertex 1
	 * @param w vertex 2
	 * @param o data to be stored in the edge
	 * @return the edge that was just added
	 */
	public Edge<E> insertEdge(Vertex<V> v, Vertex<V> w, E o);
	
	/**
	 * Removes the specified vertex
	 * @param v a vertex
	 * @return the data that was associated with the vertex
	 */
	public V removeVertex(Vertex<V> v);
	
	/**
	 * Removes the specified edge
	 * @param e an edge
	 * @return the data that was associated with the vertex
	 */
	public E removeEdge(Edge<E> e);
	
	/**
	 * Returns the set of edges incident on a passed vertex
	 * @param v vertex
	 * @return a collection of edges
	 */
	public Iterable<Edge<E>> incidentEdges(Vertex<V> v);
	
	/**
	 * Returns the set of vertices associated with the graph
	 * @return A collection of vertices
	 */
	public Iterable<Vertex<V>> vertices();
	
	/**
	 * Returns the set of edges associated with the graph
	 * @return A collection of edges
	 */
	public Iterable<Edge<E>> edges();	
}
