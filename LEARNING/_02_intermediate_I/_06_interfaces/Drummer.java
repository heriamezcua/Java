package _02_intermediate_I._06_interfaces;

public class Drummer implements Musician, Instrumentalist {

	private static final String INSTRUMENT = "Drum";

	private String name;
	private int experienceYears;

	public Drummer() {
		this.name = "Unknown";
		this.experienceYears = 0;
	}

	public Drummer(String name, int experienceYears) {
		this.name = name;
		this.experienceYears = experienceYears;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}

	// Musician and Instrumentalist
	@Override
	public void play() {
		System.out.println(name + " is playing the drum.");
	}

	// Instrumentalist
	@Override
	public void play(String song) {
		System.out.println(name + " is playing the drum in " + song);
	}

	@Override
	public void stop() {
		System.out.println(name + " has stopped playing the drum.");
	}

	@Override
	public String getInstrument() {
		return "Drum";
	}
}
