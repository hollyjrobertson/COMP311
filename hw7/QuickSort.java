package hw7;
public class QuickSort {
    
    int []a;
    int x;
    
    //Constructor
    public QuickSort(int[] a) {
        this.a = a;
    }
    
    // This method sorts an array and internally calls quickSort 
    // Returns the printed array
    public String sort(){
        int left = 0;
        int right = a.length-1;
             
        quickSort(left, right);
        return printArray();
    }
     
    // This method is used to sort the array using quicksort algorithm.
    // It takes left and the right end of the array as two cursors
    private void quickSort(int left,int right){
         
        // If both cursor scanned the complete array, quicksort exits
        if(left >= right)
            return;
         
        // Pivot using median of 3 approach
        int pivot = getPivot(left, right);
        int partition = partition(left, right, pivot);
         
        // Recursively, calls the quicksort with the different left and right parameters of the sub-array
        quickSort(0, partition-1);
        quickSort(partition+1, right);
    }
     
    // This method is used to partition the given array and returns the integer which points to the sorted pivot index
    private int partition(int left, int right, int pivot) 
    {
      int i = (left-1); // index of smaller element 
      for (int j=left; j<right; j++) 
      { 
          // If current element is smaller than or 
          // equal to pivot 
          if (a[j] <= pivot) 
          { 
              i++; 
              // swap arr[i] and arr[j] 
              swap(i, j); 
          } 
      } 
      // swap arr[i+1] and arr[high] (or pivot) 
      swap(i+1, right);
 
      return i+1; 
    }
     
    public int getPivot(int left,int right){
        int center = (left+right)/2;

        //Tests to see if left is > center
        //If it is, swap left & center
        if(a[left] > a[center])
            swap(left,center);
         
        //Tests to see if left is > right
        //If it is, swap left and right
        if(a[left] > a[right])
            swap(left, right);
         
        //Tests to see if center is > right
        //If it is, swap center and right
        if(a[center] > a[right])
            swap(center, right);
         
        //Swap center to right
        swap(center, right);
        return a[right];
    }
     
    // This method is used to swap the values between the two given index
    public void swap(int left,int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
     
    public String printArray(){
        String result = "";
        for(int i : a){
            result += (i + " ");
        }
        return result;
    }
}