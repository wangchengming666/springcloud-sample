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
	public String home(@RequestParam(value = "name", defaultValue = "bazooka") String name) {
		return "hi " + name + " ,i am from port:" + port;
	}

}
