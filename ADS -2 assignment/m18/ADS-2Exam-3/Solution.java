import java.util.Scanner;
import java.util.TreeSet;
/**T9PREDICTIVETEXT.**/
final class Solution {
    /**
     * @brief [brief description]
     * @details [long description]
     */
    private Solution() { }
    // Don't modify this method.
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param args value
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String cases = scan.nextLine();

        switch (cases) {
        case "loadDictionary":
            // input000.txt and output000.txt
            BinarySearchST<String, Integer> hash
     = loadDictionary("/Files/t9.csv");
            while (scan.hasNextLine()) {
                String key = scan.nextLine();
                System.out.println(hash.get(key));
            }
            break;

        case "getAllPrefixes":
            // input001.txt and output001.txt
            T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
            while (scan.hasNextLine()) {
                String prefix = scan.nextLine();
                t9.getAllWords(prefix);
                // for (String each : t9.getAllWords(prefix)) {
                //  System.out.println(each);
                // }
            }
            break;

        case "potentialWords":
            // input002.txt and output002.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            int count = 0;
            while (scan.hasNextLine()) {
                String t9Signature = scan.nextLine();
                for (String each : t9.potentialWords(t9Signature)) {
                    count++;
                    System.out.println(each);
                }
            }
            if (count == 0) {
                System.out.println("No valid words found.");
            }
            break;

        case "topK":
            // input003.txt and output003.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            Bag<String> bag = new Bag<String>();
            int k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                bag.add(line);
            }
            for (String each : t9.getSuggestions(bag, k)) {
                System.out.println(each);
            }

            break;

        case "t9Signature":
            // input004.txt and output004.txt
            t9 = new T9(loadDictionary("/Files/t9.csv"));
            bag = new Bag<String>();
            k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (String each : t9.t9(line, k)) {
                    System.out.println(each);
                }
            }
            break;

        default:
            break;

        }
    }

    // Don't modify this method.
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param file value
     * @return value
     */
    public static String[] toReadFile(final String file) {
        In in = new In(file);
        return in.readAllStrings();
    }
/**
 * @brief [brief description]
 * @details [long description]
 *
 * @param file value
 * @return value
 */
    public static BinarySearchST<String, Integer>
    loadDictionary(final String file) {
        BinarySearchST<String, Integer>  st
         = new BinarySearchST<String, Integer>();
        String[] tokens = toReadFile(file);
        //System.out.println(Arrays.toString(tokens));
        //String [] token = tokens.split(" ");
        for (String s : tokens) {
            String s1 = s.toLowerCase();
            if (st.contains(s1)) {
                int value = st.get(s1);
                st.put(s1, value + 1);
            } else {
                st.put(s1, 1);
            }
        }



        // your code goes here
        return st;
    }

}
/**t9predictivetext.**/
class T9 {
    /**
    * variable.
    **/
    private BinarySearchST<String, Integer> bst;
    /**
    * variable.
    **/
    private String[] tokens;
    /**
    * variable.
    **/
    private TST<Integer> ts;
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param st value
     */
    public T9(final BinarySearchST<String, Integer> st) {
        // this.bst = st;
        // this.ts = new TST<Integer>();
        // while(!bst.isEmpty()) {
        //  ts.put(bst.get());
        // }
        this.ts = new TST<Integer>();
        tokens = toReadFile("/Files/t9.csv");

        for (String s : tokens) {
            String s1 = s.toLowerCase();
            if (ts.contains(s1)) {
                int value = ts.get(s1);
                ts.put(s1, value + 1);
            } else {
                ts.put(s1, 1);
            }
        }

    }
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param file value
     * @return value
     */
    public String[] toReadFile(final String file) {
        In in = new In(file);
        return in.readAllStrings();
    }

    // get all the prefixes that match with given prefix.
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param prefix value
     * @return value
     */
    public Iterable<String> getAllWords(final String prefix) {
        // your code goes here
        for (String s : ts.keysWithPrefix(prefix)) {
            System.out.println(s.toLowerCase());
        }
        return null;
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param t9Signature value
     * @return value
     */
    public Iterable<String> potentialWords(final String t9Signature) {
        // your code goes here

        // your code goes here
        TreeSet<String> set = new TreeSet<String>();
        for (String word : ts.keys()) {
            String[] tokens1 = word.split("");
            String value = "";
            for (String str : tokens1) {
                if (str.equals("a")
                    || str.equals("b") || str.equals("c")) {
                    value += "2";
                } else if (str.equals("d")
                    || str.equals("e") || str.equals("f")) {
                    value += "3";
                } else if (str.equals("g")
                    || str.equals("h") || str.equals("i")) {
                    value += "4";
                } else if (str.equals("j")
                    || str.equals("k") || str.equals("l")) {
                    value += "5";
                } else if (str.equals("m")
                    || str.equals("n") || str.equals("o")) {
                    value += "6";
                } else if (str.equals("p") || str.equals("q")
                    || str.equals("r") || str.equals("s")) {
                    value += "7";
                } else if (str.equals("t")
                    || str.equals("u") || str.equals("v")) {
                    value += "8";
                } else if (str.equals("w") || str.equals("x")
                    || str.equals("y") || str.equals("z")) {
                    value += "9";
                }
            }
            if (value.equals(t9Signature)) {
                set.add(word);
            }
        }
        return set;
    }


    // return all possibilities(words), find top k with highest frequency.
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param words value
     * @param k value
     *
     * @return value
     */
    public Iterable<String> getSuggestions(
        final Iterable<String> words,
     final int k) {
        // your code goes here
        return null;
    }

    // final output
    // Don't modify this method.
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param t9Signature value
     * @param k value
     *
     * @return value
     */
    public Iterable<String> t9(final String t9Signature, final int k) {
        return getSuggestions(potentialWords(t9Signature), k);
    }
}

