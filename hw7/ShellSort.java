package hw7;

public class ShellSort
{
    int arr[];
    
    public ShellSort(int arr[]) {
        this.arr = arr;
    }
    /* function to sort arr using shellSort */
    public String sort()
    {
        int n = arr.length;
        
        // Start with a big gap, then reduce the gap 
        for (int gap = 2; gap > 0; gap--) 
        { 
            // Do a gapped insertion sort for this gap size. 
            // The first gap elements a[0..gap-1] are already in gapped order 
            // keep adding one more element until the entire array is 
            // gap sorted  
            for (int i = gap; i < n; i += 1) 
            { 
                // add a[i] to the elements that have been gap sorted 
                // save a[i] in hole and make a hole at position i 
                int hole = arr[i]; 
      
                // j = i. while j >= gap && element at j - gap > hole
                // decrease j by length of gap
                int j;             
                for (j = i; j >= gap && arr[j - gap] > hole; j -= gap) {
                    arr[j] = arr[j - gap]; 
                }
                
                  
                //  put hole (the original a[i]) in its correct location 
                arr[j] = hole; 
            } 
        } 
        return printArray(); 
    }
    
    public String printArray() 
    { 
        String result = "";
        int n = arr.length; 
        for (int i=0; i<n; ++i) {
            result += arr[i] + " ";
        }
        return result;
    } 
}
