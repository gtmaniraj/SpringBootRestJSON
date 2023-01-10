package com.fsboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.fsboot.entities.ResponseModel;

@SpringBootApplication
public class FsbootApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FsbootApplication.class, args);
	}

	@Bean
	public ResponseModel responseModel() {

		return new ResponseModel();
	}
}
