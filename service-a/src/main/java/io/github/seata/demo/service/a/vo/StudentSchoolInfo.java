package io.github.seata.demo.service.a.vo;

import io.github.seata.demo.common.entity.School;
import io.github.seata.demo.service.a.entity.Student;

public class StudentSchoolInfo {

    private Student student;

    private School school;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
