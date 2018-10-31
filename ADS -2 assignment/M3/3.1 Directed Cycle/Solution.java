import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num1 = Integer.parseInt(s.nextLine());
		int num2 = Integer.parseInt(s.nextLine());
		DiGraph dg = new DiGraph(num1);

		while(s.hasNextLine()) {
			String[] tokens = s.nextLine().split(" ");
			dg.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
			DirectedCycle cycle = new DirectedCycle(dg);
		if(cycle.hasCycle()){
			System.out.println("Cycle exists.");

		} else {
			System.out.println("Cycle doesn't exists.");
		}
	}
}