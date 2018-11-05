import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		int n1 = Integer.parseInt(s.nextLine());
		int j = 0;
		EdgeWeightedGraph ed = new EdgeWeightedGraph(n);
		while (j < n1) {
			String[] tokens = s.nextLine().split(" ");
			Edge e = new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
			ed.addEdge(e);
			j++;
		}
		KruskalMST k = new KruskalMST(ed);
		System.out.println(k.weight());
	}
}