/**PERCOLATION.**/
final class Percolation {
    /**
     * variable.
     */
    private boolean[][] grid;
    /**
     * variable.
     */
    private int size;
    /**
     * variable.
     */
    private Graphs gp;
    /**
     * variable.
     */
    private int count;
    /**
     * @param sze value
     */
    Percolation(final int sze) {
        this.size = sze;
        this.count = 0;
        gp = new Graphs((sze * size) + 2);
        grid = new boolean[size][size];
    }
    // public boolean isOpen(int r, int c) {
    //  return grid[r][c];
    // }
    /**
     * @param i value
     * @param j value
     * @return value
     * Time Complexity is O(1)
     */
    public int getIndex(final int i, final int j) {
        return (i * size) + j;
    }
    /**
     * @param r value
     * @param c value
     * Time Complexity is O(1)
     */
    public void open(final int r, final int c) {
        if (!grid[r][c]) {
            grid[r][c] = true;
            count += 1;
        }
        if (r == 0) {
            gp.addEdge(size * size, getIndex(r, c));
        }
        if (r == size - 1) {
        gp.addEdge((size * size) + 1, getIndex(r, c));
        }
        if (c < size - 1 && grid[r][c + 1]) { //bottom
            gp.addEdge(getIndex(r, c), getIndex(r, c + 1));
        }
        if (c > 0 && grid[r][c - 1]) { // left
            gp.addEdge(getIndex(r, c), getIndex(r, c - 1));
        }
        if (r < size - 1 && grid[r + 1][c]) { //right
            gp.addEdge(getIndex(r, c), getIndex(r + 1, c));
        }
        if (r > 0 && grid[r - 1][c]) { // top
            gp.addEdge(getIndex(r, c), getIndex(r - 1, c));
        }
    }
    // public int numberOfOpenSites() {
    //  return count;
    // }
    /**
     * @return value
     * Time Complexity is O(1)
     */
    public boolean percolates() {
        CC obj = new CC(gp);

        return obj.connected(size * size, (size * size) + 1);

    }
}
