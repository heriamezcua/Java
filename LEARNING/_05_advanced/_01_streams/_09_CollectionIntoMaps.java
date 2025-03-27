package _05_advanced._01_streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class _09_CollectionIntoMaps {

	    static class Person {
	        private int id;
	        private String name;

	        public Person(int id, String name) {
	            this.id = id;
	            this.name = name;
	        }

	        public int getId() {
	            return id;
	        }

	        public String getName() {
	            return name;
	        }

	        @Override
	        public String toString() {
	            return "Person[id=" + id + ", name=" + name + "]";
	        }
	    }

	    public static Stream<Person> people() {
	        return Stream.of(
	            new Person(1001, "Peter"),
	            new Person(1002, "Paul"),
	            new Person(1003, "Mary")
	        );
	    }

	    public static void main(String[] args) {
	        
	        // Basic Usage: Collecting people into a Map with ID as key and name as value
	        Map<Integer, String> idToName = people().collect(
	            Collectors.toMap(Person::getId, Person::getName)
	        );
	        System.out.println("idToName: " + idToName);
	        
	        // Using Identity Function: Collecting people into a Map with ID as key and person as value
	        Map<Integer, Person> idToPerson = people().collect(
	            Collectors.toMap(Person::getId, Function.identity())
	        );
	        System.out.println("idToPerson: " + idToPerson);

	        // Handling Duplicate Keys: Keeping the first occurrence
	        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
	        Map<String, String> languageNames = locales.collect(
	            Collectors.toMap(
	                Locale::getDisplayLanguage,
	                l -> l.getDisplayLanguage(l),
	                (existingValue, newValue) -> existingValue // Keep first value
	            )
	        );
	        System.out.println("languageNames: " + languageNames);
	        
	        // Collecting into Set Values: Mapping countries to multiple languages
	        locales = Stream.of(Locale.getAvailableLocales());
	        Map<String, Set<String>> countryLanguageSets = locales.collect(
	            Collectors.toMap(
	                Locale::getDisplayCountry,
	                l -> Collections.singleton(l.getDisplayLanguage()),
	                (a, b) -> {
	                    Set<String> union = new HashSet<>(a);
	                    union.addAll(b);
	                    return union;
	                }
	            )
	        );
	        System.out.println("countryLanguageSets: " + countryLanguageSets);
	        
	        // Using TreeMap: Collecting into a TreeMap with explicit constructor
	        idToPerson = people().collect(
	            Collectors.toMap(
	                Person::getId,
	                Function.identity(),
	                (existingValue, newValue) -> { throw new IllegalStateException(); },
	                TreeMap::new
	            )
	        );
	        System.out.println("idToPerson (TreeMap): " + idToPerson);
	        
	        // Using ConcurrentMap: Optimized for parallel processing
	        Map<Integer, Person> concurrentIdToPerson = people().parallel().collect(
	            Collectors.toConcurrentMap(Person::getId, Function.identity())
	        );
	        System.out.println("concurrentIdToPerson: " + concurrentIdToPerson);
	    }
	}
