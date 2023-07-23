package com.example.ipl.dashboard.controller;



import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/sample-api")
    @Retry(name="Retry_for_sample-api_Microservice", fallbackMethod = "hardcodedResponse")
    public String sampleApi(){
        logger.info("sample here has been called");
        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity
                ("http://localhost:8081/tempMicroservice",
                        String.class);
        return "sample";
    }

    public String hardcodedResponse(Exception e){
        return "oh boy";
    }
}
