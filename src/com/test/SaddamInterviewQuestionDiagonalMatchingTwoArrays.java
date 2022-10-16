package com.test;

public class SaddamInterviewQuestionDiagonalMatchingTwoArrays {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        char[] B = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        solution1(A, B);
    }

    private static void solution1(int[] A, char[] B) {
        for (int i = 0; i < A.length - 1; i++) {
            System.out.println(A[i] + "," + B[B.length - 1 - i]);
            System.out.println(B[i] + "," + A[A.length - 1 - i]);
        }
    }
}
