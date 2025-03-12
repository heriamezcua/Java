package _02_intermediate_I._06_interfaces;

public interface Musician {

	// All methods in an interface are implicitly public abstract and constants are
	// implicitly public static final.

	String DEFAULT_INSTRUMENT = "Guitar"; // public, static and final by default

	void play(); // public abstract by default

	void stop(); // public abstract by default
}
