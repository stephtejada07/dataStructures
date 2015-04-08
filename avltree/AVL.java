/*
 * A self-balancing binary search tree collection.
 * Keeps information in sorted order.
* Operations: Add, Search
 */

package avltree;

/**
 *
 * @author Stephanie Scarlett Tejada
 */
public class AVL {
   private AVLNode root;
   private int count; // Number of items currently contained in the tree
   
    // Remove all items from the tree
    public void clear(){
       root = null;
       count = 0;
    }
    
    
/*
 * Support Properties
 */
    
// Node Height
//Distance from the current node to its furthest child node
    private int height(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    
// Max Node Height 
//Each node's height based on left and right child's height
//Returns 1+the max height of its left and right children
   private int maxNodeHeight(AVLNode node){
      //if left and right child were null, return ZERO
     /* if(node==null){
         return 0;
      } */
        return Math.max(height(node.left), height(node.right)) + 1;
   }
    
    
// Height Difference
//"Balance Factor": difference between node's left and right node heights
//It helps determine if three is leftHeavy or rightHeavy
//If >1 is leftHeavy
//If <-1 is rightHeavy
    private int heightDiff(AVLNode node) {
        if (node == null) {
            return 0; 
        }
        // Return <-1 if rightheavy
        //Return >+1 if leftheavy
        //Return {-1,0,1} if balanced
        return height(node.left) - height(node.right);
    }
    
    
   /*
    * Balance Rotations
    */
    
    // If tree is right heavy, perform a left rotation
    private AVLNode leftRotate(AVLNode node) {
        //Right child becomes de new root
        AVLNode r = node.right;
        // Update old root's right child to new root left child
        node.right = r.left;
        // Old root becomes new root's left child
        r.left = node;
        // Calculate height for node and r nodes
        node.height = maxNodeHeight(node);
        r.height = maxNodeHeight(r);
        // Return new root
        return r;
    }

   // If tree is left heavy, perform a right rotation
   private AVLNode rightRotate(AVLNode node) {
         //Left child becomes new root
        AVLNode r = node.left;
        // Update old root's left child to new root right child
        node.left = r.right;
        // Old root becomes new root's right child
        r.right = node;
        // Calculate height for node and r nodes
        node.height = maxNodeHeight(node);
        r.height = maxNodeHeight(r);
        // Return new root
        return r;
    }

    
    
     //----------------------------------OPERATIONS-------------------------------------

     //  Add the specified value to the AVL binary search tree.
     public void add(int value) {
        root = addTo(root, value);
        count++; // update the number of nodes
     } //add

     
     //
     //
     //
     private AVLNode addTo(AVLNode node, int value) {
       
       // Case 1: The node is empty - allocate the node
        if (node == null) {
            node = new AVLNode(value);
            return node;
        } 
        
         // Case 2: The tree is not empty 
        // find the right location to insert value
        else {
           //If new value is less than current node value 
           // go left
            if (value<node.value) {
                node.left = addTo(node.left, value);
            } 
            //If new value is more than current node value 
            // go right
            else {
                node.right = addTo(node.right, value);
            }


            // MAX_NEW_NODE_HEIGHT
            //Find out the height of the current new node
            node.height = maxNodeHeight(node);

            
            //HEIGHT_DIFFERENCE
            //Find out if tree is unbalanced
            int heightDiff = heightDiff(node);

            //BALANCE
            //If tree is unbalanced, choose the right method to balance the tree
            //Based on whether is rightHeavy or leftHeavy
            if (heightDiff > 1) { //leftHeavy
                if (heightDiff(node.left) < 0) {
                      node.left = leftRotate(node.left);
                } 
                return rightRotate(node);
                
            } 
            
            else if (heightDiff < -1) {    //rightHeavy
                if (heightDiff(node.right) > 0) {
                    node.right = rightRotate(node.right);
                } 
               return leftRotate(node);

            } 
            //if it's not right or left heavy it must be balanced
            else;

        }
        return node;
    } //addTo

   
    // Determine if the specified value exists in the binary tree.
   // Finds and returns the first node containing the specified value. 
   //If the value is not found, returns null.
   public AVLNode search(int value){ //The value to search for.
      AVLNode current = root;
      
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
   
   private void inOrder(AVLNode current) {
      if(current!=null){
         inOrder(current.left);
         System.out .println(current.value); // The action to perform
         inOrder(current.right);
      }
   }
   

   @Override
   public String toString() {
      return "AVLTree{" + "root=" + root + ", count=" + count + '}';
   }

}
