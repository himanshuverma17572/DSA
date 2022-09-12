package com;

public class EvenNumberDigitElementsInArray {
    public static void main(String[] args) {
        System.out.println("Hello Himanshu");
        int[] arr = {10, 20, 100, 23, 54, 101, 1004, 103, 50, 999233, -1, 0, 00, 01, -25};
        System.out.println(findNumberOfElementsHavingEvenNumberOfDigits1(arr));
        System.out.println(findNumberOfElementsHavingEvenNumberOfDigits2(arr));
        System.out.println(findNumberOfElementsHavingEvenNumberOfDigits3(arr));
    }

    static int findNumberOfElementsHavingEvenNumberOfDigits1(int[] arr) {
        int n = 0;

        if (arr.length == 0) {
            return n;
        }

        for (int i : arr) {
            if (Integer.toString(i).length() % 2 == 0) {
                n++;
            }
        }

        return n;
    }

    static int findNumberOfElementsHavingEvenNumberOfDigits2(int[] arr) {
        int n = 0;

        if (arr.length == 0) {
            return n;
        }

        for (int i : arr) {
            int j = 1;
            int k = i / 10;
            while (k != 0) {
                j++;
                k = k / 10;
            }
            if (j % 2 == 0) {
                n++;
            }
        }

        return n;
    }

    static int findNumberOfElementsHavingEvenNumberOfDigits3(int[] arr) {
        int digits;
        int count = 0;
        for (int num : arr) {
            digits = 0;
            if (num < 0) {
                num = num * -1;
            }
            if (((int) Math.log10(num) + 1) % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
