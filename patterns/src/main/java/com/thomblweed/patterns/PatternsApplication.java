package com.thomblweed.patterns;

import com.thomblweed.patterns.builders.exercise.CodeBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternsApplication.class, args);

		CodeBuilder builder =
				new CodeBuilder("Person").addField("name", "String").addField("age", "int");

		System.out.println(builder);
	}
}
