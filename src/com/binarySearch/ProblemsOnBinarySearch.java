package com.binarySearch;

import java.util.Arrays;

public class ProblemsOnBinarySearch {

    public static void main(String[] args) {
        int[] ascendingSortedArray = {-3, -2, -1, 0, 1, 3, 5, 6, 7, 11, 12, 14, 16};
        for (int target : Arrays.asList(-4, -5, -1, 0, 3, 9, 10, 19)) {
            int ceilingOfNumber = ceilingOfNumber(ascendingSortedArray, target);
            System.out.println(String.format("Ceiling of %s in Array:%s = %s", target, Arrays.toString(ascendingSortedArray), ceilingOfNumber != Integer.MIN_VALUE ? ceilingOfNumber : "Does not exists"));
        }
    }

    static int ceilingOfNumber(int[] arr, int target) {
        int indexOfStartElement = 0;
        int indexOfEndElement = arr.length - 1;
        int indexOfMidElement;
        int midElement;
        boolean isAscneding = arr[indexOfStartElement] < arr[indexOfEndElement];

        if (target < arr[indexOfStartElement])
            return arr[indexOfStartElement];
        else if (arr[indexOfEndElement] < target)
            return Integer.MIN_VALUE;

        while (indexOfStartElement <= indexOfEndElement) {
            indexOfMidElement = indexOfStartElement + (indexOfEndElement - indexOfStartElement) / 2;
            midElement = arr[indexOfMidElement];

            if (target == midElement)
                return midElement;

            if (isAscneding) {
                if (target < midElement)
                    indexOfEndElement = indexOfMidElement - 1;
                else if (midElement < target)
                    indexOfStartElement = indexOfMidElement + 1;
            } else {
                if (target > midElement)
                    indexOfEndElement = indexOfMidElement - 1;
                else if (midElement > target)
                    indexOfStartElement = indexOfMidElement + 1;
            }
        }

        return arr[indexOfStartElement];
    }
}
