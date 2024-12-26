package intermediate1._06_interfaces;

public interface Instrumentalist {

	void play();  // The same method as in Musician
	
	void play(String song);  // Not a problem, method overloading
	
	// String play();  // Compilation error, conflict with play() in Musician interface
	
	String getInstrument();
}
