package io.github.seata.demo.service.a.feign;


import io.github.seata.demo.common.entity.School;
import io.github.seata.demo.service.a.feign.factory.SchoolFeignServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "service-b", fallbackFactory = SchoolFeignServiceFallbackFactory.class)
public interface SchoolFeignService {

    @PostMapping("/school")
    String createSchoolInfo(@RequestBody School school);

}
