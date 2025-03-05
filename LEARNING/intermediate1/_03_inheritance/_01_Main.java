package intermediate1._03_inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _01_Main {

	public static void main(String[] args) {
		// Animal test
		// we cant create instances bc Animal is abstract
//		Animal genericAnimal = new Animal("Generic Animal", 5, 20.0, true);
//		System.out.println("Animal: " + genericAnimal);
//		genericAnimal.eat();
//		genericAnimal.sleep();

		// eagle test
		String[] prey = { "fish", "small mammals", "birds" };
		Eagle eagle = new Eagle("Golden Eagle", 3, 6.5, true, 2.3, true, prey, Habitat.COASTAL);
		System.out.println("\nEagle: " + eagle);
		eagle.fly();
		eagle.hunt();

		eagle.makeSound();

		// vararg method test
		// Add single prey
		eagle.addPrey("rabbit");
		System.out.println("Updated prey: " + Arrays.toString(eagle.getPrey()));

		// Add multiple prey
		eagle.addPrey("snake", "lizard", "fox");
		System.out.println("Updated prey: " + Arrays.toString(eagle.getPrey()));

		// testing eagles equals method
		Eagle anotherEagle = new Eagle("Golden Eagle", 3, 6.5, true, 2.3, true, prey, Habitat.DESERT);
		System.out.println("Eagle equals anotherEagle? " + eagle.equals(anotherEagle));

		// testing final animal
		FinalAnimal finalAnimal = new FinalAnimal("Panda", 10, 100.0, false, "Forest", true);
		System.out.println("\nFinalAnimal: " + finalAnimal);

		finalAnimal.setHabitat("Bamboo Forest");
		finalAnimal.setEndangered(false);
		System.out.println("Updated FinalAnimal: " + finalAnimal);

		// Testing references to a superclass
		List<ZFigure> figuras = new ArrayList<>();
		figuras.add(new ZTriangle("Rojo", 3, 5));
		figuras.add(new ZRectangle("Azul", 4, 6));

		for (ZFigure figura : figuras) {
			System.out.println("\n" + figura.getClass().toString() + " area: " + figura.area());
		}

		// Polimorfism
		System.out.println();
		ZFigure zfigure;
		zfigure = new ZTriangle("Red", 2, 3);
		System.out.println(zfigure.area()); // area method of triangle
		zfigure = new ZRectangle("Blue", 4, 4);
		System.out.println(zfigure.area()); // area method of rectangle

		// .instanceof example
		ZFigure[] figures = { new ZTriangle("Red", 10, 5), new ZRectangle("Blue", 4, 6) };

		for (ZFigure figure : figures) {
			if (figure instanceof ZTriangle) {
				ZTriangle triangle = (ZTriangle) figure; // Downcast a ZTriangle
				System.out.println("Triangle with base " + triangle.getBase() + " and height " + triangle.getAltura()
						+ " has area: " + triangle.area());
			} else if (figure instanceof ZRectangle) {
				ZRectangle rectangle = (ZRectangle) figure; // Downcast a ZRectangle
				System.out.println("Rectangle with width " + rectangle.getAncho() + " and height " + rectangle.getAlto()
						+ " has area: " + rectangle.area());
			} else {
				System.out.println("Unknown figure");
			}
		}

		// object type variables (not too useful)
		Object obj = new Eagle();
		
		
	}
}
