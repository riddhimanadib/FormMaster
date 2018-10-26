package me.riddhimanadib.fastformbuilder.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String uuid;
    private String name;

    public Student(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Student> generateSampleStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("abc","Kakama Victor"));
        students.add(new Student("cde","Favor Atuheire"));
        students.add(new Student("fgh","Ariella Atwiine"));
        students.add(new Student("ijk","Onyx Kakama"));
        return students;
    }

    @Override
    public String toString(){
        return name;
    }
}
