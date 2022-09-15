package com.binarySearch;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
//        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16};

        for (int elementToSearch : Arrays.asList(-5, 0, 3, 10, 13, 19)) {
            int index = findIndexPositionUsingBinarySearch(sortedArray, elementToSearch);
            System.out.println(-1 != index ? String.format("%s exists at index:%s", elementToSearch, index) : String.format("%s does not exists in the given array", elementToSearch));
        }
    }

    static int findIndexPositionUsingBinarySearch(int[] sortedArray, int target) {
        int indexPositionOfTargetElement = -1;
        int indexPositionOfStartElement = 0;
        int indexPositionOfEndElement = sortedArray.length - 1;
        int midElement;
        int indexPositionOfMidElement;

        if (target >= sortedArray[indexPositionOfStartElement] && target <= sortedArray[indexPositionOfEndElement]) {
            while (true) {
                indexPositionOfMidElement = (indexPositionOfStartElement + indexPositionOfEndElement) / 2;
                midElement = sortedArray[indexPositionOfMidElement];
                if (indexPositionOfStartElement == indexPositionOfEndElement && target != midElement) {
                    break;
                } else if (target < midElement) {
                    indexPositionOfEndElement = indexPositionOfMidElement - 1;
                } else if (target == midElement) {
                    indexPositionOfTargetElement = indexPositionOfMidElement;
                    break;
                } else if (target > midElement) {
                    indexPositionOfStartElement = indexPositionOfMidElement + 1;
                }
            }
        }

        return indexPositionOfTargetElement;
    }
}
