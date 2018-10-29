/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
/**graphimplementation.**/
public class Bag<Item> implements Iterable<Item> {
    /**
     * variable.
     */
    private int N;
    /**
     * variable.
     */
    private node first;
    private class node {
    /**
     * variable.
     */
        private Item item;
    /**
     * variable.
     */
        private node next;
    }
   /**
     * Create an empty stack.
     */
    public Bag() {
        first = null;
        N = 0;
    }

   /**
     * Is the BAG empty?
     * @return value
     */
    public boolean isEmpty() {
        return first == null;
    }

   /**
     * Return the number of items in the bag.
     * @return value
     */
    public int size() {
        return N;
    }

   /**
     * Add the item to the bag.
     */
    public void add(final Item item) {
        node oldfirst = first;
        first = new node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }


   /**
     * Return an iterator that iterates over the items in the bag.
     * @return value
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    /**graphimplementation.**/
    private class ListIterator implements Iterator<Item> {
    /**
     * variable.
     */
        private node current = first;
        /**
         * @brief [brief description]
         * @details [long description]
         * @return value
         */
        public boolean hasNext()  {
            return current != null;
        }
        public void remove()      {
            throw new UnsupportedOperationException();
         }
         /**
          * @brief [brief description]
          * @details [long description]
          * @return value
          */
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
