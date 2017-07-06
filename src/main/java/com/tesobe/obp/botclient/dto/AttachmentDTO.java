package com.tesobe.obp.botclient.dto;

import lombok.Data;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class AttachmentDTO implements BaseMessageDTO {
    private AttachmentDetailsDTO attachment;

    public AttachmentDetailsDTO getAttachment() {
        return attachment;
    }

    public static AttachmentDTO createImageAttachement(String uri) {
        AttachmentDTO attachmentDTO = new AttachmentDTO();
        attachmentDTO.attachment = new AttachmentDetailsDTO("image", uri);
        return attachmentDTO;
    }
}
