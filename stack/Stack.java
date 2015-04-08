/*
 * A Last In First Out (LIFO) collection implemented as a linked list.
* Operations: Peek, Push, Pop
 */

package stack;

/**
 *
 * @author Stephanie Scarlett Tejada
 */
public class Stack {
   // The first node in the stack or null if empty
   Node top;
   // The last node in the stack or null if empty
   Node bottom;
   int count;
   
   //
   private boolean isEmpty(){
      if(count==0){
         return true;
      }
      return false;
   } // isEmpty
   
   // Enumerate over the stack values from Head to Tail
   public void printStack(Node node){
      while(node != null){
         System.out.println(node.value); // Print the value of the current node
         node = node.next; //  Set node to be equal to the next node
      }
   } //printStack
   
   // Removes all the nodes from the stack
   public void clear(){
      top = null;
      bottom = null;
      count = 0;
   } //clear
   
   //----------------------------------OPERATIONS-------------------------------------
   
   // Returns the top item from the stack without removing it from the stack
   public int peek(){
      return top.value;
   }
   
   // Add the specified value to the top of the stack
   public void push(int value){
      // Allocate a new node 
      Node newTop = new Node(value);
      
      if(isEmpty()){
         // If the stack is empty top and bottom
         // should both point to the new node
         top = newTop;
         bottom = top;
      }
      else{
         // Save off the top node
         Node oldTop = top;
         
         // Point top to new node
         top = newTop;
         
         // Insert the rest of the stack 
         top.next = oldTop;
      }
      // Update count of nodes
      count++;
   } //push
   
   // Removes and returns the top item from the stack
   public int pop() {
      // Empty stack - do nothing
      
      // Save the top-most value in the stack
      int value = top.value;

      //Make sure stack is not empty
      if(!isEmpty()){
          // If the stack has only *one* element
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

   } //pop

   @Override
   public String toString() {
      return "Stack{" + "top=" + top + ", bottom=" + bottom + ", count=" + count + '}';
   }
   
   
   
}
