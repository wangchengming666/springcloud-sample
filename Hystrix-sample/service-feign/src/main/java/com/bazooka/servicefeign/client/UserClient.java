package com.bazooka.servicefeign.client;

import com.bazooka.servicefeign.fallback.UserClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-client", fallback = UserClientHystrix.class)
public interface UserClient {

    @GetMapping("/client")
    String sayHello(@RequestParam(value = "name") String name);
}
