package intermediate._04_inheritance;

public abstract class ZFigure {
	private String color;

	public ZFigure(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	// abstract method
	public abstract double area();

	// return type covariant
	public abstract ZFigure duplicate();

}
