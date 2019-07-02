package io.github.seata.demo.service.a.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.github.seata.demo.common.exception.BusinessException;
import io.github.seata.demo.service.a.entity.Student;
import io.github.seata.demo.service.a.feign.SchoolFeignService;
import io.github.seata.demo.service.a.mapper.StudentMapper;
import io.github.seata.demo.service.a.service.StudentService;
import io.github.seata.demo.service.a.vo.StudentSchoolInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;


@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    private final SchoolFeignService schoolFeignService;

    public StudentServiceImpl(SchoolFeignService schoolFeignService) {
        this.schoolFeignService = schoolFeignService;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createStudentSchoolInfo(StudentSchoolInfo studentSchoolInfo) {
        List<Student> studentList = baseMapper.selectByMap(new HashMap<String, Object>() {{
            put("name", studentSchoolInfo.getStudent().getName());
        }});
        if (!CollectionUtils.isEmpty(studentList)) {
            throw new BusinessException("the student already exits");
        }
        baseMapper.insert(studentSchoolInfo.getStudent());

        schoolFeignService.createSchoolInfo(studentSchoolInfo.getSchool());
    }

}
