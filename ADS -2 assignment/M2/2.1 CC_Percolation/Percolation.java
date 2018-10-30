public class Percolation {
    private boolean[] marked;
    private int[] id;
    private int[] size;
    private int count;
    public Percolation(Graphs G) {
        marked = new boolean[G.vertex()];
        id = new int[G.vertex()];
        size = new int[G.vertex()];
        for (int v = 0; v < G.vertex(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    // depth-first search for a Graph
    private void dfs(Graphs G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }
    public int id(int v) {
        validateVertex(v);
        return id[v];
    }
    public int size(int v) {
        validateVertex(v);
        return size[id[v]];
    }
    public int count() {
        return count;
    }
    public boolean connected() {
        //validateVertex(v);
        //validateVertex(w);
        return id(0) == id(id.length);
    }
    public boolean areConnected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}