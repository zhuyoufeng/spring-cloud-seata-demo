package io.github.seata.demo.service.a.feign.factory;

import feign.hystrix.FallbackFactory;
import io.github.seata.demo.service.a.feign.SchoolFeignService;
import io.github.seata.demo.service.a.feign.fallback.SchoolFeignServiceFallbackImpl;

public class SchoolFeignServiceFallbackFactory implements FallbackFactory<SchoolFeignService> {

    @Override
    public SchoolFeignService create(Throwable throwable) {
        SchoolFeignServiceFallbackImpl resourcesServiceFallback = new SchoolFeignServiceFallbackImpl();
        resourcesServiceFallback.setCause(throwable);
        return resourcesServiceFallback;
    }
}
