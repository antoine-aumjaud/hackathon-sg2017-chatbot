package com.tesobe.obp.botclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tesobe.obp.schedule.ScheduledTasks;

@RestController
public class InfoRessource {

	private final Logger log = LoggerFactory.getLogger(InfoRessource.class);

	@RequestMapping("/bot/info")
	public ResponseEntity info(@RequestParam("userId") String userId) {
		ScheduledTasks.chatfuelUserId = userId;
		log.info("UserId {} set", userId);
		return ResponseEntity.ok("");
	}

}
