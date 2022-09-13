package com.linearSearch;

public class RichestCustomer {
    public static void main(String[] args) {
        int[][] allCustomersAccounts = {{5, 2, 3}, {4, 6, 2}, {12, 3, 5}};
        System.out.println(calculateRichestCustomer(allCustomersAccounts));
    }

    static int calculateRichestCustomer(int[][] allCustomersAccounts) {
        int wealthOfRicherstCustomer = Integer.MIN_VALUE;
        for (int[] customerAccounts : allCustomersAccounts) {
            int totalWealthOfACustomer = 0;
            for (int amountInEachBank : customerAccounts) {
                totalWealthOfACustomer += amountInEachBank;
            }
            if (totalWealthOfACustomer > wealthOfRicherstCustomer) {
                wealthOfRicherstCustomer = totalWealthOfACustomer;
            }
        }
        return wealthOfRicherstCustomer;
    }

}
