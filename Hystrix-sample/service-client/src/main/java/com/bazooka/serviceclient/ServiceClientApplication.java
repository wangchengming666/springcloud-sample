package com.bazooka.serviceclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(
				ServiceClientApplication.class, args );
	}

	@Value("${server.port}")
	String port;

	@GetMapping("/client")
	public String client(@RequestParam(value = "name", defaultValue = "bazooka") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}

	@GetMapping("/timeOut")
	public String timeOut() throws InterruptedException {
		Thread.sleep(10000L);
		return "TimeOut，I am from port:" + port;
	}

	@GetMapping("/exception")
	public String exception() throws Exception {
		if (System.currentTimeMillis() % 2 == 0) {
			throw new Exception("This is a error!");
		}
		return "Exception，I am from port:" + port;
	}

}
