package _05_advanced._01_streams;

import java.util.*;
import java.util.stream.*;
import java.util.Comparator;
import java.util.function.Function;

public class _11_DownStreamCollectors {

	// City class with name, state, and population
	static class City {
		private String name;
		private String state;
		private int population;

		public City(String name, String state, int population) {
			this.name = name;
			this.state = state;
			this.population = population;
		}

		public String getName() {
			return name;
		}

		public String getState() {
			return state;
		}

		public int getPopulation() {
			return population;
		}

		@Override
		public String toString() {
			return name + " (" + population + ")";
		}
	}

	public static void main(String[] args) {
		// Sample list of locales
		List<Locale> locales = Arrays.asList(new Locale("en", "US"), new Locale("en", "GB"), new Locale("fr", "FR"),
				new Locale("es", "ES"), new Locale("de", "DE"), new Locale("fr", "CA"));

		// Sample list of cities
		List<City> cities = Arrays.asList(new City("New York", "NY", 8419600), new City("Los Angeles", "CA", 3980400),
				new City("Chicago", "IL", 2716000), new City("Houston", "TX", 2328000),
				new City("San Francisco", "CA", 873965), new City("Dallas", "TX", 1343000));

		// 1. Convert Lists to Sets
		Map<String, Set<Locale>> countryToLocaleSet = locales.stream()
				.collect(Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));
		System.out.println("Country to Locale Set: " + countryToLocaleSet);

		// 2. Counting Elements in Each Group
		Map<String, Long> countryToLocaleCounts = locales.stream()
				.collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));
		System.out.println("Country to Locale Counts: " + countryToLocaleCounts);

		// 3. Summing Values in Each Group (Total population per state)
		Map<String, Integer> stateToCityPopulation = cities.stream()
				.collect(Collectors.groupingBy(City::getState, Collectors.summingInt(City::getPopulation)));
		System.out.println("State to City Population: " + stateToCityPopulation);

		// 4. Finding Maximum or Minimum (Largest city per state)
		Map<String, Optional<City>> stateToLargestCity = cities.stream().collect(
				Collectors.groupingBy(City::getState, Collectors.maxBy(Comparator.comparing(City::getPopulation))));
		System.out.println("State to Largest City: " + stateToLargestCity);

		// 5. Mapping Values Before Collecting (Find longest city name per state)
		Map<String, Optional<String>> stateToLongestCityName = cities.stream()
				.collect(Collectors.groupingBy(City::getState,
						Collectors.mapping(City::getName, Collectors.maxBy(Comparator.comparing(String::length)))));
		System.out.println("State to Longest City Name: " + stateToLongestCityName);

		// 6. Gathering Unique Values (All languages spoken per country)
		Map<String, Set<String>> countryToLanguages = locales.stream().collect(Collectors.groupingBy(
				Locale::getDisplayCountry, Collectors.mapping(Locale::getDisplayLanguage, Collectors.toSet())));
		System.out.println("Country to Languages: " + countryToLanguages);

		// 7. Collecting Summary Statistics (Population statistics per state)
		Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities.stream()
				.collect(Collectors.groupingBy(City::getState, Collectors.summarizingInt(City::getPopulation)));
		System.out.println("State to City Population Summary: " + stateToCityPopulationSummary);

		// 8. Reducing Method (Concatenate city names per state)
		Map<String, String> stateToCityNames = cities.stream().collect(Collectors.groupingBy(City::getState,
				Collectors.reducing("", City::getName, (s, t) -> s.isEmpty() ? t : s + ", " + t)));
		System.out.println("State to City Names (reducing): " + stateToCityNames);

		// 9. Using joining() (Simpler concatenation)
		Map<String, String> stateToCityNamesJoining = cities.stream().collect(
				Collectors.groupingBy(City::getState, Collectors.mapping(City::getName, Collectors.joining(", "))));
		System.out.println("State to City Names (joining): " + stateToCityNamesJoining);
	}
}
