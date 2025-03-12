package _02_intermediate_I._ex01_classesandobjects;

/**
 * 1.8 Ex: The Time Class
 * 
 * https://www3.ntu.edu.sg/home/ehchua/programming/java/J3f_OOPExercises.html#zz-1.8
 */
public class Ex03 {

	/**
	 * The {@code Time} class represents a specific time of day with hours, minutes,
	 * and seconds. It provides methods to get and set individual components of
	 * time, as well as to update the time by moving forward or backward by one
	 * second.
	 */
	public static class Time {
		private int hour;
		private int minute;
		private int second;

		/**
		 * Constructs a {@code Time} object with the specified hour, minute, and second.
		 *
		 * @param hour   The hour (0-23).
		 * @param minute The minute (0-59).
		 * @param second The second (0-59).
		 */
		public Time(int hour, int minute, int second) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}

		/**
		 * Gets the hour value.
		 *
		 * @return The hour (0-23).
		 */
		public int getHour() {
			return hour;
		}

		/**
		 * Sets the hour value.
		 *
		 * @param hour The new hour (0-23).
		 */
		public void setHour(int hour) {
			this.hour = hour;
		}

		/**
		 * Gets the minute value.
		 *
		 * @return The minute (0-59).
		 */
		public int getMinute() {
			return minute;
		}

		/**
		 * Sets the minute value.
		 *
		 * @param minute The new minute (0-59).
		 */
		public void setMinute(int minute) {
			this.minute = minute;
		}

		/**
		 * Gets the second value.
		 *
		 * @return The second (0-59).
		 */
		public int getSecond() {
			return second;
		}

		/**
		 * Sets the second value.
		 *
		 * @param second The new second (0-59).
		 */
		public void setSecond(int second) {
			this.second = second;
		}

		/**
		 * Sets the time to a new hour, minute, and second.
		 *
		 * @param hour   The new hour (0-23).
		 * @param minute The new minute (0-59).
		 * @param second The new second (0-59).
		 */
		public void setTime(int hour, int minute, int second) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}

		/**
		 * Advances the time by one second. If the current time is 23:59:59, it resets
		 * to 00:00:00.
		 *
		 * @return This {@code Time} instance after updating the time.
		 */
		public Time nextSecond() {
			second++;
			if (second == 60) {
				second = 0;
				minute++;
				if (minute == 60) {
					minute = 0;
					hour++;
					if (hour == 24) {
						hour = 0;
					}
				}
			}
			return this;
		}

		/**
		 * Moves the time back by one second. If the current time is 00:00:00, it resets
		 * to 23:59:59.
		 *
		 * @return This {@code Time} instance after updating the time.
		 */
		public Time previousSecond() {
			second--;
			if (second == -1) {
				second = 59;
				minute--;
				if (minute == -1) {
					minute = 59;
					hour--;
					if (hour == -1) {
						hour = 23;
					}
				}
			}
			return this;
		}

		/**
		 * Returns a string representation of the time in the format HH:MM:SS.
		 *
		 * @return A formatted string representing the time.
		 */
		@Override
		public String toString() {
			return String.format("%02d:%02d:%02d", hour, minute, second);
		}
	}

	public static void main(String[] args) {
		// Test constructors and toString()
		Time t1 = new Time(1, 2, 3);
		System.out.println(t1); // toString()

		// Test Setters and Getters
		t1.setHour(4);
		t1.setMinute(5);
		t1.setSecond(6);
		System.out.println(t1); // toString()
		System.out.println("Hour: " + t1.getHour());
		System.out.println("Minute: " + t1.getMinute());
		System.out.println("Second: " + t1.getSecond());

		// Test setTime()
		t1.setTime(23, 59, 58);
		System.out.println(t1); // toString()

		// Test nextSecond();
		System.out.println(t1.nextSecond());
		System.out.println(t1.nextSecond().nextSecond());

		// Test previousSecond()
		System.out.println(t1.previousSecond());
		System.out.println(t1.previousSecond().previousSecond());
	}

}
