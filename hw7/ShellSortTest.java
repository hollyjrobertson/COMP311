package hw7;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShellSortTest
{
    ShellSort ss;
    int arr[] = {34, 19, 3, 22, 5, 2, 46, 30, 17, 8, 41, 21};
    
    @Before
    public void setUp() throws Exception {
        ss = new ShellSort(arr);
    }

    @After
    public void tearDown() throws Exception {
        ss = null;
    }

    @Test
    public void test() {
        String answer = "2 3 5 8 17 19 21 22 30 34 41 46 ";
        
        assertEquals(answer, ss.sort());
    }

}
