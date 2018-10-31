/**hasacycle.**/
class DirectedCycle {
    /**
     * variable.
     */
    private boolean[] marked;
    /**
     * variable.
     */
    private int[] edgeTo;
    /**
     * variable.
     */
    private boolean[] onStack;
    /**
     * variable.
     */
    private Stack<Integer> cycle;

    /**
     * @param graph value
     */
    public DirectedCycle(final DiGraph graph) {
        marked  = new boolean[graph.vertex()];
        onStack = new boolean[graph.vertex()];
        edgeTo  = new int[graph.vertex()];
        for (int v = 0; v < graph.vertex(); v++) {
     if (!marked[v] && cycle == null) {
        dfs(graph, v);
         }
        }
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param DiGraph value
     * @param int value
     */
    private void dfs(final DiGraph graph, final int v) {
        onStack[v] = true;
        marked[v] = true;

        for (int w : graph.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) {
             return;
        }
            // found new vertex, so recur
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }

            // trace back directed cycle
            else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                assert check();
            }
        }
        onStack[v] = false;
    }


    /**
     * @return value
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * @return value
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }


    /**
     * @return value
     */
    private boolean check() {

        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) {
                    first = v;
                }
                last = v;
            }
    if (first != last) {
        System.err.printf(
            "cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }
        return true;
    }
}
