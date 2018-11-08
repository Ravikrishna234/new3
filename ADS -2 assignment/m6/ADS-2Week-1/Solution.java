import java.util.Scanner;
import java.util.Arrays;
/**PAGERANK.**/
class PageRank {
    /**
     * variable.
     */
    private Digraph graph;
    /**
     * variable.
     */
    private double[] a;
    /**
     * variable.
     */
    private int vertices;
    /**
    * variable.
    */
    private double[] b;
    /**
    * variable.
    */
    private final int thousand = 1000;
    /**
    * variable.
    */
    private double result;

    /**
     * @brief [brief description]
     * @details [long description]
     * @param g value
     */
    PageRank(final Digraph g) {
        this.graph = g;
        this.vertices = g.V();
        a = new double[this.vertices];
        b = new double[this.vertices];
    }
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(N ^ 2)
     * @param g value
     */
    public void computerank(final Digraph g) {
        double divide = (double) vertices;
        for (int i = 0; i < vertices; i++) {
            a[i] = 1 / divide;
            //System.out.println(a[i]);
        }
        int temp = vertices;
        Digraph reverse = g.reverse();
        for (int i = 0; i < thousand; i++) {
            for (int j = 0; j < temp; j++) {
                result = 0.0;
                for (int k : reverse.adj(j)) {
                    result += ((a[k])) / ((double) ((g.outdegree(k))));
                }
                b[j] = result;
            }
            if (Arrays.equals(a, b)) {
                break;
            } else {
                a = b.clone();
            }
        }
    }
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(N)
     * @return value
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < vertices; i++) {
            str += i + " - " + b[i] + "\n";
        }
        return str;

    }
}
/**pagerank.**/
class WebSearch {

}

/**pagerank.**/
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
        int j = 0;
        Digraph g = new Digraph(n);
        Digraph g1 = new Digraph(n);
        while (j < n) {
            String[] tokens = s.nextLine().split(" ");
            if (tokens.length >= 2) {
                for (int i = 1; i < tokens.length; i++) {
                    //g.addEdge(Integer.parseInt(tokens[0]),
                        //Integer.parseInt(tokens[i]));
                    g1.addEdge(Integer.parseInt(tokens[0]),
                               Integer.parseInt(tokens[i]));
                }
            }  else {
                for (int k = 0; k < n; k++) {
                    if (k != Integer.parseInt(tokens[0])) {
                        g1.addEdge(Integer.parseInt(tokens[0]), k);
                    }

                }
            }
            j++;
        }
        System.out.println(g);
        // for (int i = 0; i < g.V(); i++) {
        //     if (g.outdegree(i) == 0) {
        //         for (j = 0; j < g.V(); j++) {
        //             if (i != j) {
        //                 g.addEdge(i,j);
        //             }
        //         }
        //     }
        // }
        PageRank p = new PageRank(g1);
        p.computerank(g1);
        System.out.println(p);
        // File path to the web content
        String file = "WebContent.txt";

    }
}

