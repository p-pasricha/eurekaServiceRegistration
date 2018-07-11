package com.hcl.serviceDiscovery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaServiceDiscoveryControllerB {
    @Autowired
    protected RestTemplate restTemplate;
    
    @ResponseBody
    @RequestMapping("/service-discovery/{applicationName}")
    public String testServiceDiscovery(@PathVariable String applicationName) {
        String response = restTemplate.getForObject("http://" + applicationName + "/hello", String.class);
    	System.out.println("Response from Service Call: " + response);
        return "<html>Response in eurekaServiceDiscoveryB: " + response + "</html>";
    }
    
    // A REST method, To call from another service.
    // See in Lesson "Load Balancing with Ribbon".
    @ResponseBody
    @RequestMapping(value = "/service-discovery/hello", method = RequestMethod.GET)
    public String hello() {
 
        return "<html>Hello from eurekaServiceDiscoveryB</html>";
    }
    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
