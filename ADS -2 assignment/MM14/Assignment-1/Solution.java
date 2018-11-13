import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] words = loadWords();

		TST<Integer> ts = new TST<Integer>();
		for (int i = 0; i < words.length; i++) {
			ts.put(words[i],i);
		}
		String s1 = s.nextLine();
		//String[] tokens = ts.keysWithPrefix(s1).split(" ");
		for(String st : ts.keysWithPrefix(s1)) {
			System.out.println(st);
		}

	}

	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		String[] words = in.readAllStrings();
		return words;
	}
}