package com.today;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TodayMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodayMenuApplication.class, args);
	}

}
