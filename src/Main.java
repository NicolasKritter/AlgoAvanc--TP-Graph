
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Digraph diGraph = GraphFactory.createDiGraphFromTextFile("Data/graph-DFS-BFS.txt");

		//System.out.println(Graph.dfs(diGraph));
//		System.out.println(Graph.cc(diGraph));
		System.out.println(Graph.bfs(diGraph,diGraph.vertices().get(0)));
		//System.out.println(diGraph.isConnected());

	}

}
