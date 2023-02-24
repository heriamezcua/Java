/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package composition;

import java.util.regex.Pattern;

/**
 *
 * @author Hoxuro
 */
public class Author {

    private String name, email;
    private char gender;

    public Author(String name, String email, char gender) {
        if (!Pattern.matches("[ A-Za-záéíóúÁÉÍÓÚñÑ]{4,80}", name)) {
            throw new IllegalArgumentException("The name entered is not valid");
        }
        if (!Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", email)) {
            throw new IllegalArgumentException("The email entered is not valid");
        }
        if (Character.toUpperCase(gender) != 'M' && Character.toUpperCase(gender) != 'F') {
            throw new IllegalArgumentException("The gender entered not exists");

        }

        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public Author() {
        this("aaaaaa", "example@gmail.com", 'M');
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Author[" + "name=" + name + ", email=" + email + ", gender=" + gender + "]";
    }
}

/*
        Author ahTeck = new Author("Tan Ah Teck", "ahteck@nowhere.com", 'm'); // Test the constructor
        System.out.println(ahTeck);  // Test toString()
        ahTeck.setEmail("paulTan@nowhere.com");  // Test setter
        System.out.println("name is: " + ahTeck.getName());     // Test getter
        System.out.println("eamil is: " + ahTeck.getEmail());   // Test getter
        System.out.println("gender is: " + ahTeck.getGender()); // Test gExerciseOOP_MyPolynomial.pngetter
*/
