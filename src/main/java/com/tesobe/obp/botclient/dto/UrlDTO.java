package com.tesobe.obp.botclient.dto;

import com.tesobe.obp.botclient.dto.BaseMessageDTO;

import lombok.Data;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class UrlDTO implements BaseMessageDTO {

    private final String url;

    public UrlDTO(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
