package com.thomblweed.patterns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import com.thomblweed.patterns.adapters.exercise.SquareToRectangleAdapter;
import com.thomblweed.patterns.bridge.exercise.RasterRenderer;
import com.thomblweed.patterns.bridge.exercise.Shape;
import com.thomblweed.patterns.bridge.exercise.Square;
import com.thomblweed.patterns.bridge.exercise.Triangle;
import com.thomblweed.patterns.bridge.exercise.VectorRenderer;
import com.thomblweed.patterns.builders.exercise.CodeBuilder;
import com.thomblweed.patterns.composite.exercise.ManyValues;
import com.thomblweed.patterns.composite.exercise.MyList;
import com.thomblweed.patterns.composite.exercise.SingleValue;
import com.thomblweed.patterns.composite.exercise.ValueContainer;
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

		// adapter
		com.thomblweed.patterns.adapters.exercise.Square square =
				new com.thomblweed.patterns.adapters.exercise.Square(5);
		SquareToRectangleAdapter adapter = new SquareToRectangleAdapter(square);
		System.out.println(adapter.getArea());
		System.out.println("");

		// bridge
		String rasterTriangle = new Triangle(new RasterRenderer()).toString();
		System.out.println(rasterTriangle);
		String vectorTriangle = new Triangle(new VectorRenderer()).toString();
		System.out.println(vectorTriangle);
		String rasterSquare = new Square(new RasterRenderer()).toString();
		System.out.println(rasterSquare);
		String vectorSqaure = new Square(new VectorRenderer()).toString();
		System.out.println(vectorSqaure);
		System.out.println("");

		// composite
		Collection<ValueContainer> stuff = new ArrayList<>();
		stuff.add(new SingleValue(5));
		stuff.add(new SingleValue(5));
		MyList myList = new MyList(stuff);
		ManyValues manyValues = new ManyValues();
		manyValues.add(25);
		myList.add(manyValues);

		System.out.println("sum :>> " + myList.sum());
	}
}
