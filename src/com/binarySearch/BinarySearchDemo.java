package com.binarySearch;

public class BinarySearchDemo {

    public static void main(String[] args) {
//        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16};
        System.out.println(findIndexPositionUsingBinarySearch(sortedArray, -5));
        System.out.println(findIndexPositionUsingBinarySearch(sortedArray, 0));
        System.out.println(findIndexPositionUsingBinarySearch(sortedArray, 3));
        System.out.println(findIndexPositionUsingBinarySearch(sortedArray, 10));
        System.out.println(findIndexPositionUsingBinarySearch(sortedArray, 13));
        System.out.println(findIndexPositionUsingBinarySearch(sortedArray, 19));
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
                if (target < midElement) {
                    indexPositionOfEndElement = indexPositionOfMidElement - 1;
                } else if (target == midElement) {
                    indexPositionOfTargetElement = indexPositionOfMidElement;
                    break;
                } else if (target > midElement) {
                    indexPositionOfStartElement = indexPositionOfMidElement + 1;
                } else if (indexPositionOfStartElement == indexPositionOfEndElement) {
                    break;
                }
            }
        }

        return indexPositionOfTargetElement;
    }
}
