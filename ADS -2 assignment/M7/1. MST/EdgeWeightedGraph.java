/**minimumdistance.**/
public class EdgeWeightedGraph {
    /**
     * variable.
     */
    private final int vertex;
    /**
     * variable.
     */
    private int edge;
    /**
     * variable.
     */
    private Bag<Edge>[] adj;
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param V [description]
     * @return [description]
     */
    public EdgeWeightedGraph(final int V) {
        if (V < 0) {
            throw new IllegalArgumentException(
                "Number of vertices must be nonnegative");
        }
        this.vertex = V;
        this.edge = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param G [description]
     * @return [description]
     */
    public EdgeWeightedGraph(final EdgeWeightedGraph G) {
        this(G.V());
        this.edge = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Edge> reverse = new Stack<Edge>();
            for (Edge e : G.adj[v]) {
                reverse.push(e);
            }
            for (Edge e : reverse) {
                adj[v].add(e);
            }
        }
    }
    /**
     * @brief [brief description]
     * @details [long description]
     * @return [description]
     */
    public int V() {
        return vertex;
    }
    /**
     * @brief [brief description]
     * @details [long description]
     * @return [description]
     */
    public int E() {
        return edge;
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param v [description]
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= vertex)
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (vertex-1));
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param e [description]
     */
    public void addEdge(final Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        edge++;
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param v [description]
     * @return [description]
     */
    public Iterable<Edge> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }


    public int degree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < vertex; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // add only one copy of each self loop (self loops will be consecutive)
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertex + " " + edge + "\n");
        for (int v = 0; v < vertex; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
