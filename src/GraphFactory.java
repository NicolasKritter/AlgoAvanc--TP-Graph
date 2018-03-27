import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Scanner;

public class GraphFactory {
	
	public static Digraph createDiGraphFromTextFile(String path) {
		Digraph g = new Digraph();
		try(Scanner scan = new Scanner(FileSystems.getDefault().getPath(path))){
			while(scan.hasNextInt()) {
				int u = scan.nextInt(),
					v = scan.nextInt();
				g.addEdge(u, v);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return g;
	}
	
	public static WDigraph createWDiGraphFromTextFile(String path) {
		WDigraph g = new WDigraph();
		try(Scanner scan = new Scanner(FileSystems.getDefault().getPath(path))){
			while(scan.hasNextInt()) {
				int f = scan.nextInt(),
					t = scan.nextInt();
				double w = scan.nextDouble();
				DirectedEdge edge = new DirectedEdge(f,t,w);
				g.addEdge(edge);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return g;
	}


}
