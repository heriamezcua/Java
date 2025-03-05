package basic._ex01_simpleexercises1;

import basic.utilis.ReadKBData;

/*
 * Program that print the hour entered by the user plus 1 second
 */
public class Ex11 {

	public static void main(String[] args) {

		int hour = getHour(), min = getMin(), sec = getSec();

		System.out.println(printHour(hour, min, sec));
		System.out.println(printHourPlus1Sec(hour, min, sec));
	}

	public static int getHour() {
		int hour = ReadKBData.enterInt("Enter an hour (0 - 23): ");

		if (hour < 0 || hour >= 24) {
			throw new AssertionError("incorrect hour range");
		}

		return hour;
	}

	public static int getMin() {
		int min = ReadKBData.enterInt("Enter a minute (0 - 59):");

		if (min < 0 || min > 60) {
			throw new AssertionError("incorrect minute range");
		}

		return min;
	}

	public static int getSec() {
		int sec = ReadKBData.enterInt("Enter a second (0 - 59):");

		if (sec < 0 || sec > 60) {
			throw new AssertionError("incorrect second range");
		}

		return sec;
	}

	public static String printHourPlus1Sec(int hour, int min, int sec) {
	    // Incrementing seconds plus 1
	    sec++;

	    // Adjusting the new hour
	    if (sec == 60) {
	        sec = 0;
	        min++;
	    }
	    if (min == 60) {
	        min = 0;
	        hour++;
	    }
	    if (hour == 24) {
	        hour = 0;
	    }

	    // Formatting numbers
	    String secString = formatting(sec);
	    String minString = formatting(min);
	    String hourString = formatting(hour);

	    return "1 second after: " + hourString + ":" + minString + ":" + secString;
	}
	
    public static String printHour(int hour, int min, int sec){
        // Formatting the entered hour
        String secString = formatting(sec);
        String minString = formatting(min);
        String hourString = formatting(hour);

        return "Actual hour: " + hourString + ":" + minString + ":" + secString;
    }

	public static String formatting(int number) {
		return (number < 10 ? "0" : "") + number;
	}

}
