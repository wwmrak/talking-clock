package com.clocks. talkingclock. controller;

import com.clocks.talkingclock.service.TalkingClockService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TalkingClockController {
	@RequestMapping(value = "/talking-clock", method = RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
	public String getTimeText(@RequestParam String time) {
		TalkingClockService talkingClock = new TalkingClockService();
		String timeText = talkingClock.getTimeText(time.trim());

		return "\"time\": \" + timeText + \"";
	}
}