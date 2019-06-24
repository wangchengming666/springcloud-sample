package com.bazooka.servicefeign.web;

import com.bazooka.servicefeign.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Beck Wang on 2019-06-20
 */
@RestController
public class HelloController {

    @Autowired
    UserClient userClient;

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        return userClient.sayHello(name);
    }

    @GetMapping("/timeOut")
    public String timeOut() throws InterruptedException {
        return userClient.timeOut();
    }

    @GetMapping("/exception")
    public String exception() throws Exception {
        return userClient.exception();
    }
}
