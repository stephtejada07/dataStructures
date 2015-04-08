/*
 * A binary search tree node class 
 * The value and left/right pointers.
 */

package bst;

/**
 *
 * @author Stephanie Scarlett Tejada
 */
public class BSTNode {
   // Class properties
   public int value;
   public BSTNode left;
   public BSTNode right;
   
   // Contructor
   // Create a new BST node with the specified value.
   public BSTNode(int value){
      this.value = value;
      this.left = null;
      this.right = null;
   }

   @Override
   public String toString() {
      return "BSTNode{" + "value=" + value + ", left=" + left + ", right=" + right + '}';
   }
   
   
   
}
