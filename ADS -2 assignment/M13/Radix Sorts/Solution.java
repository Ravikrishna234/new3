import java.util.Scanner;
/**MOSTSIGNIFICANTDIGITSORT.**/
final class Solution {
    /**
     * @brief [brief description]
     * @details [long description]
     */
    private Solution() {

    }
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param args value
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] tokens = new String[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = s.nextLine();
        }
        MSD m = new MSD();
        m.sort(tokens);
    System.out.println(m.toString(tokens));
    }
}

