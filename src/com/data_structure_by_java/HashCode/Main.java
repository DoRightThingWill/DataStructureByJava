package com.data_structure_by_java.HashCode;

public class Main {


    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        String d = "woody wang";
        System.out.println(d.hashCode());

        Student student = new Student(3,2,"woody", "wang");
        System.out.println(student.hashCode());
    }

}
