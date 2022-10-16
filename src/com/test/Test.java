package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> l = Arrays.asList("himanshu", "ravi");
        l = l.stream().map(name -> {
            if (name.equalsIgnoreCase("himanshu"))
                name = name.concat(" verma");
            else if (name.equalsIgnoreCase("ravi")) {
                name = name.concat(" shanker");
            }
            return name;
        }).collect(Collectors.toList());

        l.stream().map(name -> name.length()).collect(Collectors.toList());

//        l = l.stream().filter(name -> name.contains("verma")).collect(Collectors.toList());

        System.out.println("l = " + l);

        l.stream().forEach(System.out::println);

        System.out.println("=============================================");

        l.stream().forEach(Test::m1);
        l.stream().forEach(new Test()::m2);

        l.stream().map((name) -> {
            return name.toUpperCase();
        }).collect(Collectors.toList());
        l.stream().map(Test::m3).collect(Collectors.toList());
        l.stream().map(new Test()::m4).collect(Collectors.toList());

        List<Student> studentList = Arrays.asList(new Student("Himanshu", "KIET"), new Student("Ravi", "MIET"));

        studentList.stream().map(Student::getName).collect(Collectors.toList());

        List<Test> testList = Arrays.asList(new Test());
        testList.stream().map(Test::m5).collect(Collectors.toList());
    }

    public static void m1(String s) {
        System.out.println(s);
    }

    public void m2(String s) {
        System.out.println(s);
    }

    public static String m3(String s) {
        return "";
    }

    public String m4(String s) {
        return "";
    }

    public String m5() {
        return "";
    }
    public void m6(){

    }
}
