package com.binarySearch;

import sun.security.util.ArrayUtil;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
//        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] ascendingSortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16};

        for (int elementToSearch : Arrays.asList(-5, 0, 3, 10, 13, 19)) {
            int index = findIndexPositionUsingBinarySearch(ascendingSortedArray, elementToSearch);
            System.out.println(-1 != index ? String.format("%s exists at index:%s", elementToSearch, index) : String.format("%s does not exists in the given array", elementToSearch));
        }
        System.out.println("=================================================================================");
        for (int elementToSearch : Arrays.asList(-5, 0, 3, 10, 13, 19)) {
            int index = findIndexPositionUsingBinarySearch2(ascendingSortedArray, elementToSearch);
            System.out.println(-1 != index ? String.format("%s exists at index:%s", elementToSearch, index) : String.format("%s does not exists in the given array", elementToSearch));
        }
        System.out.println("=================================================================================");
        for (int elementToSearch : Arrays.asList(-5, 0, 3, 10, 13, 19)) {
            // Passing Ascending Sorted array
            int index = orderAgnosticBinarySearch(ascendingSortedArray, elementToSearch);
            System.out.println(-1 != index ? String.format("%s exists at index:%s", elementToSearch, index) : String.format("%s does not exists in the given array", elementToSearch));
            int[] descendingSortedArray = {16, 15, 14, 13, 12, 11, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
            // Passing Descending Sorted array
            index = orderAgnosticBinarySearch(descendingSortedArray, elementToSearch);
            System.out.println(-1 != index ? String.format("%s exists at index:%s", elementToSearch, index) : String.format("%s does not exists in the given array", elementToSearch));
        }
    }

    static int findIndexPositionUsingBinarySearch(int[] sortedArray, int target) {
        int indexPositionOfTargetElement = -1;
        int indexPositionOfStartElement = 0;
        int indexPositionOfEndElement = sortedArray.length - 1;
        int midElement;
        int indexPositionOfMidElement;

        while (indexPositionOfStartElement <= indexPositionOfEndElement) {
            indexPositionOfMidElement = (indexPositionOfStartElement + indexPositionOfEndElement) / 2;
            midElement = sortedArray[indexPositionOfMidElement];
            if (target < midElement) {
                indexPositionOfEndElement = indexPositionOfMidElement - 1;
            } else if (target == midElement) {
                indexPositionOfTargetElement = indexPositionOfMidElement;
                break;
            } else if (target > midElement) {
                indexPositionOfStartElement = indexPositionOfMidElement + 1;
            }
        }

        return indexPositionOfTargetElement;
    }

    static int findIndexPositionUsingBinarySearch2(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAscending = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid])
                return mid;
            if (isAscending) {
                if (target < arr[mid])
                    end = mid - 1;
                else if (arr[mid] < target)
                    start = mid + 1;
            } else {
                if (target > arr[mid])
                    end = mid - 1;
                else if (arr[mid] > target)
                    start = mid + 1;
            }
        }
        return -1;
    }

}
