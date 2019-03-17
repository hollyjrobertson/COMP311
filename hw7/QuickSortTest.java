package hw7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickSortTest
{
    QuickSort qs;
    int arr[] = {34, 19, 3, 22, 5, 2, 46, 30};
    int left;
    int right;
    
    @Before
    public void setUp() throws Exception {
        qs = new QuickSort(arr);
        left = 0;
        right = (arr.length - 1);
    }

    @After
    public void tearDown() throws Exception {
        qs = null;
    }

    @Test
    public void testSort() {
        String answer = "2 3 5 19 22 30 34 46 ";
   
        assertEquals(answer, qs.sort());
    }
    @Test
    public void testGetPivot() {
        int answer = 30;
        assertEquals(answer, qs.getPivot(left, right));
    }


}
