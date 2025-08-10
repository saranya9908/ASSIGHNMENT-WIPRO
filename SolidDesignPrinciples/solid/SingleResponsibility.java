package com.basic.solid;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getDetails() {
      return "Name: " + name + ", Age: " + age;
    	
    }
}

class StudentPrinter {
    public void print(Student student) {
        System.out.println(student.getDetails());
    }
}

public class SingleResponsibility {
    public static void main(String[] args) {
        Student student = new Student("Saranya", 20);
        StudentPrinter printer = new StudentPrinter();
        printer.print(student);
    }
}