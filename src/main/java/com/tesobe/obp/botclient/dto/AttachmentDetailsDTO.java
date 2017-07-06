package com.tesobe.obp.botclient.dto;

import lombok.Data;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class AttachmentDetailsDTO {

    private final String type;
    private final UrlDTO payload;

    public AttachmentDetailsDTO(String type, String payload) {
        this.type = type;
        this.payload = new UrlDTO(payload);
    }
    
    public String getType() {
        return type;
    }

    public UrlDTO getPayload() {
        return payload;
    }


}
