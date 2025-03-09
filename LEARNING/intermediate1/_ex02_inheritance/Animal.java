package intermediate1._ex02_inheritance;

/**
 * 4.6 Ex: Superclass Animal and its subclasses
 * 
 * https://www3.ntu.edu.sg/home/ehchua/programming/java/J3f_OOPExercises.html#zz-4.6
 */
public class Animal {

	private String name;

	public Animal(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Animal[name=" + this.name + "]";
	}
}
