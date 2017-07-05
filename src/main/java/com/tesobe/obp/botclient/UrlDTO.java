package com.tesobe.obp.botclient;

import lombok.Data;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class UrlDTO {

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    public UrlDTO(String url) {
        this.url = url;
    }
}
