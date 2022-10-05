package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import util.Huvuduppgift2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Huvuduppgift2Test {

    @Test
    void addZerosToInt(){
        String result1 = Huvuduppgift2.addZerosToInt(1);

        assertEquals("00001", result1);

        String result2 = Huvuduppgift2.addZerosToInt(10);

        assertEquals("00010", result2);

        String result3 = Huvuduppgift2.addZerosToInt(100);

        assertEquals("00100", result3);

        String result4 = Huvuduppgift2.addZerosToInt(1000);

        assertEquals("01000", result4);

        String result5 = Huvuduppgift2.addZerosToInt(10000);

        assertEquals("10000", result5);

        //In this case, when writing a number with over 5 digits, the result should still only have 5.
        String result6 = Huvuduppgift2.addZerosToInt(100000);

        assertEquals("10000", result6);
    }

    @Test
    void findNthLargestNumberTest(){
        List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 2, 3, 3, 9);
        int result = Huvuduppgift2.findNthLargestNumber(2, numbers);

        assertEquals(5, result);
    }

    @Test
    void sortListTest(){
        List<Integer> unsortedList = Arrays.asList(1, 5, 2, 3, 4);
        List<Integer> sortedList = Huvuduppgift2.sortList(unsortedList);

        assertEquals(Arrays.asList(5, 4, 3, 2, 1), sortedList);
    }

}
