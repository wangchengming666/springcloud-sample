package com.bazooka.servicefeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-client")
public interface UserClient {

    @GetMapping("/client")
    String sayHello(@RequestParam(value = "name") String name);
}
