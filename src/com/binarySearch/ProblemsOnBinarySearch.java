package com.binarySearch;

import java.util.Arrays;

public class ProblemsOnBinarySearch {

    public static void main(String[] args) {
        int[] ascendingSortedIntArray = {-3, -2, -1, 0, 1, 3, 5, 6, 7, 11, 12, 14, 16};
        // Finding ceiling of a number
        for (int target : Arrays.asList(-4, -5, -1, 0, 3, 9, 10, 19)) {
            int indexOfCeilingOfNumber = ceilingOrFloorOfNumber(ascendingSortedIntArray, target, true);
            System.out.println(String.format("Ceiling of %s in Array:%s = %s", target, Arrays.toString(ascendingSortedIntArray), indexOfCeilingOfNumber != -1 ? ascendingSortedIntArray[indexOfCeilingOfNumber] : "Does not exists"));
        }
        System.out.println("=================================================================================");
        // Finding floor of a number
        for (int target : Arrays.asList(-4, -5, -1, 0, 3, 9, 10, 19)) {
            int indexOfCeilingOfNumber = ceilingOrFloorOfNumber(ascendingSortedIntArray, target, false);
            System.out.println(String.format("Floor of %s in Array:%s = %s", target, Arrays.toString(ascendingSortedIntArray), indexOfCeilingOfNumber != -1 ? ascendingSortedIntArray[indexOfCeilingOfNumber] : "Does not exists"));
        }
        System.out.println("=================================================================================");
        // Finding ceiling of a char
        char[] ascendingSortedCharArray = {'H', 'c', 'f', 'g', 'k'};
        for (char target : Arrays.asList('a', 'c', 'm', 'A')) {
            int indexOfCeilingOfCharacter = ceilingOrFloorfCharacter(ascendingSortedCharArray, target, true);
            System.out.println(String.format("Ceiling of %s in Array:%s = %s", target, Arrays.toString(ascendingSortedCharArray), indexOfCeilingOfCharacter != -1 ? ascendingSortedCharArray[indexOfCeilingOfCharacter] : "Does not exists"));
        }
    }

    static int ceilingOrFloorOfNumber(int[] arr, int target, boolean findCeiling) {
        int indexOfStartElement = 0;
        int indexOfEndElement = arr.length - 1;
        int indexOfMidElement;
        int midElement;
        boolean isAscneding = arr[indexOfStartElement] < arr[indexOfEndElement];

        if (findCeiling && arr[indexOfEndElement] < target || !findCeiling && target < arr[indexOfStartElement])
            return -1;

        while (indexOfStartElement <= indexOfEndElement) {
            indexOfMidElement = indexOfStartElement + (indexOfEndElement - indexOfStartElement) / 2;
            midElement = arr[indexOfMidElement];

            if (target == midElement)
                return indexOfMidElement;

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
        return findCeiling ? indexOfStartElement : indexOfEndElement;
    }

    static int ceilingOrFloorfCharacter(char[] arr, char target, boolean findCeiling) {
        int indexOfStartElement = 0;
        int indexOfEndElement = arr.length - 1;
        int indexOfMidElement;
        char midElement;
        boolean isAscneding = arr[indexOfStartElement] < arr[indexOfEndElement];

        if (findCeiling && arr[indexOfEndElement] < target || !findCeiling && target < arr[indexOfStartElement])
            return -1;

        while (indexOfStartElement <= indexOfEndElement) {
            indexOfMidElement = indexOfStartElement + (indexOfEndElement - indexOfStartElement) / 2;
            midElement = arr[indexOfMidElement];

            if (target == midElement)
                return indexOfMidElement;

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
        return findCeiling ? indexOfStartElement : indexOfEndElement;
    }
}
