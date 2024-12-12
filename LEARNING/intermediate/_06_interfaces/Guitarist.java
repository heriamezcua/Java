package intermediate._06_interfaces;

public class Guitarist implements Musician {

	private static final String INSTRUMENT = "Guitar";
	
	private String name;
	private int experienceYears;

	public Guitarist() {
		this.name = "Unknown";
		this.experienceYears = 0;
	}

	public Guitarist(String name, int experienceYears) {
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

	@Override
	public void play() {
		System.out.println(name + " is playing the guitar.");
	}

	@Override
	public void stop() {
		System.out.println(name + " has stopped playing the guitar.");
	}
}
