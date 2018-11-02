import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String sysnsets = "Files" + "\\" + s.nextLine();
		String hypernymsets = "Files" + "\\" + s.nextLine();
		String input = s.nextLine();
		try {
		WordNet w = new WordNet(sysnsets, hypernymsets);
		if(input.equals("Graph")) {
				if(!w.isflag()) {
					w.print();
				}
			} else if(input.equals("Queries")) {
			while(s.hasNextLine()) {
				String[] tokens = s.nextLine().split(" ");
				String str = w.sap(tokens[0], tokens[1]);
				int dis = w.distance(tokens[0], tokens[1]);
				System.out.println("distance = " + dis + ", ancestor = " +str);
			}
		}
		} catch(Exception e) {
			System.out.println("IllegalArgumentException");

		}
	}
}