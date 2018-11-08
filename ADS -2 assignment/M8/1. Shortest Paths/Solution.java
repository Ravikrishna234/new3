import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		String[] tokens = s.nextLine().split(" ");
		int n1 = Integer.parseInt(tokens[0]);
		int n2 = Integer.parseInt(tokens[1]);
		String[] mstations = s.nextLine().split(" ");
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(n1);
		LinearProbingHashST<String, Integer> hashing;
		hashing = new LinearProbingHashST<String, Integer>();
		for(int i = 0; i < mstations.length; i++) {
			hashing.put(mstations[i], i);
		}
		int j = 0;
		while(j < n2) {
			String[] routes = s.nextLine().split(" ");
			Edge e = new Edge(hashing.get(routes[0]), hashing.get(routes[1]),
				Double.parseDouble(routes[2]));
			ewg.addEdge(e);
			j++;
		}
		int n3 = Integer.parseInt(s.nextLine());
		while(n3 > 0) {
			String[] token = s.nextLine().split(" ");
			int a = hashing.get(token[0]);
			DijkstraUndirectedSP dk = new DijkstraUndirectedSP(ewg, a);
			if(dk.hasPathTo(hashing.get(token[1]))) {
				int path = (int) dk.distTo(hashing.get(token[1]));
				System.out.println(path);
				n3--;
			}
		}
	}
}