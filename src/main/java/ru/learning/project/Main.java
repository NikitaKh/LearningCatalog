package ru.learning.project;

import ru.learning.project.persons.Student;
import ru.learning.project.reports.FullReport;
import ru.learning.project.reports.Report;
import ru.learning.project.reports.ShortReport;
import ru.learning.project.study.Course;
import ru.learning.project.study.Program;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        Student nikita = new Student("Nikita", "Khvalin", 25);
        Course java = new Course("Java", 20);
        Course loadTest = new Course("JMeter", 20);
        Program program = new Program("08/11/2020 08:30", "QA LoadTest");
        Course[] courses = new Course[]{java, loadTest};
        program.addCoursesToProgram(courses);
        nikita.setStudentsProgram(program);
        program.calculateProgramEndDate();
        System.out.println("-------------------Short Report-------------------");
        Report shortReport = new ShortReport();
        shortReport.printReport(nikita);
        System.out.println("--------------------Long Report-------------------");
        Report fullReport = new FullReport();
        fullReport.printReport(nikita);
    }
}
