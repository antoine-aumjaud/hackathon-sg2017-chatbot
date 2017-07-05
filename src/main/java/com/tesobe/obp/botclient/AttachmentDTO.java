package com.tesobe.obp.botclient;

import lombok.Data;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class AttachmentDTO {

    public AttachmentDetailsDTO getAttachment() {
        return attachment;
    }

    public void setAttachment(AttachmentDetailsDTO attachment) {
        this.attachment = attachment;
    }

    private AttachmentDetailsDTO attachment;

    public static AttachmentDTO createImageAttachement(String uri) {

        AttachmentDetailsDTO detailsDTO = new AttachmentDetailsDTO();
        detailsDTO.setType("image");
        UrlDTO urlDTO = new UrlDTO(uri);
        detailsDTO.setPayload(urlDTO);

        AttachmentDTO attachmentDTO = new AttachmentDTO();
        attachmentDTO.setAttachment(detailsDTO);
        return attachmentDTO;
    }
}
