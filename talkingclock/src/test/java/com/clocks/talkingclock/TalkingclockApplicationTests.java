package com.clocks.talkingclock;

import com.clocks.talkingclock.service.TalkingClockWithInputCommandLine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes=TalkingclockWithInputCommandLineTest.class)
class TalkingclockWithInputCommandLineTest {

	@Test
	void testGetTimeTextWith4h11m() {
		String timeText = TalkingClockWithInputCommandLine.getTimeText("04:11");
		assertTrue(timeText.equalsIgnoreCase("eleven past four"));
	}

	@Test
	void testGetTimeTextWith4h7m() {
		String timeText = TalkingClockWithInputCommandLine.getTimeText("04:07");
		assertTrue(timeText.equalsIgnoreCase("seven past four"));
	}

	@Test
	void testGetTimeTextWith4h27m() {
		String timeText = TalkingClockWithInputCommandLine.getTimeText("04:27");
		assertTrue(timeText.equalsIgnoreCase("twenty seven past four"));
	}

	@Test
	void testGetTimeTextWith0h27m() {
		String timeText = TalkingClockWithInputCommandLine.getTimeText("00:27");
		assertTrue(timeText.equalsIgnoreCase("twenty seven past twelve"));
	}

	@Test
	void testGetTimeTextWith12h00m() {
		String timeText = TalkingClockWithInputCommandLine.getTimeText("12:00");
		assertTrue(timeText.equalsIgnoreCase("twelve o'clock"));
	}

	@Test
	void testGetTimeTextWith12h31m() {
		String timeText = TalkingClockWithInputCommandLine.getTimeText("12:31");
		assertTrue(timeText.equalsIgnoreCase("twenty nine to one"));
	}

	@Test
	void testGetTimeTextWith14h31m() {
		String timeText = TalkingClockWithInputCommandLine.getTimeText("14:31");
		assertTrue(timeText.equalsIgnoreCase("twenty nine to three"));
	}

	@Test
	void testGetTimeTextWith14h40m() {
		String timeText = TalkingClockWithInputCommandLine.getTimeText("14:40");
		assertTrue(timeText.equalsIgnoreCase("twenty to three"));
	}

	@Test
	void testGetTimeTextWith14h52m() {
		String timeText = TalkingClockWithInputCommandLine.getTimeText("14:52");
		assertTrue(timeText.equalsIgnoreCase("eight to three"));
	}

	@Test
	void testGetTimeTextWith0h0m() {
		String timeText = TalkingClockWithInputCommandLine.getTimeText("00:00");
		assertTrue(timeText.equalsIgnoreCase("twelve o'clock"));
	}

	@Test
	void testValidateTimeFormatWithValidTimeFormat() {
		assertTrue(TalkingClockWithInputCommandLine.validateTimeFormat("04:07"));
	}

	@Test
	void testValidateTimeFormatWithHyphen() {
		assertFalse(TalkingClockWithInputCommandLine.validateTimeFormat("04-07"));
	}

	@Test
	void testValidateTimeFormatWithInvalidNumbers() {
		assertFalse(TalkingClockWithInputCommandLine.validateTimeFormat("04:77"));
	}

	@Test
	void testValidateTimeFormatWithInvalidNumbers2() {
		assertFalse(TalkingClockWithInputCommandLine.validateTimeFormat("44:47"));
	}

	@Test
	void testValidateTimeFormatWithInvalidLength() {
		assertFalse(TalkingClockWithInputCommandLine.validateTimeFormat("014:47"));
	}

	@Test
	void testValidateTimeFormatWithInvalidLength2() {
		assertFalse(TalkingClockWithInputCommandLine.validateTimeFormat("14:047"));
	}

	@Test
	void testValidateTimeFormatWithLetters() {
		assertFalse(TalkingClockWithInputCommandLine.validateTimeFormat("14:s4"));
	}

	@Test
	void testValidateTimeFormatWithLetters2() {
		assertFalse(TalkingClockWithInputCommandLine.validateTimeFormat("1s:14"));
	}
}

