package _02_intermediate_I._03_inheritance;

public class ZTriangle extends ZFigure {
	private double base;
	private double altura;

	public ZTriangle(String color, double base, double altura) {
		super(color);
		this.base = base;
		this.altura = altura;
	}

	public double getBase() {
		return base;
	}

	public double getAltura() {
		return altura;
	}

	@Override
	public double area() {
		return (base * altura) / 2;
	}

	// Covariant return: Returns a ZTriangle instead of a ZFigure
	@Override
	public ZTriangle duplicate() {
		return new ZTriangle(this.getColor(), this.base, this.altura);
	}
}
