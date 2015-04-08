/*
 * A node in the Linked List
 */

package linkedlist;

/**
 *
 * @author Stephanie Scarlett Tejada
 */
public class Node {
   // Properties
   public  int value; // holds the actual value 
   public Node next; // holds the information of the next pointer
   
   // Constructor 
   // Create new node with the specified value
   public Node(int value){
      this.value = value;
      this.next = null;
   }

   @Override
   public String toString() {
      return "Node{" + "value=" + value + ", next=" + next + '}';
   }
   
   
}
