package com.hcl.serviceDiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaServiceDiscoveryApplicationB {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceDiscoveryApplicationB.class, args);
	}
}
