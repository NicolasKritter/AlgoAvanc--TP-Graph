

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * This class is an Abstract Graph. 
 * Types of Vertices (V) and Edges (E) are not defined by default. 
 * The only constraints on theses types are that Vertices must be Comparable ie. 
 * there must be a way to order vertices with one another. This is done through the use of the Comparable interface.
 *  
 * 
 * @author slefebvr
 *
 * @param <V>
 * @param <E>
 */
public abstract class Graph<V extends Comparable<V>> {
	
	protected int n;
	protected int m;
	
	
	public Graph(int nbVertices, int nbEdges) {
		this.n= nbVertices;
		this.m = nbEdges;
	}
	
	
	/**
	 * Initializes an empty graph
	 */
	public Graph() {
		this(0,0);
	}
	
	public int order() {
		return n;
	}
	
	public int size() {
		return m;
	}

	/**
	 * Adds the corresponding vertex if needed
	 * @param e
	 */
	public abstract void addEdge(V s, V t);
	
	/**
	 * Adds a vertex to the graph. On success n is increased
	 * @param v
	 */
	public abstract void addVertex(V v);
	
	/**
	 * 
	 * @return the list of the graph vertices
	 */
	public abstract List<V> vertices();
		
	/** 
	 * Return the list of v's neighbors
	 * @param v
	 */
	public abstract List<V> inNeighbors(V v);
	public abstract List<V> outNeighbors(V v);
		
	/**
	 * Returns the inbound degree of node v
	 * in case of undirected graph should return the same as outDegree
	 * @param v
	 * @return inbound degree of vertex v
	 */
	public abstract int inDegree(V v);
	public abstract int outDegree(V v);
	
	
	
	/**
	 * Returns true if the graph is connected
	 * can be more efficient. 
	 * @return
	 */
	public boolean isConnected() {
		//TODO
		return cc(this)==1;
	}
	
	/**
	 * Counts and returns the number of connected components
	 * @param g
	 * @return
	 */
	public static<V extends Comparable<V>> int cc(Graph<V> g) {
		List<List<V>> connectedComponent=  new ArrayList<List<V>>();
		List<V> visited =  new ArrayList<V>();
		
		for (V v:g.vertices()) {
			if (!visited.contains(v)) {	
			List<V> out = new ArrayList<V>();
			dfs(g,v,out);
			List<V> connected = new ArrayList<V>();
			connected.add(v);
			visited.add(v);
			for (V neighbour: out) {				
				if (neighbour!= v) {
					List<V> outNeighbour = new ArrayList<V>();
					dfs(g,neighbour,outNeighbour);
					if (outNeighbour.contains(v)) {
						connected.add(neighbour);
						visited.add(neighbour);
					}
				}	
			}
			connectedComponent.add(connected);
			}	
		}		
		return connectedComponent.size();
	}
	
	/**
	 * Returns the list of vertices ordered by DFS visit 
	 * 
	 * @param g
	 * @return
	 */
	public static<V extends Comparable<V>>  List<V> dfs(Graph<V> g) {
		List<V> vertices = g.vertices();
		List<V> out = new ArrayList<V>();
		while (out.size()!=vertices.size()) {
			V start = vertices.get(0);
			for (V v :vertices) {
				if (!out.contains(v)) {
					start = v;
					break;
				}
			}
			dfs(g,start,out);
		}
		
		return out;
		
	}
		
	public static<V extends Comparable<V>>  void dfs(Graph<V> g,V start,List<V> out) {
		out.add(start);
		List<V> neighbors = g.outNeighbors(start);
		Collections.sort(neighbors);
		
		 while(neighbors.size()>0) {

			V v = neighbors.get(0);
			 neighbors.remove(v);
			 if (!out.contains(v)) {
				 dfs(g,v,out);
			 }
		 }
		
	}
	
	
	/**
	 * Iterative function for bfs 
	 * @param g
	 * @return
	 */
	
	public static<V extends Comparable<V>>  List<V> bfs(Graph<V> g) {
		List<V> vertices = g.vertices();
		List<V> out = new ArrayList<V>();
		while (out.size()!=vertices.size()) {
			V start = vertices.get(0);
			for (V v :vertices) {
				if (!out.contains(v)) {
					start = v;
					break;
				}
			}
			out.addAll(bfs(g,start));
		}
		
		return out;
		
	}


	public static<V extends Comparable<V>> List<V> bfs(Graph<V> g, V start) {
		List<V> output = new ArrayList<V>();
		List<V> queue = new LinkedList<V>();
		HashMap<V,V> visited = new HashMap<V,V>();
		
		visited.put(start, start);
		queue.add(start);
		while(queue.size()>0) {
			V v = queue.get(0);
			System.out.print(v.toString());
			queue.remove(0);
			output.add(v);
			for (V adjacent :g.outNeighbors(v)) {
				if (visited.get(adjacent)==null) {
					visited.put(adjacent,adjacent);
					queue.add(adjacent);
				}
			}
		}
		
		return output;
	}


}
