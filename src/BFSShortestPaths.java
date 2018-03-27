import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BFSShortestPaths <V extends Comparable<V>>{
	 
	boolean[] marked;
	int [] previous;
	int[] distance;
	public boolean[] getMarked() {
		return marked;
	}
	public int[] getPrevious() {
		return previous;
	}
	public int[] getDistance() {
		return distance;
	}
	BFSShortestPaths(Digraph g, int start) {
		int size=g.vertices().size();
		distance = new int [size];
		previous = new int [size];
		marked = new boolean [size];
		for (int i=0;i<size;i++){
			previous [i]=-1;
		}
		bfs(g,start);
	}
	
	public void bfs(Digraph g, int start){
		List<Integer> output = new ArrayList<Integer>();
		List<Integer> queue = new LinkedList<Integer>();
		HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
		distance[start-1]=0;
		visited.put(start, start);
		queue.add(start);
		while(queue.size()>0) {
			int v = queue.get(0);
			queue.remove(0);
			output.add(v);
			for (int adjacent :g.outNeighbors(v)) {
				if (visited.get(adjacent)==null) {
					marked[adjacent-1]=true;
					previous[adjacent-1]=v-1;
					distance[adjacent-1]=distance[v-1]+1;
					visited.put(adjacent,adjacent);
					queue.add(adjacent);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return (marked[v-1]);
	}
	
	public int distTo(int v){
		return (distance[v-1]);
	}
	
	public void printSP(int v){
		if (!marked[v-1]){
			System.out.print(v+"Is not accesible by s");		
		}
		List<Integer> path = new ArrayList<Integer>();
		int tpm = v-1;
		while(tpm!=-1){
			System.out.println(tpm +" "+previous[tpm]);
			path.add(tpm+1);
			tpm=previous[tpm];
		}
		for (int  ele:path){
			System.out.print(ele);
		}
	}
}
