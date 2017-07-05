package com.tesobe.obp.botclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

/**
 * REST controller for managing Asset.
 */
@RestController
public class ChatbotTransactionRessource {

    private final Logger log = LoggerFactory.getLogger(ChatbotTransactionRessource.class);

    public ChatbotTransactionRessource() {
    }

    @RequestMapping("/bot/transaction")
    public ResponseEntity test() throws URISyntaxException {

        MessageDTO message = new MessageDTO();
        TextDTO texte = new TextDTO();
        texte.setText("Voici la liste des dernières transactions sur votre compte courant:");
        message.getMessages().add(texte);
        texte = new TextDTO();
        texte.setText("votre salaire (+ 3 000 €) est arrivé hier!.");
        message.getMessages().add(texte);
        AttachmentDTO attachmentDTO = AttachmentDTO.createImageAttachement("http://gph.is/2ki7Qrt");
        message.getMessages().add(attachmentDTO);
        texte = new TextDTO();
        texte.setText("vous avez payé votre facture EDF (+ 44,5 €).");
        message.getMessages().add(texte);
        texte = new TextDTO();
        texte.setText("vous avez payé 22 € hier à 'Histoire De'. C'est votre première transaction avec ce tiers.");
        message.getMessages().add(texte);
        QuickReplyDTO quickReplyDTO = new QuickReplyDTO("ajouter aux tiers connus", "Default answer");
        message.getMessages().add(quickReplyDTO);
        return ResponseEntity.ok(message);

    }

}
