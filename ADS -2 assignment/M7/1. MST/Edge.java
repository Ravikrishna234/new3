/**minimumdistance.**/
class Edge implements Comparable<Edge> {
    /**
     * variable.
     */
    private final int v;
    /**
     * variable.
     */
    private final int w;
    /**
     * variable.
     */
    private final double weight;
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param v value
     * @param w value
     * @param weight value
     * @return value
     */
    public Edge(final int v, final int w, final double weight) {
        if (v < 0) {
         throw new IllegalArgumentException(
            "vertex index must be a nonnegative integer");
     }
        if (w < 0) {
        throw new IllegalArgumentException(
            "vertex index must be a nonnegative integer");
    }
        if (Double.isNaN(weight)) {
         throw new IllegalArgumentException(
            "Weight is NaN");
     }
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    /**
     * @brief [brief description]
     * @details [long description]
     * @return value
     */
    public double weight() {
        return weight;
    }
    /**
     * @brief [brief description]
     * @details [long description]
     * @return value
     */
    public int either() {
        return v;
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param vertex value
     * @return value
     */
    public int other(final int vertex) {
        if (vertex == v) {
         return w;
     }
        else if (vertex == w) {
         return v;
     }
        else {
        throw new IllegalArgumentException("Illegal endpoint");
    }
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param that value
     * @return value
     */
    @Override
    public int compareTo(final Edge that) {
        return Double.compare(this.weight, that.weight);
    }
}