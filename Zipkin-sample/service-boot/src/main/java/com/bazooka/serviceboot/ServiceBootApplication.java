package com.bazooka.serviceboot;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;
import java.util.logging.Level;

@SpringBootApplication
@RestController
public class ServiceBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBootApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ServiceBootApplication.class.getName());


    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome() {
        LOG.log(Level.INFO, "calling trace service-boot  ");
        return restTemplate.getForObject("http://localhost:8989/beck", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        LOG.log(Level.INFO, "calling trace service-boot ");
        return "I'm service-boot";
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
