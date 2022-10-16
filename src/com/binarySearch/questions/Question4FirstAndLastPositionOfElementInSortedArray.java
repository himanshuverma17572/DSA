package com.binarySearch.questions;

import java.util.Arrays;

public class Question4FirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] ascendingSortedIntArray = {5, 5, 5, 7, 7, 7, 7, 8, 8, 8, 10, 10, 10, 10};
        int target = 5;
//        // Finding ceiling of target
//        int indexOfCeilingOfNumber = solution1(ascendingSortedIntArray, target, true);
//        // Finding floor of target
//        int indexOfFloorOfNumber = solution1(ascendingSortedIntArray, target, false);
//        System.out.println((indexOfFloorOfNumber + 1) + " " + (indexOfCeilingOfNumber - 1));
        System.out.println(Arrays.toString(ascendingSortedIntArray));
        System.out.print(" ");
        for (int i = 0; i < ascendingSortedIntArray.length; i++) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println(Arrays.toString(solution2(ascendingSortedIntArray, target)));
        System.out.println(Arrays.toString(solution3(ascendingSortedIntArray, target)));
        System.out.println(Arrays.toString(solution4(ascendingSortedIntArray, target)));
    }

//    static int solution1(int[] arr, int target, boolean findNextLargestElement) {
//        int indexOfStartElement = 0;
//        int indexOfEndElement = arr.length - 1;
//        int indexOfMidElement;
//        int midElement;
//        boolean isAscneding = arr[indexOfStartElement] < arr[indexOfEndElement];
//
//        target = findNextLargestElement ? ++target : --target;
//
//        if (!findNextLargestElement && target < arr[indexOfStartElement])
//            return 0;
//        else if (findNextLargestElement && arr[indexOfEndElement] < target)
//            return arr.length - 1;
//
//        while (indexOfStartElement <= indexOfEndElement) {
//            indexOfMidElement = indexOfStartElement + (indexOfEndElement - indexOfStartElement) / 2;
//            midElement = arr[indexOfMidElement];
//
//            if (target == midElement)
//                return indexOfMidElement;
//
//            if (isAscneding) {
//                if (target < midElement)
//                    indexOfEndElement = indexOfMidElement - 1;
//                else if (midElement < target)
//                    indexOfStartElement = indexOfMidElement + 1;
//            } else {
//                if (target > midElement)
//                    indexOfEndElement = indexOfMidElement - 1;
//                else if (midElement > target)
//                    indexOfStartElement = indexOfMidElement + 1;
//            }
//        }
//        return findNextLargestElement ? indexOfStartElement : indexOfEndElement;
//    }

    static int[] solution2(int[] arr, int target) {
        int indexPosition = binarySearch(arr, target, 0, arr.length - 1);
        int firstIndex = indexPosition;
        int lastIndex = indexPosition;
        while (lastIndex != -1 && lastIndex < (arr.length - 1) && arr[indexPosition] == arr[lastIndex + 1]) {
            lastIndex++;
        }
        while (firstIndex > 0 && arr[indexPosition] == arr[firstIndex - 1]) {
            firstIndex--;
        }
        return new int[]{firstIndex, lastIndex};
    }

    static int[] solution3(int[] arr, int target) {
        int indexPosition = binarySearch(arr, target, 0, arr.length - 1);
        int firstIndex = indexPosition;
        int lastIndex = indexPosition;
        while (true) {
            if (firstIndex == 0)
                break;
            int index = binarySearch(arr, target, 0, firstIndex - 1);
            if (index != -1)
                firstIndex = index;
            else
                break;
        }
        while (true) {
            if (lastIndex == arr.length - 1)
                break;
            int index = binarySearch(arr, target, lastIndex + 1, arr.length - 1);
            if (index != -1)
                lastIndex = index;
            else
                break;
        }
        return new int[]{firstIndex, lastIndex};
    }

    static int[] solution4(int[] arr, int target) {
        int start = binarySearchModified(arr, target, true);
        int end = binarySearchModified(arr, target, false);
        return new int[]{start, end};
    }

    static int binarySearch(int[] arr, int target, int indexOfStartElement, int indexOfEndElement) {
        int indexOfMidElement;
        int midElement;

        while (indexOfStartElement <= indexOfEndElement) {
            indexOfMidElement = indexOfStartElement + (indexOfEndElement - indexOfStartElement) / 2;
            midElement = arr[indexOfMidElement];
            if (target < midElement)
                indexOfEndElement = indexOfMidElement - 1;
            else if (midElement < target)
                indexOfStartElement = indexOfMidElement + 1;
            else if (target == midElement)
                return indexOfMidElement;
        }
        return -1;
    }

    static int binarySearchModified(int[] arr, int target, boolean findFirstElemtnet) {
        int indexOfTarget = -1;
        int indexOfStartElement = 0;
        int indexOfEndElement = arr.length - 1;
        int indexOfMidElement;
        int midElement;

        while (indexOfStartElement <= indexOfEndElement) {
            indexOfMidElement = indexOfStartElement + (indexOfEndElement - indexOfStartElement) / 2;
            midElement = arr[indexOfMidElement];
            if (target < midElement)
                indexOfEndElement = indexOfMidElement - 1;
            else if (midElement < target)
                indexOfStartElement = indexOfMidElement + 1;
            else {
                indexOfTarget = indexOfMidElement;
                if (findFirstElemtnet)
                    indexOfEndElement = indexOfMidElement - 1;
                else
                    indexOfStartElement = indexOfMidElement + 1;
            }
        }
        return indexOfTarget;
    }
}
