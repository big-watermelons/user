package com.softusing.hejunjie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.softusing.hejunjie.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}

}
