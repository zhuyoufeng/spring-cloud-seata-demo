package io.github.seata.demo.service.a.service;

import io.github.seata.demo.service.a.vo.StudentSchoolInfo;

public interface StudentService {

    /**
     * create student info and school info
     *
     * @param studentSchoolInfo
     */
    void createStudentSchoolInfo(StudentSchoolInfo studentSchoolInfo);

}
