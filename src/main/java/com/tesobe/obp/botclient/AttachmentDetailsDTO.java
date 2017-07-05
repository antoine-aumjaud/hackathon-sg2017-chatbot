package com.tesobe.obp.botclient;

import lombok.Data;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class AttachmentDetailsDTO {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UrlDTO getPayload() {
        return payload;
    }

    public void setPayload(UrlDTO payload) {
        this.payload = payload;
    }

    private String type;
    private UrlDTO payload;

}
