package intermediate1._03_inheritance;

public enum Habitat {
	
    MOUNTAINS("High-altitude areas, often rocky cliffs."),
    FORESTS("Dense woodlands with tall trees."),
    GRASSLANDS("Open plains with sparse trees."),
    COASTAL("Near oceans or large lakes, often hunting for fish."),
    DESERT("Arid regions with minimal vegetation."),
    URBAN("Cityscapes, nesting on tall buildings.");
	
    private final String description;

    Habitat(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
