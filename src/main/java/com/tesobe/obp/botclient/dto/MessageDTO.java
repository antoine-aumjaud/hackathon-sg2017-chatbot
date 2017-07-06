package com.tesobe.obp.botclient.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class MessageDTO {

    public final List<BaseMessageDTO> messages = new ArrayList<>();

    public void addMessage(BaseMessageDTO message) {
        messages.add(message);
    }

    public void addText(String text) {
        messages.add(new TextDTO(text));
    }
}
