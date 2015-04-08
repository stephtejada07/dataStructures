/*
 * A First In First Out (FIFO) collection implemented as a linked list.
* Operations: Peek, Enqueue, Dequeue 
 */

package queue;

/**
 *
 * @author Stephanie Scarlett Tejada
 */
public class Queue {
   // The first node in the queue or null if empty
   Node top;
   // The last node in the queue or null if empty
   Node bottom;
   int count;
   
   //
   private boolean isEmpty(){
      if(count==0){
         return true;
      }
      return false;
   } // isEmpty
   
    // Enumerate over the queue values from Head to Tail
   public void printQueue(Node node){
      while(node != null){
         System.out.println(node.value); // Print the value of the current node
         node = node.next; //  Set node to be equal to the next node
      }
   } //printQueue
   
   // Removes all the nodes from the queue
   public void clear(){
      top = null;
      bottom = null;
      count = 0;
   } //clear
   
   //----------------------------------OPERATIONS-------------------------------------
   // Returns the first item from the queue without removing it from the queue
   public int peek(){
      return top.value;
   }
   
   // Add the specified value to the bottom (end) of the queue
   public void enqueue(int value){
      // Allocate a new node 
      Node newBottom = new Node(value);
      
      if(isEmpty()){
         // If the queue is empty top and bottom
         // should both point to the new node
         top = newBottom;
         bottom = top;
      }
      else{
         // Point bottom to new node
         bottom.next = newBottom;
         
         // Update bottom to new node
         bottom = newBottom;
      }
      // Update count of nodes
      count++;
   } //enqueue
   
   // Removes and returns the top item from the queue
   public int dequeue() {
      // Empty queue - do nothing
      
      // Save the top-most value in the queue
      int value = top.value;

      //Make sure queue is not empty
      if(!isEmpty()){
          // If the queue has only *one* element
         // both top and bottom should point to null
         if(count ==1){
            top = null;
            bottom = null;
         }
         
         // Update top pointer to the node 
         // that follows top
         else{
            top = top.next;
         }
         // Update count of nodes
         count--;
      }
      return value;
   } //dequeue

   @Override
   public String toString() {
      return "Queue{" + "top=" + top + ", bottom=" + bottom + ", count=" + count + '}';
   }
   

}
