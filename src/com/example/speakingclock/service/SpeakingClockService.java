package com.example.speakingclock.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SpeakingClockService {
	private static final DateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm");

	public String convertTimeToWords(String timeString) {
		try {
			Date time = TIME_FORMAT.parse(timeString);
			int hour = time.getHours();
			int minute = time.getMinutes();

			if (hour == 0 && minute == 0) {
				return "It's Midnight";
			} else if (hour == 12 && minute == 0) {
				return "It's Midday";
			} else {
				String hourString = convertHourToWords(hour);
				String minuteString = convertMinuteToWords(minute);
				return "It's " + hourString + " " + minuteString;
			}
		} catch (Exception e) {
			return "Invalid time format. Please enter the time in the format HH:mm";
		}
	}

	public static String convertHourToWords(int hour) {
		if (hour == 0 || hour == 12) {
			return "twelve";
		} else if (hour > 12) {
			return convertHourToWords(hour - 12);
		} else {
			String[] hours = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
					"eleven" };
			return hours[hour];
		}
	}

	public static String convertMinuteToWords(int minute) {
		if (minute == 0) {
			return "o'clock";
		} else if (minute <= 30) {
			return convertMinuteToWordsHelper(minute) + " past";
		} else {
			return convertMinuteToWordsHelper(60 - minute) + " to";
		}
	}

	public static String convertMinuteToWordsHelper(int minute) {
		if (minute == 15) {
			return "quarter";
		} else if (minute == 30) {
			return "half";
		} else {
			String[] minutes = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
					"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
					"nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
					"twenty six", "twenty seven", "twenty eight", "twenty nine" };
			return minutes[minute];
		}
	}

}
