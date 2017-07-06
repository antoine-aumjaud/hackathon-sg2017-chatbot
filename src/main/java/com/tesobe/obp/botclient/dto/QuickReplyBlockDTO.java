package com.tesobe.obp.botclient.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class QuickReplyBlockDTO {

    private final String title;
    private final List<String> block_names = new ArrayList<String>();

    public QuickReplyBlockDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addBlock_names(String blocName) {
        block_names.add(blocName);
    }
}
