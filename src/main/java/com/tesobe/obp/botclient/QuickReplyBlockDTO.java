package com.tesobe.obp.botclient;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class QuickReplyBlockDTO {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public List<String> getBlock_names() {
        return block_names;
    }

    public void setBlock_names(List<String> block_names) {
        this.block_names = block_names;
    }

    private List<String> block_names = new ArrayList<String>();
}
