
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Digraph diGraph = GraphFactory.createDiGraphFromTextFile("Data/graph-DFS-BFS.txt");
		
		//System.out.println(Graph.dfs(diGraph));
//		System.out.println(Graph.cc(diGraph));

//		System.out.println(diGraph.outDegree(5));
//		System.out.println(diGraph.inDegree(5));

//		printShortestPathAndDegrees(Digraph diGraph);
		
		WDigraph wDigraph = GraphFactory.createWDiGraphFromTextFile("Data/graph-WDG.txt");
		System.out.println(wDigraph.adjacencyList);
		System.out.println(wDigraph.getVertices());
	}

	
public static void printShortestPath(BFSShortestPaths<Integer> shortestath,Digraph diGraph,int i) {
	System.out.println("Shortest path for s=:"+i);
	for (int k :diGraph.vertices()) {
		System.out.print(k+" :  ");
		shortestath.printSP(k);
		System.out.println("\n");
	}
}
	


public static void printShortestPathAndDegrees(Digraph diGraph) {
	for (int i:diGraph.vertices()) {
		BFSShortestPaths<Integer> shortesptath=new BFSShortestPaths<Integer>(diGraph, i);
		printShortestPath(shortesptath,diGraph,i);
		System.out.println("Ecentricity for "+i+": "+shortesptath.excentricity(diGraph));
	}

}
}
