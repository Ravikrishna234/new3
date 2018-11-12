public class MSD {
    /**
     * variable.
     */
    private static final int BITS_PER_BYTE =   8;
    /**
     * variable.
     */
    private static final int BITS_PER_INT  =  32;
    /**
     * variable.
     */
    private static final int R             = 256;
    /**
     * variable.
     */
    private static final int CUTOFF        =  15;

    // do not instantiate
    public MSD() { }

   /**
     * Rearranges the array of extended ASCII strings in ascending order.
     * Time complexity is O(wn)
     * w is wordlength and n is no of strings
     * @param a the array to be sorted
     */
    public static void sort(final String[] a) {
        int n = a.length;
        String[] aux = new String[n];
        sort(a, 0, n-1, 0, aux);
    }

    // return dth character of s, -1 if d = length of string
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(1)
     * @param s value
     * @param d value
     *
     * @return value
     */
    private static int charAt(final String s, final int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) return -1;
        return s.charAt(d);
    }

    // sort from a[lo] to a[hi], starting at the dth character
    /**
     * @brief [brief description]
     * @details [long description]
     * @param a value
     * @param lo value
     * @param hi value
     * @param d value
     * @param aux value
     *  Time complexity is O(wn)
     * w is wordlength and n is no of strings
     */
    private static void sort(final String[] a, final int lo,
        final int hi, final int d, final String[] aux) {

        // cutoff to insertion sort for small subarrays
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }

        // compute frequency counts
        int[] count = new int[R+2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            count[c+2]++;
        }

        // transform counts to indicies
        for (int r = 0; r < R+1; r++)
            count[r+1] += count[r];

        // distribute
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            aux[count[c+1]++] = a[i];
        }

        // copy back
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];


        // recursively sort for each character (excludes sentinel -1)
        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
    }


    // insertion sort a[lo..hi], starting at dth character
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param a value
     * @param lo value
     * @param hi value
     * @param d value
     * Time complexity is O(N^2)
     */
    private static void insertion(final String[] a, final int lo,
    final int hi, final int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                exch(a, j, j-1);
    }

    // exchange a[i] and a[j]
    /**
     * @brief [brief description]
     * @details [long description]
     *
     * @param a value
     * @param i value
     * @param j value
     * Time complexity is O(1)
     */
    private static void exch(final String[] a,
        final int i, final int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // is v less than w, starting at character d
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(len of minimum string)
     * @param v value
     * @param w value
     * @param d value
     * @return value
     */
    private static boolean less(final String v,
        final String w, final int d) {
        // assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) {
             return true;
         }
            if (v.charAt(i) > w.charAt(i)) {
             return false;
         }
        }
        return v.length() < w.length();
    }
    /**
     * @brief [brief description]
     * @details [long description]
     *  Time complexity is O(N)
     * @param a value
     * @return value
     */
    public String toString(String[] a) {
        String str = "[";
        for(int i = 0; i < a.length - 1; i++) {
            str += a[i] + ", ";
        }
        str += a[a.length - 1] + "]";
        return str;

    }
}