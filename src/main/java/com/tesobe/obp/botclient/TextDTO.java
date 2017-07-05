package com.tesobe.obp.botclient;

import lombok.Data;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class TextDTO {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;
}
