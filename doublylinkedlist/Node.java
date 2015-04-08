/*
 * A node in the LinkedList
 */

package doublylinkedlist;

/**
 *
 * @author Stephanie Scarlett Tejada
 */
public class Node {
   public int value;
   public Node prev;
   public Node next;
   
   // Contructor
   // Create a new node with the specified value.
   public Node(int value){
      this.value = value;
      this.prev = null;
      this.next = null;
   }

   @Override
   public String toString() {
      return "Node{" + "value=" + value + ", prev=" + prev + ", next=" + next + '}';
   }
   
   
}
