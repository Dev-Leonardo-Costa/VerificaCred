package br.com.leonardocosta.msavalidadorcredito;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableRabbit
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MsavalidadorcreditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsavalidadorcreditoApplication.class, args);
	}

}
