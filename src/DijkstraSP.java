
public class DijkstraSP {

	boolean[] marked;
	int[] previous;
	int[] distance;
	
	
	public static boolean verifyNonNegative(WDigraph g){
		for (DirectedEdge e:g.edges) {
			if (e.weight()<0) {
				return false;
			}
		}
		return true;
	}
	
	public  DijkstraSP(WDigraph G, int s) {
		if (verifyNonNegative(G)) {
			System.out.println("negativ weight found");
			return;
		}
		
		
		initializeDistance(G);
		
		
		
	}
	
	private void initializeDistance(WDigraph g) {
		distance = new int[g.edges.size()];
		for (int i=0;i<g.edges.size();i++) {
			distance[i] = Integer.MAX_VALUE;
		}
	}
	
	private void relax(DirectedEdge e) {
		int from =e.from();
		int to = e.to();
		if (distance[to]>distance[to]+e.weight()) {
			distance[to] = (int) (distance[to]+e.weight());
			previous[to] = from;
		}
	}
	public int distTo(int v) {
		return distance[v];
	}
	 public boolean hasPathTo(int v) {
	        return distance[v] < Integer.MAX_VALUE;
	    }
}
