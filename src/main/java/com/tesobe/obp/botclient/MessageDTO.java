package com.tesobe.obp.botclient;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class MessageDTO {

    public List getMessages() {
        return messages;
    }

    public void setMessages(List message) {
        this.messages = message;
    }

    public List messages = new ArrayList();

}
