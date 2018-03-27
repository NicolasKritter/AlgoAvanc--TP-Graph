public class DirectedEdge {
private final int from;
private final int to;
private final double weight;


public DirectedEdge(int from, int to, double w) {
	this.from = from;
	this.to = to;
	this.weight = w;
}

public int from() {
return from;
}
public int to() {
return to;
}
public double weight() {
return weight;
}

@Override
public String toString() {
	return "{From:"+this.from+" To:"+this.to+" W:"+this.weight+"}";
}
}