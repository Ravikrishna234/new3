import java.util.Scanner;
/**PERCOLATION.**/
final class Solution {
    /**
     * @brief [brief description]
     * @details [long description]
     */
    private Solution() { }
    /**
     * @brief [brief description]
     * @details [long description]
     * @param args value
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        //
        Percolation p = new Percolation(n);
        while (s.hasNextLine()) {
        String[] tokens = s.nextLine().split(" ");
        p.open(Integer.parseInt(tokens[0]) - 1,
            Integer.parseInt(tokens[1]) - 1);
    }
    //Percolation p = new Percolation(n);
    System.out.println(p.percolates());
    }
}

