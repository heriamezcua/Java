package basic.simpleexercises1;

import basic.utilis.ReadKBData;

/*
 * Program that tell us if a student is approved or failed
 */
public class Ex17 {

	public static void main(String[] args) {
	       int failedStudents = ReadKBData.enterInt("Enter the number of failed students: ");
	        do {
	            if (failedStudents < 0) {
	                System.err.println("The number of students cannot be negative");
	                failedStudents = ReadKBData.enterInt("Enter the number of failed students: ");
	            }
	        } while (failedStudents < 0);

	        int passingStudents = ReadKBData.enterInt("Enter the number of passing students: ");
	        do {
	            if (passingStudents < 0) {
	                System.err.println("The number of students cannot be negative");
	                passingStudents = ReadKBData.enterInt("Enter the number of passing students: ");
	            }
	        } while (passingStudents < 0);

	        int goodStudents = ReadKBData.enterInt("Enter the number of students with good grades: ");
	        do {
	            if (goodStudents < 0) {
	                System.err.println("The number of students cannot be negative");
	                goodStudents = ReadKBData.enterInt("Enter the number of students with good grades: ");
	            }
	        } while (goodStudents < 0);

	        int excellentStudents = ReadKBData.enterInt("Enter the number of students with excellent grades: ");
	        do {
	            if (excellentStudents < 0) {
	                System.err.println("The number of students cannot be negative");
	                excellentStudents = ReadKBData.enterInt("Enter the number of students with excellent grades: ");
	            }
	        } while (excellentStudents < 0);

	        int totalStudents = failedStudents + passingStudents + goodStudents + excellentStudents;
	        int totalPassed = passingStudents + goodStudents + excellentStudents;

	        System.out.println("Total passed: " + (totalPassed * 100) / totalStudents + "%");
	        System.out.println("Percentage of failed students: " + (failedStudents * 100) / totalStudents + "%");
	        System.out.println("Percentage of passing students: " + (passingStudents * 100) / totalStudents + "%");
	        System.out.println("Percentage of good grades: " + (goodStudents * 100) / totalStudents + "%");
	        System.out.println("Percentage of excellent grades: " + (excellentStudents * 100) / totalStudents + "%");
	    }
	
}
