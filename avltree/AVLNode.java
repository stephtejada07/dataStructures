/*
 * An AVL binary search tree node class 
 * The value and left/right pointers.
 */

package avltree;

/**
 *
 * @author Stephanie Scarlett Tejada
 */
public class AVLNode {
   // Class properties
   public int value;
   public int height;
   public AVLNode left;
   public AVLNode right;
   
   // Contructor
   // Create a new AVL node with the specified value.
   public AVLNode(int value) {
      this.value = value;
      this. height = 1;
   }
     
   @Override
   public String toString() {
      return "AVLNode{" + "value=" + value + ", height=" + height + ", left=" + left + ", right=" + right + '}';
  }


  
}
