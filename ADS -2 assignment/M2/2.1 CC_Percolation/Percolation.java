class Percolation {
	private boolean[][] grid;
	public int size;
	public int count;
	private int top = 0;
	private int bottom;
	private Graphs gp;
	Percolation(int sze) {
		this.size = sze;
		this.count = 0;
		this.bottom = sze * sze + 1;
		gp = new Graphs((sze * size) + 2);
		grid = new boolean[size][size];
	}
	public boolean isOpen(int r, int c) {
		return grid[r][c];
	}
	public int getIndex(int i, int j) {
		return (i*size) + j;
	}
	public void open(int r, int c) {
		if (isOpen(r, c) == false) {
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
		if(obj.connected(size * size, (size*size)+1)) {
			return true;
		}
		return false;

	}
}