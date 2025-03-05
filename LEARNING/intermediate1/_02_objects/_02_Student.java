package intermediate1._02_objects;

public class _02_Student {

	// attributes / fields / properties
	private String name;
	private int age;
	private int[] grades;
	private double avgGrade;

	// final attributes
	private final String surname;

	// static attributes
	private static int studentCount = 0;

	// final static attributes
	public static String school = "SCHOOL_NAME";

	// Static block (initializes when the class load)
	static {
		System.out.println("Welcome to the Student Management System!");
	}

	// initialization block (The code in the initialization block is executed before
	// the constructor code)
	{
		studentCount++;
	}

	// constructors
	public _02_Student(String name, String surname, int age) {
		this.name = name;
		this.age = age;
		this.grades = new int[5];
		this.surname = surname;
	}

	public _02_Student(String name) {
		this(name, "apellido", 18);
	}

	// getter and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// Other methods
	public double calcAvgGrade() {
		double avg = 0;
		for (int grade : grades) {
			avg += grade / grades.length;
		}

		return avg;
	}

}
