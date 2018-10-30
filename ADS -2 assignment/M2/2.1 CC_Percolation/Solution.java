import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		//
		Graphs g = new Graphs(n);
		while(s.hasNextLine()) {
		String[] tokens = s.nextLine().split(" ");
		g.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
	}
	Percolation p = new Percolation(g);
	System.out.println(p.connected());

	}
}