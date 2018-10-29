import java.util.NoSuchElementException;
final class Matrix {
 	private final int V;
    private int E;
    private int[][] adj;
    private String[] matrices;
    private int size;
     public Matrix(int V) {
        if (V < 0) throw new IllegalArgumentException("Too few vertices");
        this.V = V;
        this.E = 0;
        this.adj = new int[V][V];
        this.matrices = new String[V];
        this.size = 0;
    }
      public int V() { return V; }
    public int E() { return E; }


public void addEdge(int v, int w) {
	if(v == w) {
		System.out.println(V + " vertices" + E + " edges");
		System.out.println("No edges");
		return;
	}
        if (adj[v][w] == 0) E++;
        adj[v][w] = 1;
        adj[w][v] = 1;
    }
    public void addmat(String s) {
    	matrices[size++] = s;
    }
 public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges" + "\n");
        for (int v = 0; v < V; v++) {
            //s.append(matrices[v] + ": ");
            for (int w : adj[v]) {
            	if(w == 1) {
                s.append(1 + " ");
            } else {
            	s.append(0 + " ");
            }
            }
            s.append("\n");
        }
        return s.toString();
    }

}