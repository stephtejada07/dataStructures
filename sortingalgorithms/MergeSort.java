/*
 * MergeSort 
 *  Comparison-based sorting algorithm
 * 
 */

package sortingalgorithms;

/**
 *
 * @author Stephanie Scarlett Tejada
 */
public class MergeSort {
   
   // Properties
   private int[] numbers; // Original array
   private int[] helper; // Helper array
   private int n; // 
   
   
   // Given an array of int, sort array in ascending order
   public void sort(int[] values) {
      //
      this.numbers=values;
      // Get the length of the original array
      n=values.length;
      // 
      this.helper=new int[n];
      mergesort(0, n-1);
   } // sort
   
   // Array is recursively split in half
   // Until each split array has only one element in it
   private void mergesort(int low, int high) {
      if(low<high) { //if beginning < end
         int middle=(low+high)/2; //set middle
         mergesort(low, middle);    //call mergesort(beg,mid) ->left subArray
         mergesort(middle+1, high); //call mergesort (mid+1, end) ->right subArray
         merge(low, middle, high); //call merge(beg, mid, end)
      }
   } //mergesort
   
   private void merge(int low, int middle, int high) {
      
      // Copy both parts into helper array
      for(int i=low; i<=high; i++) {
         helper[i]=numbers[i];
      }
   
      int i=low; //beginning of left subArray
      int j=middle+1; //beginning of right subArray
      int k=low; //index for numbers array
  
      // Copy the smallest values from either the left or the right subarray
      // back to the numbers (original) array
      while (i<=middle && j<=high) {
      //-------left-------//-------right-------
         if(helper[i]<=helper[j]) {
            numbers[k]=helper[i];
            i++;
         }
         else {
            numbers[k]=helper[j];
            j++;
         }
         k++;
      } // end while
   
      // If left sub array has more values
      //Copy the rest of the elements on the left
      while(i<=middle) {
         numbers[k]=helper[i];
         k++;
         i++;
      }
      
      // If right sub array has more values
      // Copy the rest of the elements on the right
      while(j<=high) {
         numbers[k]=helper[j];
         k++;
         j++;
      }
   } //merge


}
