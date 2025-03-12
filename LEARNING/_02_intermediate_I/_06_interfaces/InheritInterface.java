package _02_intermediate_I._06_interfaces;

public interface InheritInterface extends Musician {

	// An interface can inherit from other Interfaces

	// If we don't implement our parent interface methods
	// nothing changes

//	@Override
//	default void play() {
//		// TODO Auto-generated method stub
//		
//	}

	// We can provide a default implementation to our parent methods
	// "starting from Java 8"

	@Override
	default void stop() {
		System.out.println("Default stop implementation in InheritInterface.");
	}

	// Obviusly we can add new methods
	void tuneInstrument();
}
