package com.thomblweed.patterns;

import com.thomblweed.patterns.builders.exercise.CodeBuilder;
import com.thomblweed.patterns.factories.exercise.Person;
import com.thomblweed.patterns.factories.exercise.PersonFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternsApplication.class, args);

		CodeBuilder builder =
				new CodeBuilder("Person").addField("name", "String").addField("age", "int");

		System.out.println(builder);

		PersonFactory factory = new PersonFactory();
		Person jeff = factory.createPerson("Jeff");
		System.out.println(String.format("%s : %s", jeff.getId(), jeff.getName()));

		Person thom = factory.createPerson("Thom");
		System.out.println(String.format("%s : %s", thom.getId(), thom.getName()));
	}
}
