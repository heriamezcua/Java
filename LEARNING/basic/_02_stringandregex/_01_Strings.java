package basic._02_stringandregex;

public class _01_Strings {

	public static void main(String[] args) {
		// STRINGS is not a primitive data type

		// Instantiation
		String myStr = new String("Hi this is a string");
		String myRealStr = "Hi this is a string";

		// substring
		String mySubstring = myStr.substring(0, 2);

		System.out.println(mySubstring); // Hi

		// Concatenation
		String concat = "HI" + "MY NAME" + "IS HERI";

		// String inefficiency
		// strings are inmutables so every time we made a change a new string object is
		// made for that reason sometimes (when in our program there are so much string
		// manipulation we must use StringBuilder class

		// STRINGBUILDER
		StringBuilder myStrBuild = new StringBuilder("hi again");

		// subs
		myStrBuild.substring(0, 3);

		// concatenation
		myStrBuild.append("hola");

		// CHECK IF 2 STRINGS OR MORE ARE EQUALS

		// We have this problem, we cannot use == to check if two strings are equals
		System.out.println("hello" == "hello"); // true

		String s = new String("hello");
		System.out.println(s == "hello"); // false

		// we must use .equals()
		System.out.println("hello".equals(s)); // true
		System.out.println("hello".equalsIgnoreCase(s)); // true

		// Empty and null strings
		// Sometimes, you need to test that a string is neither null nor empty. Then use
		if (s != null && s.length() == 0) {

		}

		// String Methods
		// there are like 60 string methods in the class String.
		// They are divided in:
		// --- Inspection methods: .length() .isEmpty() etc
		// --- Comparison methods: .equals() .equalsIgnorecase() etc
		// --- Manipulation methods: .substring() .append() etc

		// TEXT BLOCKS

		System.out.println("""

				This is a text block

				""");

		// useful to add code in string format

		String html = """
				<div class="warning">
					Beware of those who say "Hello" to the world
				 </div>
				""";

		// TIPS TO PRINT IN THE CONSOLE
		int age = 22;
		int yearOfBirth = 2002;

		System.out.printf("Age = %d, Birth year = %d\n", age, yearOfBirth);

		// MOST COMMON
		// %d integers

		// %s strings

		// %.2f doubles with two decimals

		// FLAGS
		// flags are a way to control the formatted output
		System.out.printf("%,.2f", 10000.0 / 3.0); // prints 3.333,33 instead of 3333,33

		// String format
		// with this we can obtain a formatted string without print (java 15)
		String message = "Hello, %s. Next year, you'll be %d".formatted("Heri", age + 1);

	}

}
