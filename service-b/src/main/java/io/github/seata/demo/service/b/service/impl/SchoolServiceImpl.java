package io.github.seata.demo.service.b.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.github.seata.demo.common.entity.School;
import io.github.seata.demo.common.exception.BusinessException;
import io.github.seata.demo.service.b.mapper.SchoolMapper;
import io.github.seata.demo.service.b.service.SchoolService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;


@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements SchoolService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createSchoolInfo(School school) {
        List<School> studentList = baseMapper.selectByMap(new HashMap<String, Object>() {{
            put("name", school.getName());
        }});
        if (!CollectionUtils.isEmpty(studentList)) {
            throw new BusinessException("the school already exits");
        }
        baseMapper.insert(school);
    }

}
