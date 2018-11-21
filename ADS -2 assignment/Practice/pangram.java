import java.util.Scanner;
class pangram {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String s1 = s.nextLine();
		boolean flag = false;
		boolean[] marked = new boolean[26];
		int index = 0;
		for(int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) >= 'A' && s1.charAt(i) <= 'Z') {
				index = s1.charAt(i) - 'A';
				System.out.println(index);
				marked[index] = true;
			}
		}
		    //System.out.println(marked.length);
		for(int i = 0; i < marked.length - 1; i++) {
			if(marked[i] == false) {
				System.out.println("Not pangram");
				flag = false;
				break;
			} else {
				flag = true;
			}
		}
		if(flag) {
			System.out.println("Pangram");
		}
	}
}
