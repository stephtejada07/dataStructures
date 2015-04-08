/*
 * A node in the Stack
 */

package stack;

/**
 *
 * @author Stephanie Scarlett Tejada
 */
public class Node {
   public int value;
   public Node next;
   
   // Contructor
   // Create a new node with the specified value.
   public Node(int value){
      this.value = value;
      this.next = null;
   } 

   @Override
   public String toString() {
      return "Node{" + "value=" + value + ", next=" + next + '}';
   }

   
     
   
}
