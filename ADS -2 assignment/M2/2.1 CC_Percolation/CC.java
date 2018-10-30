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
     * @param graph value
     * Time Complexity is O(N)
     */

    public CC(final Graphs graph) {
        marked = new boolean[graph.vertex()];
        id = new int[graph.vertex()];
        size = new int[graph.vertex()];
        for (int v = 0; v < graph.vertex(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
                count++;
            }
        }
    }
    /**
     * @param graph [description]
     * @param v [description]
     * Time Complexity is O(N)
     */
    private void dfs(final Graphs graph, final int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }
    /**
     * @param v [description]
     * @return [description]
     * Time Complexity is O(1)
     */
    public int id(final int v) {

        return id[v];
    }
    /**
     * @param v [description]
     * @return [description]
     * Time Complexity is O(1)
     */
    public int size(final int v) {

        return size[id[v]];
    }
    /**
     * @return [description]
     * Time Complexity is O(1)
     */
    public int count() {
        return count;
    }
     /**
      * @param v value
      * @param w value
     * @return [description]
     * Time Complexity is O(1)
     */
    public boolean connected(final int v, final int w) {

        return id(v) == id(w);
    }
     /**
      * @param v value
      * @param w value
     * @return [description]
     * Time Complexity is O(1)
     */
    public boolean areConnected(final int v, final int w) {
        return id(v) == id(w);
    }
     /**
    * @param v value
    * Time Complexity is O(1)
     */
    private void validateVertex(final int v) {
        int value = marked.length;
        if (v < 0 || v >= value) {
            throw new IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (value - 1));
        }
    }
}


