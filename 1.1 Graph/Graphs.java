/**graphimplementation.**/
interface Graph {
	/**.
	 * method
	 * @return value
	 */
	int vertex();
	/**.
	 * method
	 * @return value
	 */
	int edge();
	/**.
	 * method
	 * @return value
	 * @param v value
	 * @param w value
	 */
	void addEdge(int v, int w);

	// public Iterable<Integer> adj(int v);
	//public boolean hasEdge(int v, int w);
}
/**graphimplementation.**/
public class Graphs implements Graph {
	/**
	 * variable.
	 */
	private final int vertices;
	/**
	 * variable.
	 */
	private int edges;
	/**
	 * variable.
	 */
	private int size;
	/**
	 * variable.
	 */
	private Bag<Integer>[] adj;
	/**
	 * variable.
	 */
	private String[] vertex;
	/**
	 * @brief [brief description]
	 * @details [long description]
	 * @param V value.
	 */
	 public Graphs(int Vert) {
		if (Vert < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
		this.vertices = Vert;
		this.edges = 0;
		adj = (Bag<Integer>[]) new Bag[Vert];
		vertex = new String[Vert];
		for (int v = 0; v < Vert; v++) {
			adj[v] = new Bag<Integer>();
		}
		size = 0;

	}
	/**
	 * @brief [brief description]
	 * @details [long description]
	 * @return value
	 */
	 public int vertex() {
		return vertices;
	}
	/**
	 * @brief [brief description]
	 * @details [long description]
	 * @return value
	 */
	 public int edge() {
		return edges;
	}
	/**
	 * @brief [brief description]
	 * @details [long description]
	 *
	 * @param v value
	 * @param w value
	 */
	public void addEdge(int v, int w) {

		// validateVertex(v);
		// validateVertex(w);
	if(v == w) {
		System.out.println(vertices + " vertices, " + edges + " edges");
		System.out.println("No edges");
		return;
	}
		edges++;
		adj[v].add(w);
	   adj[w].add(v);
	}

	public void addvertices(String s) {
		vertex[size++] = s;

	}
	 public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(vertices + " vertices, " + edges + " edges" + "\n");
		for (int v = 0; v < vertices; v++) {
			s.append(vertex[v] + ": ");
			for (int w : adj[v]) {
				s.append(vertex[w] + " ");
				//s.substring(0,s.length() - 1);
			}
			s.append("\n");
		}
		return s.toString();
	}

}


