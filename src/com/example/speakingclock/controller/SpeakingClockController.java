package com.example.speakingclock.controller;

import com.example.speakingclock.service.SpeakingClockService;

import java.util.Scanner;

public class SpeakingClockController {
	private final SpeakingClockService speakingClockService;

	public SpeakingClockController(SpeakingClockService speakingClockService) {
		this.speakingClockService = speakingClockService;
	}

	public void start() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the time (in the format HH:mm): ");
		String inputTime = scanner.nextLine();

		String convertedTime = speakingClockService.convertTimeToWords(inputTime);
		System.out.println(convertedTime);
	}
}
