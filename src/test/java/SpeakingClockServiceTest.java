package test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.speakingclock.service.SpeakingClockService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpeakingClockServiceTest {
	private SpeakingClockService speakingClockService;

	@BeforeEach
	public void setUp() {
		speakingClockService = new SpeakingClockService();
	}

	@Test
	public void testConvertTimeToWords_Midnight() {
		String convertedTime = speakingClockService.convertTimeToWords("00:00");
		assertEquals("It's Midnight", convertedTime);
	}

	@Test
	public void testConvertTimeToWords_Midday() {
		String convertedTime = speakingClockService.convertTimeToWords("12:00");
		assertEquals("It's Midday", convertedTime);
	}

	@Test
	public void testConvertTimeToWords_RegularTime() {
		String convertedTime = speakingClockService.convertTimeToWords("08:26");
		assertEquals("It's eight twenty six past", convertedTime);
	}

	@Test
	public void testConvertTimeToWords_InvalidFormat() {
		String convertedTime = speakingClockService.convertTimeToWords("08-34");
		assertEquals("Invalid time format. Please enter the time in the format HH:mm", convertedTime);
	}
}
