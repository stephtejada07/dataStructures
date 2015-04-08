/*
 * A tree collection that keeps information in sorted order.
* Any value less than parent goes to left
* Any values more than parent goes to right
 */

package bst;

/**
 *
 * @author Stephanie Scarlett Tejada
 */
public class BST {
   
   private BSTNode root;
   private int count; // Number of items currently contained in the tree
   
   // Remove all items from the tree
   public void clear(){
      root = null;
      count = 0;
   }
   
   
   //----------------------------------OPERATIONS-------------------------------------
   
   //  Add the provided value to the binary search tree.
   public void add(int value){
      
      // Case 1: The tree is empty - allocate the root
      if(root==null){
         root = new BSTNode(value);
      }
      
      // Case 2: The tree is not empty 
      // find the right location to insert value
      else{
         addTo(root, value);
      }        
      count++; // update the number of nodes
   } //add
   
   
   // Recursive add algorithm
   public void addTo(BSTNode node, int value){
      // Allocate new node with specified value
      BSTNode newNode = new BSTNode(value);
      
      // Case 1: Value is less than the current node value
      if(value < node.value){
         // If there is no left child make this the new left
         if(node.left == null){
            node.left = newNode;
         }
         else{
            // else add it to the left node
            addTo(node.left, value);
         }
      } // End Case 1
      
      // Case 2: Value is equal to or greater than the current value
      else {
         // If there is no right, add it to the right
         if(node.right == null){
            node.right = newNode;
         }
         else{
             // else add it to the right node
            addTo(node.right, value);
         }
      } // End Case 2
   } //addTo()
   
   
   // Determine if the specified value exists in the binary tree.
   // Finds and returns the first node containing the specified value. 
   //If the value is not found, returns null.
   public BSTNode search(int value){ //The value to search for.
      BSTNode current = root;
      
      // While we don't have a match
      while(current!=null){
         
         // If the value is less than current, go left.
         if(value < current.value){
            current = current.left;
         }
         
          // If the value is more than current, go right.
         else if(value > current.value){
            current = current.right;
         }
         
          // We have a match!
         else{
            break;
         }
      }
      return current;
   }
   
   // Performs the provided action 
   // on each binary tree value in in-order traversal order.
   public void inOrder(){
      inOrder(root);
   }
   
   private void inOrder(BSTNode current) {
      if(current!=null){
         inOrder(current.left);
         System.out .println(current.value); // The action to perform
         inOrder(current.right);
      }
   }
   
   

   @Override
   public String toString() {
      return "BST{" + "root=" + root + ", count=" + count + '}';
   }
   
   
}
