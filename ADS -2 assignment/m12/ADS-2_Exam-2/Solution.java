import java.util.Scanner;
public class Solution {


	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		int n1 = Integer.parseInt(s.nextLine());
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(n1);
		while(n1 > 0) {
			String[] tokens = s.nextLine().split(" ");
			Edge e = new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
			ewg.addEdge(e);
			n1--;

		}

		String caseToGo =s.nextLine();;
		switch (caseToGo) {
		case "Graph":
			System.out.println(ewg);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] places = s.nextLine().split(" ");
			DijkstraUndirectedSP dk = new DijkstraUndirectedSP(ewg, Integer.parseInt(places[0]));
			if(dk.hasPathTo(Integer.parseInt(places[1]))) {
				float path = (int) dk.distTo(Integer.parseInt((places[1])));
				System.out.println(path);
			} else {
				System.out.println("No Path Found");
			}

			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] path = s.nextLine().split(" ");
			DijkstraUndirectedSP du = new DijkstraUndirectedSP(ewg, Integer.parseInt(path[0]));
			if(du.hasPathTo(Integer.parseInt(path[1]))) {
				float path1 = (int) du.distTo(Integer.parseInt((path[1])));
				System.out.println(path1);
			} else {
				System.out.println("No Path Found");
			}

			break;

		default:
			break;
		}

	}
}