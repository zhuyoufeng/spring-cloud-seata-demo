package io.github.seata.demo.service.a.feign.fallback;

import io.github.seata.demo.common.entity.School;
import io.github.seata.demo.service.a.feign.SchoolFeignService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SchoolFeignServiceFallbackImpl implements SchoolFeignService {

    @Setter
    private Throwable cause;

    @Override
    public String createSchoolInfo(School school) {
        log.error("feign 插入日志失败", cause);
        return null;
    }

}
