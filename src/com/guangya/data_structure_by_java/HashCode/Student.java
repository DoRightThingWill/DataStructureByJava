package com.guangya.data_structure_by_java.HashCode;

import java.util.Locale;

public class Student {
    int grade;
    int cls;
    String fname;
    String lname;

    public Student(int grade, int cls, String fname, String lname) {
        this.grade = grade;
        this.cls = cls;
        this.fname = fname;
        this.lname = lname;
    }

    @Override
    public int hashCode(){
        int B = 31;
        int hash = 0;
        hash = hash * B + grade;
        hash = hash * B + cls;
        hash = hash * B + fname.toLowerCase().hashCode();
        hash = hash * B + lname.toLowerCase().hashCode();

        return hash;
    }
}
