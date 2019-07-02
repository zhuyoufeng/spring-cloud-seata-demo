package io.github.seata.demo.service.a.controller;


import io.github.seata.demo.service.a.service.StudentService;
import io.github.seata.demo.service.a.vo.StudentSchoolInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student-school")
    public String createStudentSchoolInfo(@RequestBody StudentSchoolInfo studentSchoolInfo) {
        studentService.createStudentSchoolInfo(studentSchoolInfo);
        return "SUCCESS";
    }

}
