class Percolation {
	private boolean[][] grid;
	public int size;
	private Graphs gp;
	private int count;
	Percolation(int sze) {
		this.count = 0;
		gp = new Graphs((sze * size) + 2);
		grid = new boolean[size][size];
	}
	// public boolean isOpen(int r, int c) {
	// 	return grid[r][c];
	// }
	public int getIndex(int i, int j) {
		return (i*size) + j;
	}
	public void open(int r, int c) {
		if (grid[r][c] == false) {
			grid[r][c] = true;
			count += 1;
		}
		if (r == 0) {
			gp.addEdge(r,c);
		}
		if (r == size - 1) {
			gp.addEdge(r,c);
		}
        if (c < size - 1 && grid[r][c + 1]) { //bottom
        	gp.addEdge(getIndex(r, c), getIndex(r, c + 1) );
        }
        if (c > 0 && grid[r][c - 1]) { // left
        	gp.addEdge(getIndex(r, c), getIndex(r, c - 1) );
        }
        if ( r < size - 1 && grid[r + 1][c]) { //right
        	gp.addEdge(getIndex(r, c), getIndex(r + 1, c) );
        }
        if (r > 0 && grid[r - 1][c]) { // top
        	gp.addEdge(getIndex(r, c), getIndex(r - 1, c) );
        }
	}
	// public int numberOfOpenSites() {
	// 	return count;
	// }
	public boolean percolates() {
		CC obj = new CC(gp);

		return obj.connected(size * size, (size*size)+1);

	}
}