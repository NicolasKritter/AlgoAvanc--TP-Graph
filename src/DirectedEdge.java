public class DirectedEdge {
private final int s;
private final int d;
private final double weight;


public DirectedEdge(int s, int d, double w) {
	this.s = s;
	this.d = d;
	this.weight = w;
}

public int from() {
return s;
}
public int to() {
return d;
}
public double weight() {
return weight;
}
}