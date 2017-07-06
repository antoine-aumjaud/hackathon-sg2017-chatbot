package com.tesobe.obp.botclient.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class QuickReplyDTO implements BaseMessageDTO {

    private final List<QuickReplyBlockDTO> quickReplies = new ArrayList<QuickReplyBlockDTO>();

    public QuickReplyDTO(String title, String blockName) {
        QuickReplyBlockDTO blockDTO = new QuickReplyBlockDTO(title);
        blockDTO.addBlock_names(blockName);
        this.quickReplies.add(blockDTO);
    }

    public List<QuickReplyBlockDTO> getQuickReplies() {
        return quickReplies;
    }

}
