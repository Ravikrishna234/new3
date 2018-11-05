import java.util.Scanner;
import java.util.Arrays;
/**MINIMUMDISTANCE.**/
class Solution {
	/**
	 * @brief [brief description]
	 * @details [long description]
	 */
	private Solution() { }
	/**
	 * @brief [brief description]
	 * @details [long description]
	 * Time complexity is O(N)
	 * @param args [description]
	 */
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		int vert = Integer.parseInt(s.nextLine());
		int testcases = Integer.parseInt(s.nextLine());
		EdgeWeightedGraph wtEdge = new EdgeWeightedGraph(vert);
		for (int i = 0; i < testcases; i++) {
			String[] inp = s.nextLine().split(" ");
			Edge e = new Edge(Integer.parseInt(inp[0]),
				Integer.parseInt(inp[1]),
				Double.parseDouble(inp[2]));
			wtEdge.addEdge(e);
		}
		LazyPrimMST p =  new LazyPrimMST(wtEdge);
		// System.out.println(p.edges());
		System.out.format("%.5f",p.weight());
	}
}

