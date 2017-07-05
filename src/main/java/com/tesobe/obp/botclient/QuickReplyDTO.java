package com.tesobe.obp.botclient;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class QuickReplyDTO {

    public List<QuickReplyBlockDTO> getQuickReplies() {
        return quickReplies;
    }

    public void setQuickReplies(List<QuickReplyBlockDTO> quickReplies) {
        this.quickReplies = quickReplies;
    }

    private List<QuickReplyBlockDTO> quickReplies = new ArrayList<QuickReplyBlockDTO>();

    public QuickReplyDTO(String title, String blockName) {
        QuickReplyBlockDTO blockDTO = new QuickReplyBlockDTO();
        blockDTO.setTitle(title);
        blockDTO.getBlock_names().add(blockName);
        this.quickReplies.add(blockDTO);
    }
}
