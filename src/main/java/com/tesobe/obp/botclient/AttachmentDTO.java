package com.tesobe.obp.botclient;

import lombok.Data;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class AttachmentDTO {

    public AttachmentDetailsDTO getAttachement() {
        return attachement;
    }

    public void setAttachement(AttachmentDetailsDTO attachement) {
        this.attachement = attachement;
    }

    private AttachmentDetailsDTO attachement;

    public static AttachmentDTO createImageAttachement(String uri) {

        AttachmentDetailsDTO detailsDTO = new AttachmentDetailsDTO();
        detailsDTO.setType("image");
        UrlDTO urlDTO = new UrlDTO(uri);
        detailsDTO.setPayload(urlDTO);

        AttachmentDTO attachmentDTO = new AttachmentDTO();
        attachmentDTO.setAttachement(detailsDTO);
        return attachmentDTO;
    }
}
