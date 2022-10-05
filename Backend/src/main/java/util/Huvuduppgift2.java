package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Huvuduppgift2 {

    public static String addZerosToInt(int number) {
        String value = String.valueOf(number);
        StringBuilder sb = new StringBuilder();

        if(value.length() >= 5){
            sb.append(value, 0, 5);
        }
        else {
            for (int i = 5; i > value.length(); i--) {
                if (i > value.length()) {
                    sb.append(0);
                }
            }
            sb.append(value);
        }

        return sb.toString();
    }

    public static int findNthLargestNumber(int number, List<Integer> numbers){
        List<Integer> sortedArray = sortList(numbers);

        return sortedArray.get(number - 1);
    }

    public static List<Integer> sortList(List<Integer> numbers){
        Collections.sort(numbers);
        List<Integer> sortedList = new ArrayList<>();
        for(int i = numbers.size() - 1; i >= 0; i--){
            sortedList.add(numbers.get(i));
        }
        return sortedList;
    }

}
