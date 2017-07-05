package com.tesobe.obp.botclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

/**
 * REST controller for managing Asset.
 */
@RestController
public class ChatbotAccountRessource {

    private final Logger log = LoggerFactory.getLogger(ChatbotAccountRessource.class);

    private static final String ENTITY_NAME = "asset";

    public ChatbotAccountRessource() {
    }

    @RequestMapping("/bot/account")
    public ResponseEntity test() throws URISyntaxException {

        MessageDTO message = new MessageDTO();
        TextDTO texte = new TextDTO();
        texte.setText("Ceci est un test");
        message.getMessages().add(texte);
        return ResponseEntity.ok(message);

    }

}
