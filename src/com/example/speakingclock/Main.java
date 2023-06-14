package com.example.speakingclock;

import com.example.speakingclock.controller.SpeakingClockController;
import com.example.speakingclock.service.SpeakingClockService;

public class Main {
	public static void main(String[] args) {
		SpeakingClockService speakingClockService = new SpeakingClockService();
		SpeakingClockController speakingClockController = new SpeakingClockController(speakingClockService);
		speakingClockController.start();
	}
}