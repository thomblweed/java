package com.thomblweed.patterns;

import com.thomblweed.patterns.builders.exercise.CodeBuilder;
import com.thomblweed.patterns.factories.exercise.Person;
import com.thomblweed.patterns.factories.exercise.PersonFactory;
import com.thomblweed.patterns.prototype.exercise.Line;
import com.thomblweed.patterns.prototype.exercise.Point;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternsApplication.class, args);

		// builder
		System.out.println("");
		CodeBuilder builder =
				new CodeBuilder("Person").addField("name", "String").addField("age", "int");

		System.out.println(builder);
		System.out.println("");

		// factory
		PersonFactory factory = new PersonFactory();
		Person jeff = factory.createPerson("Jeff");
		System.out.println(String.format("%s : %s", jeff.getId(), jeff.getName()));

		Person thom = factory.createPerson("Thom");
		System.out.println(String.format("%s : %s", thom.getId(), thom.getName()));
		System.out.println("");

		// prototype
		Line line = new Line(new Point(1, 2), new Point(3, 4));
		System.out.println("line : " + line);
		Line lineCopy = line.deepCopy();
		System.out.println("lineCopy : " + lineCopy);
		lineCopy.end = new Point(5, 6);
		System.out.println("lineCopy edited : " + lineCopy);
		System.out.println("");
	}
}
