package com.test;

public class RemoveDuplicateCharactersFromString {
    public static void main(String[] args) {
        String s = "rrraavirrraaaaavvvvv";// ravi
        System.out.println(solution1(s));
        System.out.println(solution2(s));
    }

    static String solution1(String s) {
        StringBuffer stringBuffer = new StringBuffer(s);
        for (int i = 0; i < stringBuffer.length(); i++) {
            for (int j = i + 1; j < stringBuffer.length(); j++) {
                if (stringBuffer.charAt(i) == stringBuffer.charAt(j)) {
                    stringBuffer.deleteCharAt(j);
                    --j;
                }
            }
        }
        return stringBuffer.toString();
    }

    static String solution2(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        outerForLoop:
        for (int i = 0; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j))
                    continue outerForLoop;
            }
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }
}
