class Edge implements Comparable<Edge> {
	private int places;
	private int driver;
	private Double weight;
	Edge(final int place,final int drive, final Double weig) {
		this.places = places;
		this.driver = driver;
		this.weight = weig;
	}
	public int either() {
		return this.places;
	}
	public int other(final int ver) {
		if (places == ver) {
			return driver;
		} else {
			return places;
		}
	}
	public Double weight() {
		return this.weight;
	}
	public int compareTo(Edge that) {
		if(this.weight > that.weight) {
			return 1;
		} else if(this.weight < that.weight) {
			return -1;
		} else {
			return 0;
		}
	}
}