package com.projeto.sorveteria;

import com.projeto.sorveteria.util.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SorveteriaApplication {

	public static void main(String[] args) {
		System.out.println(StringUtils.encrypt("123"));
		SpringApplication.run(SorveteriaApplication.class, args);
	}

}
