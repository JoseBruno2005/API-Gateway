package br.com.catolica.ppi.app_auth_ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppAuthCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppAuthCourseApplication.class, args);
	}

}
