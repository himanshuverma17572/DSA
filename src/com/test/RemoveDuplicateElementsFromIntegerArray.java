package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicateElementsFromIntegerArray {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 4, 2, 3, 1, 7, 4, 8, 4, 9, 10);
        System.out.println(solution1(integers));
    }

    static List<Integer> solution1(List<Integer> integers) {
        ArrayList<Integer> answer = new ArrayList<>();
        outerForLoop:
        for (int i = 0; i < integers.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (integers.get(i) == integers.get(j))
                    continue outerForLoop;
            }
            answer.add(integers.get(i));
        }
        return answer;
    }
}
