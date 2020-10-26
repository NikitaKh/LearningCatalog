package ru.learning.project.reports;

import ru.learning.project.persons.Student;
import ru.learning.project.study.Program;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShortReport implements Report {

    SimpleDateFormat format = new SimpleDateFormat("dd.MMMM.yyyy HH:mm");

    @Override
    public void printReport(Student student) {
        format.setLenient(false);
        Program program = student.getStudentsProgram();
        Date programStartDate = program.getProgramStartDate();
        Date programEndDate = program.getProgramEndDate();
        StringBuilder shortInfo = new StringBuilder();
        shortInfo.append("STUDENT: ").append(student.getName()).append(" ").append(student.getSurName()).append("\n");
        shortInfo.append("STUDENT'S PROGRAM: ").append(program.getProgramName()).append("\n");
        if (program.getProgramStartDate() != null) {
            shortInfo.append("START DATE: ").append(format.format(programStartDate)).append("\n");
            shortInfo.append("PROGRAM LENGTH: ").append(program.countProgramLength()).append(" hours\n");
            shortInfo.append("STATUS: ").append(program.showProgramProgress(programStartDate, programEndDate)).append("\n");
        } else {
            shortInfo.append("ОБУЧЕНИЕ НЕ НАЗНАЧЕНО!\n");
        }
        System.out.println(shortInfo.toString());
    }
}
