import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Set;

public class WDigraph {

	int vertex;
	int nbEdges;
	List<DirectedEdge> edges = new LinkedList<DirectedEdge>();
	HashMap<Integer,List<DirectedEdge>> adjacencyList = new HashMap<Integer,List<DirectedEdge>>();
	HashMap<Integer,Integer> Indegree = new HashMap<Integer,Integer>();
	public WDigraph() {
		
	}
	
	public void addEdge(DirectedEdge edge) {
		edges.add(edge);
		nbEdges+=1;
		if (adjacencyList.containsKey(edge.from())) {
			adjacencyList.get(edge.from()).add(edge);
		}else {
			List<DirectedEdge> liste = new LinkedList<DirectedEdge>();
			liste.add(edge);
			adjacencyList.put(edge.from(),liste );
		}
		
		if (Indegree.containsKey(edge.to())) {
			Indegree.put(edge.to(), Indegree.get(edge.to()+1));
		}else {
			
			Indegree.put(edge.to(),1 );
		}
	}
	
	public List<DirectedEdge> outNeighbourg(int v){
		return adjacencyList.get(v);
	}
	
	public int outDegree(int v) {
		return outNeighbourg(v).size();
	}
	public int intDegree(int v) {
		return Indegree.get(v);
	}
	
	public Set<Integer> getVertices() {
		return adjacencyList.keySet();
	}
}
