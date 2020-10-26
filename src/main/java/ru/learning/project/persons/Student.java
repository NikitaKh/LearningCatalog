package ru.learning.project.persons;

import ru.learning.project.study.Program;

public class Student extends Person {

    private Program studentsProgram;

    public Student(String name, String surName, int age) {
        super(name, surName, age);
    }

    public Program getStudentsProgram() {
        return studentsProgram;
    }

    public void setStudentsProgram(Program studentsProgram) {
        this.studentsProgram = studentsProgram;
    }
}
