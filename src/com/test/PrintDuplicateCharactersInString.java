package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintDuplicateCharactersInString {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        String s = "";
        try {
            FileInputStream fis = new FileInputStream("src/com/test/PrintDuplicateCharactersInString.txt");
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            ArrayList<Character> characters = new ArrayList<>();
            for (byte b : bytes) {
                characters.add((char) b);
            }
            characters.stream().forEach(character -> stringBuilder.append(character));
            s = stringBuilder.toString();
//            System.out.println("s = " + s);
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        printDuplicateCharacters(s);
        solutionWithReducedTimeComplexity(s);
    }

    private static void printDuplicateCharacters(String s) {
        long startTime = System.currentTimeMillis();
        ArrayList<Character> duplicateCharacters = new ArrayList<>();
        while (!s.isEmpty()) {
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(0) == s.charAt(j))
                    count++;
            }
            if (count > 1)
                duplicateCharacters.add(s.charAt(0));
            System.out.printf("%s occurred %s times%n", s.charAt(0), count);
            s = s.replaceAll(Character.toString(s.charAt(0)), "");
        }
        System.out.printf("duplicateCharacters = %s%n", duplicateCharacters);
        long endTime = System.currentTimeMillis();
        System.out.println("============================================================================================================================================");
        System.out.println("************************************        totalTime by O(n^2) = " + (endTime - startTime) + "        ************************************");
        System.out.println("============================================================================================================================================");
    }

    private static void solutionWithReducedTimeComplexity(String s) {
        long startTime = System.currentTimeMillis();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            hashMap.compute(s.charAt(index), (character, count) -> count == null ? 1 : ++count);
        }
        System.out.println("hashMap = " + hashMap);
        List<Map.Entry<Character, Integer>> duplicateCharactersList = hashMap.entrySet().stream().filter(characterIntegerEntry -> characterIntegerEntry.getValue() > 1).collect(Collectors.toList());
        System.out.println("duplicateCharactersList = " + duplicateCharactersList);
        long endTime = System.currentTimeMillis();
        System.out.println("============================================================================================================================================");
        System.out.println("************************************        totalTime by O(n) = " + (endTime - startTime) + "        ************************************");
        System.out.println("============================================================================================================================================");
    }
}
