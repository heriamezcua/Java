package _02_intermediate_I._03_inheritance;

public class ZRectangle extends ZFigure {
	private double ancho;
	private double alto;

	public ZRectangle(String color, double ancho, double alto) {
		super(color);
		this.ancho = ancho;
		this.alto = alto;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	@Override
	public double area() {
		return ancho * alto;
	}

	// Covariant return: returns a ZRectangle instead of a ZFigure
	@Override
	public ZRectangle duplicate() {
		return new ZRectangle(this.getColor(), this.ancho, this.alto);
	}
}
