import java.util.Iterator;
import java.util.NoSuchElementException;
/**hasacycle.**/
/**
 * @param Item value
 */
public class Stack<Item> implements Iterable<Item> {
    /**
     * variable.
     */
    private int Num;
    /**
     * variable.
     */
    private Node first;
    /**hasacycle.**/
    private class Node {
     /**
     * variable.
     */
        private Item item;
    /**
     * variable.
     */
        private Node next;
    }

   /**
     * Create an empty stack.
     */
    public Stack() {
        first = null;
        Num = 0;
    }

   /**
     * Is the stack empty?
     * @return value
     */
    public boolean isEmpty() {
        return first == null;
    }

   /**
     * Return the number of items in the stack.
     * @return value
     */
    public int size() {
        return Num;
    }

   /**
     * Add the item to the stack.
     * @param item value
     */
    public void push(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        Num++;
    }

   /**
     * @return value
     */
    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        Num--;
        return item;                   // return the saved item
    }


   /**
     * @return value
     */
    public Item peek() {
        if (isEmpty()) {
    throw new RuntimeException("Stack underflow");
    }
        return first.item;
    }

   /**
     * Return string representation.
     * @return value
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }


   /**
     * @return value
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**hasacycle.**/
    private class ListIterator implements Iterator<Item> {
        /**.
         * variable.
         */
        private Node current = first;
        /**
         * @return value
         */
        public boolean hasNext() {
            return current != null;
             }
             /**
              * @brief [brief description]
              * @details [long description]
              */
        public void remove() {
        throw new UnsupportedOperationException();
             }
            /**
             * @return value
             */
        public Item next() {
            if (!hasNext()) {
             throw new NoSuchElementException();
        }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


   /**
     * A test client.
     */
/*    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }*/
}

