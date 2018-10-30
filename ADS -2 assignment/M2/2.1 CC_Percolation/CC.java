/**percolation.**/
final class CC {
     /**
     * variable.
     */
    private boolean[] marked;
     /**
     * variable.
     */
    private int[] id;
     /**
     * variable.
     */
    private int[] size;
     /**
     * variable.
     */
    private int count;
    /**
     * @param G value
     * @return [description]
     */

    public CC(final Graphs G) {
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
    /**
     * @param G [description]
     * @param v [description]
     */
    private void dfs(final Graphs G, final int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }
    /**
     * @param v [description]
     * @return [description]
     */
    public int id(final int v) {

        return id[v];
    }
    /**
     * @param v [description]
     * @return [description]
     */
    public int size(final int v) {

        return size[id[v]];
    }
    /**
     * @return [description]
     */
    public int count() {
        return count;
    }
     /**
     * @return [description]
     */
    public boolean connected(final int v, final int w) {

        return id(v) == id(w);
    }
     /**
     * @return [description]
     */
    public boolean areConnected(final int v, final int w) {
        return id(v) == id(w);
    }
     /**
     * @return [description]
     */
    private void validateVertex(final int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}
