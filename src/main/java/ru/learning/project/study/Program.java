package ru.learning.project.study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    private final Date programStartDate;
    private Date programEndDate;
    private final String programName;
    private final List<Course> courses = new ArrayList<Course>();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public Program(String programStartDate, String programName) throws ParseException {
        format.setLenient(false);
        this.programStartDate = format.parse(programStartDate);
        this.programName = programName;
    }

    public Date getProgramStartDate() {
        return programStartDate;
    }

    public String getProgramName() {
        return programName;
    }

    public Date getProgramEndDate() {
        return programEndDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCoursesToProgram(Course[] currentCourses) {
        Collections.addAll(courses, currentCourses);
    }

    public int countProgramLength() {
        int programDurationHours = 0;
        for (Course course : courses) {
            programDurationHours += course.getCourseDuration();
        }
        return programDurationHours;
    }

    public void calculateProgramEndDate() {
        Calendar calendar = Calendar.getInstance();
        int programDurationHours = countProgramLength();
        calendar.setTime(this.programStartDate);
        calendar.add(Calendar.DAY_OF_MONTH, programDurationHours / 8);
        calendar.add(Calendar.HOUR_OF_DAY, programDurationHours % 8);
        programEndDate = calendar.getTime();
    }

    public String showProgramProgress(Date start, Date end) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        if (currentDate.before(start)) {
            return "Программа еще не началась!(Program has not been started!)\n";
        } else if (currentDate.after(end)) {
            return "Программа уже закончилась!(Program has been finished already!)\n";
        } else {
            return "Программа в процессе выполнения!(Program is in progress!)";
        }
    }

    public String showProgramCourses() {
        StringBuilder coursesLine = new StringBuilder();
        for (Course course : courses) {
            coursesLine.append("COURSE: ").append(course.getCourseName())
                    .append(" DURATION: ").append(course.getCourseDuration()).append(" hours;\n");
        }
        return coursesLine.toString();
    }

}
