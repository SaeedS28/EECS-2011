
public class Dijkstra {
	
	public static <V> Map<Vertex<V>, Integer> shortestPathDijkstra(Graph<V,Integer> g, Vertex<V> src) {
		
		Map<Vertex<V>, Integer> d = new HashTableMap<>();
		Map<Vertex<V>, Integer> cloud = new HashTableMap<>();
		AdaptablePriorityQueue<Integer, Vertex<V>> pq;
		pq = new HeapAdaptablePriorityQueue<>();
		Map<Vertex<V>, Entry<Integer,Vertex<V>>> pqTokens=new HashTableMap<>();
		
		// for each vertex v of the graph, add an entry to the priority queue, with
		// the source having distance 0 and all others having infinite distance.
		for(Vertex<V> v:g.vertices()){
			if (v == src){
				d.put(v,0);
			}
			else{
				d.put(v,Integer.MAX_VALUE);
			}
			pqTokens.put(v,pq.insert(d.get(v),v)); // save entry for future updates
		}
		
		// now begin adding reachable vertices to the cloud
		while(!pq.isEmpty()){
			Entry<Integer, Vertex<V>> entry = pq.removeMin();
			int key = entry.getKey();
			Vertex<V> u = entry.getValue();
			cloud.put(u, key); //this is the actual distance to u
			pqTokens.remove(u);
			
			for(Edge<Integer> e:g.incidentEdges(u)){
				Vertex<V> v = g.opposite(u,e);
				if(cloud.get(v) == null){
					// perform relaxation step on edge (u,v)
					int wgt = e.getElement();
					if(d.get(u)+ wgt<d.get(v)){
						d.put(v,d.get(u)+wgt); // update the distance
						pq.replaceKey(pqTokens.get(v),d.get(v)); // update the pq entry
					}
				}
			}
		}
		return cloud; // this only includes reachable vertices
	}
}
