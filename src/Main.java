
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Digraph diGraph = GraphFactory.createDiGraphFromTextFile("Data/graph-DFS-BFS.txt");

		//System.out.println(Graph.dfs(diGraph));
//		System.out.println(Graph.cc(diGraph));
		BFSShortestPaths<Integer> shortestath1=new BFSShortestPaths<Integer>(diGraph, 2);
		for (int  ele:shortestath1.getPrevious()){
			System.out.print(ele);
		}
		System.out.println(shortestath1.hasPathTo(1));
		shortestath1.printSP(7);
		//System.out.println(diGraph.isConnected());

	}

	

}
