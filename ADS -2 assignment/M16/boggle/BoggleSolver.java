import java.util.*;
public class BoggleSolver {
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
	private TrieSET dict;
	public BoggleSolver(String[] dictionary) {
		dict = new TrieSET();
		for (int i = 0; i < dictionary.length; i++) {
			dict.add(dictionary[i]);
		}

	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable.
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		Set<String> valid = new HashSet<String>();
		boolean[][] marked;
		for (int i = 0; i < board.rows(); i++) {
			for (int j = 0; j < board.cols(); j++) {
				 marked = new boolean[board.rows()][board.cols()];
				collect(board, i, j, marked, "", valid);
			}
		}
		return valid;
	}
	private void collect(BoggleBoard board, int i, int j, boolean[][] marked, String start, Set<String> valid) {
		//if(i <= board.rows() && j <= board.cols()) {
		if (marked[i][j]) {
			return;
		}
		char letter = board.getLetter(i, j);
		String word = start;
		if (letter == 'Q') {
			word +=  "QU";
		} else {
			word += letter;
		}
		if(!dict.hasPrefix(word)) {
			return;
		}
		if (word.length() > 2 && dict.contains(word)) {
			valid.add(word);

		}
		marked[i][j] = true;
		for (int row = -1; row <= 1; row++) {
			for (int col = -1; col <= 1; col++) {
				if(i == 0 && j == 0) {
					continue;
				}
				if ((row + i >= 0) && (row + i < board.rows()) && (col + j >= 0) && (col + j < board.cols())) {
					collect(board, row + i, col + j, marked, word, valid);
				}
			}
		}
		marked[i][j] = false;
	}
//}
	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A through Z.)
	public int scoreOf(String word) {
		if (dict.contains(word)) {
			switch (word.length()) {
			case 0:
			case 1:
			case 2:
				return 0;
			case 3:
			case 4:
				return 1;
			case 5:
				return 2;
			case 6:
				return 3;
			case 7:
				return 5;
			default:
				return 11;
			}
		} else {
			return 0;
		}
	}
}