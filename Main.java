package com.solomka;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

public class Main {

    public static void main(String[] args) {

        //Task 1

        Integer array[] = {0, 2, 3, 1, 7, 11, 8, 9, 9, 17, 3, 5};
        System.out.println("Before sorting "+Arrays.toString(array));
        sortReverse(array);
        System.out.println("After sorting "+Arrays.toString(array));

        //Task 2

        Integer array_2[] = new Integer[7];
        array_2[0] = -8;
        array_2[1] = 79;
        array_2[2] = 2;
        array_2[3] = -11;
        array_2[4] = -13;
        array_2[5] = 9;
        array_2[6] = 0;
        System.out.println("The sum of all positive elements is " + sumOfPositive(array_2));


        //Task 3
        System.out.println("Average " + averageOfElements(array));

        //Task 4
        Integer array_3[] = {-5, 0, 1, 2, 1, 2, 1, 8, 5, 9, 9};
        System.out.println("Original array          " + Arrays.toString(array_3));
        replaceDuplicate(array_3);
        System.out.println("Duplicates was replaced " + Arrays.toString(array_3));

    }

    //Create next array of Integers with values: 2,3,1,7,11. Sort them by DESC(reverseOrder).

    public static void sortReverse(Integer[] array) {
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    //You get an array of numbers(should contain both positive and negative numbers),
    // and return the sum of all the positive ones. (If there are nothing to sum, sum should be 0)

    public static int sumOfPositive(Integer array[]) {
        Arrays.sort(array, Comparator.reverseOrder());
        int result = 0;
        for (Integer i : array) {
            if (i > 0) {
                result += i;
            } else {
                break;  // выходим из цикла при достижении первого отрицтельного числа. их считать не имеет смысла
            }
        }
        return result;
    }

    //You get an array of numbers, return the average of a list of numbers in this array.
    // (Example -  array{1,2,4,1} -> avg = 2)

    public static int averageOfElements(Integer array[]) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result / array.length;

    }

    //You have array {3,2,3,1,4,2,8,3}.
    // Replace all duplicated values by 0. Result should be  next: {3,2,0,1,4,0,8,0}

    public static void replaceDuplicate(Integer array[]) {
        int x;
        for (int i = 0; i < array.length; i++) {
            //System.out.println("array[" + i + "] = " + array[i]);
            if (array[i].equals(0)) {   //чтобы не менять нули на нули.
                continue;
            }
            for (int j = i + 1; j < array.length; j++) {
                //System.out.println("   array[" + j + "] = " + array[j]);
                if (array[i].equals(array[j])) {
                    array[j] = 0;
                }
            }
        }
    }
}



