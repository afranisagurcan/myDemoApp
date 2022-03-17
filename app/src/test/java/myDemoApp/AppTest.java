package myDemoApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class AppTest {

    @Test
   public void testFound() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertTrue(App.isSameElement(array1, array2,1));
    }

    @Test
    public void testNotFound() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(0, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
        assertFalse(App.isSameElement(array1, array2,1));
    }

    @Test
    public void testEmptyArray() {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();
        assertFalse(App.isSameElement(array1,array2, 1));
    }

    @Test
    public void testNull() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        assertFalse(App.isSameElement(array1,null, 1));
    }

    
}
