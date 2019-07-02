package io.github.seata.demo.service.a.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.github.seata.demo.service.a.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {



}
