package ru.learning.project.reports;

import ru.learning.project.persons.Student;
import ru.learning.project.study.Program;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FullReport implements Report {

    SimpleDateFormat format = new SimpleDateFormat("dd.MMMM.yyyy HH:mm:ss");

    @Override
    public void printReport(Student student) {
        format.setLenient(false);
        Program program = student.getStudentsProgram();
        Date programStartDate = program.getProgramStartDate();
        Date programEndDate = program.getProgramEndDate();
        StringBuilder fullInfo = new StringBuilder();
        fullInfo.append("STUDENT: ").append(student.getName()).append(" ").append(student.getSurName()).append(" AGE: ").append(student.getAge()).append("\n");
        fullInfo.append("STUDENT'S PROGRAM: ").append(program.getProgramName()).append("\n");
        fullInfo.append("START DATE: ").append(format.format(programStartDate)).append("\n");
        fullInfo.append("PROGRAM LENGTH: ").append(program.countProgramLength()).append(" hours\n");
        fullInfo.append("STATUS: ").append(program.showProgramProgress(programStartDate, programEndDate)).append("\n");
        if (program.getCourses() != null) {
            fullInfo.append("COURSES:\n").append(program.showProgramCourses()).append("\n");
        } else {
            fullInfo.append("ОБУЧЕНИЕ НЕ НАЗНАЧЕНО!\n");
        }
        System.out.println(fullInfo.toString());
    }
}
