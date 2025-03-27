package _05_advanced._01_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class _10_GroupingAndPartitioning {
	public static void main(String[] args) {
		// Create a list of locales
		List<Locale> locales = Arrays.asList(Locale.US, Locale.UK, Locale.CANADA, Locale.CANADA_FRENCH, Locale.FRANCE,
				Locale.GERMANY, new Locale("it", "CH"), new Locale("de", "CH"), new Locale("fr", "CH"));

		// GROUPING BY COUNTRY
		Map<String, List<Locale>> countryToLocales = locales.stream()
				.collect(Collectors.groupingBy(Locale::getCountry));

		// Print grouped locales by country
		System.out.println("Locales grouped by country:");
		countryToLocales.forEach((country, locList) -> System.out.println(country + " -> " + locList));

		// Example: Get locales for Switzerland (CH)
		List<Locale> swissLocales = countryToLocales.get("CH");
		System.out.println("\nLocales for Switzerland: " + swissLocales);

		// PARTITIONING BY ENGLISH LANGUAGE
		Map<Boolean, List<Locale>> englishAndOtherLocales = locales.stream()
				.collect(Collectors.partitioningBy(l -> l.getLanguage().equals("en")));

		// Retrieve and print English locales
		List<Locale> englishLocales = englishAndOtherLocales.get(true);
		List<Locale> otherLocales = englishAndOtherLocales.get(false);
		System.out.println("\nEnglish Locales: " + englishLocales);
		System.out.println("Other Locales: " + otherLocales);

		// GROUPING BY COUNTRY USING CONCURRENT MAP
		ConcurrentMap<String, List<Locale>> concurrentCountryToLocales = locales.parallelStream()
				.collect(Collectors.groupingByConcurrent(Locale::getCountry));

		// Print concurrent grouped locales
		System.out.println("\nLocales grouped by country (Concurrent):");
		concurrentCountryToLocales.forEach((country, locList) -> System.out.println(country + " -> " + locList));
	}
}
