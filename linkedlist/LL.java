/*
 * Linked list collection capable of basic operations suchs as
 * Add, Remove, Enumerate
 */

package linkedlist;

/**
 *
 * @author Stephanie Scarlett Tejada
 */
public class LL {
   // The first node in the list or null if empty
   private Node head; 
   // The last node in the list or null if empty
   private Node tail;
   private int count;
   
   //
   private boolean isEmpty(){
      if(count==0){
         return true;
      }
      return false;
   }
   
   // Enumerate over the linked list values from Head to Tail
   public void printList(Node node){
      while(node != null){
         System.out.println(node.value); // Print the value of the current node
         node = node.next; //  Set node to be equal to the next node
      }
   }
   
   // Removes all the nodes from the list
   public void clear(){
      head = null;
      tail = null;
      count = 0;
   } //clear
   
   //----------------------------------OPERATIONS-------------------------------------
   
   // Add new value at the start of the linked list
   public void addFront(int value){
      // Allocate a new node 
      Node newHead = new Node(value);
      
      if(isEmpty()) { 
         // If the list is empty head and tail
         // should both point to the new node
         head = newHead;
         tail = head;
      }
      else{
         // Save off the head node
         Node oldHead = head;
         
         // Point head to new node
         head = newHead;
         
         // Insert the rest of the list 
         head.next = oldHead;
      }
      // Update count of nodes
      count++;
   } // addFront
   
   // Add new value at the end of the linked list
   public void addEnd(int value){
      // Allocate a new node 
      Node newTail = new Node(value);
      
      if(isEmpty()) { 
         // If the list is empty head and tail
         // should both point to the new node
         head = newTail;
         tail = head;
      }
      else{
         // Point tail to new node
         tail.next = newTail;
         
         // Update tail to new node
         tail = newTail;
      }
      // Update count of nodes
      count++;
   } // addEnd
   
   // Remove the first node from the list
   public void removeFront(){
      // Empty list - do nothing
      
      //Make sure list is not empty
      if(!isEmpty()){
         
         // If the list has only *one* element
         // both head and tail should point to null
         if(count==1){
            head = null;
            tail = null;
         }
         
         // Update head pointer to the node 
         // that follows head
         else{
            head = head.next;
         }
         // Update count of nodes
         count--;
      }
   } // removeFront

   // Remove the last node from the list
   public void removeEnd(){
      // Empty list - do nothing
      
      //Make sure list is not empty
      if(!isEmpty()){
         // If the list has only *one* element
         // both head and tail should point to null
         if(count==1){
            head = null;
            tail = null;
         }
         
         // Enumerate over all the nodes in the list
         else{
            Node current = head;
            while(current.next != tail){
               current = current.next;
            }
            // Update tail pointer to null
            current.next= null;
            // Update tail 
            tail = current;           
         }
         // Update count of nodes
         count--;
      }
   } // removeEnd

   
   @Override
   public String toString() {
      return "LL{" + "head=" + head + ", tail=" + tail + ", count=" + count + '}';
   }
   
   
        
}
