/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 * A class called Date, which models a calendar date
 *
 * @author Hoxuro
 */
public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day not valid");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month not valid");
        }
        if (year < 1900 || year > 9999) {
            throw new IllegalArgumentException("Year not valid");
        }

        this.day = day;
        this.month = month;
        this.year = year;

    }

    public Date() {
        this(1, 1, 1900);
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day not valid");
        }
        this.day = day;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month not valid");
        }
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        if (year < 1900 || year > 9999) {
            throw new IllegalArgumentException("Year not valid");
        }
        this.year = year;
    }

    public void setDate(int day, int month, int year) {
        if (!(day < 1 || day > 31) && !(month < 1 || month > 12) && !(year < 1900 || year > 9999)) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    @Override
    public String toString() {

        if (day < 10 && month < 10) {
            return "0" + day + "/" + "0" + month + "/" + year;

        } else if (day < 10) {
            return "0" + day + "/" + month + "/" + year;

        } else {

            return day + "/" + month + "/" + year;
        }

    }

}

/*
        // Test constructor and toString()
        Date d1 = new Date(1, 2, 2014);
        System.out.println(d1);  // toString()

        // Test Setters and Getters
        d1.setMonth(12);
        d1.setDay(9);
        d1.setYear(2099);
        System.out.println(d1);  // toString()
        System.out.println("Month: " + d1.getMonth());
        System.out.println("Day: " + d1.getDay());
        System.out.println("Year: " + d1.getYear());

        // Test setDate()
        d1.setDate(3, 4, 2016);
        System.out.println(d1);  // toString()
*/
