/*
 * Binary searching for an integer in a sorted array of integers
 * 
 */

package sortingalgorithms;

/**
 *
 * @author Stephanie Scarlett Tejada
 */
public class BinarySearch {
  
   // Search for integer key in the sorted array
   // The array should be sorted in ascending order
   public boolean binarySearch(int[] ascArr, int key){
      
      int lo=0;
      int hi=ascArr.length-1;
      
      // While there are elements on the array [lo...hi]
      while(lo<=hi){
         // Split the array in half
         int mid=(lo+hi)/2;
         if(key==ascArr[mid]){
            // // If present
            return true;
         }
         else if(key<ascArr[mid]){
            // Update hi variable and discard the rest of the array
            hi=mid-1;
         }
         else{
            // Update lo variable and discard the rest of the array
            lo=mid+1;
         }
      }
      // If not present
      return false; 
   }
}
