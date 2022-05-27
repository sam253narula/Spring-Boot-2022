package com.example.springcloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringBootCloudConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudConfigserverApplication.class, args);
	}

}
