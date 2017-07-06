package com.tesobe.obp.botclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tesobe.obp.botclient.dto.AttachmentDTO;
import com.tesobe.obp.botclient.dto.MessageDTO;

@RestController
public class InfoRessource {

	private final Logger log = LoggerFactory.getLogger(InfoRessource.class);

	@Autowired
	private DataUser dataUser;

	@RequestMapping("/bot/info")
	public ResponseEntity info(@RequestParam("userId") String userId) {
		dataUser.chabotId = userId;
		log.info("UserId {} set", userId);
		return ResponseEntity.ok("");
	}

	@RequestMapping("/bot/gifSalary")
	public ResponseEntity getHappyGif() {
		MessageDTO message = new MessageDTO();
		message.addMessage(AttachmentDTO.createImageAttachement(
				"https://media.giphy.com/media/l3q2tBVPkO6PHnTJC/200w_d.gif"));
		return ResponseEntity.ok(message);
	}
}
