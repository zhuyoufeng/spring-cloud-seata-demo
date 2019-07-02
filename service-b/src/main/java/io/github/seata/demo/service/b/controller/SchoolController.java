package io.github.seata.demo.service.b.controller;


import io.github.seata.demo.common.entity.School;
import io.github.seata.demo.service.b.service.SchoolService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/school")
    public String createSchoolInfo(@RequestBody School school) {
        schoolService.createSchoolInfo(school);
        return "SUCCESS";
    }

}
