package intermediate1._ex02_inheritance;

public class Mammal extends Animal {

	public Mammal(String name) {
		super(name);
	}

	@Override
	public String toString() {
		return "Mammal[" + super.toString() + "]";
	}

}
