import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		//
		Percolation p = new Percolation(n);
		while(s.hasNextLine()) {
		String[] tokens = s.nextLine().split(" ");
		p.open(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
	}
	//Percolation p = new Percolation(n);
	System.out.println(p.percolates());

	}
}