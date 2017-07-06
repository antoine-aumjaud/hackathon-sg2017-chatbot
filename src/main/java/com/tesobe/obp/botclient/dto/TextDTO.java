package com.tesobe.obp.botclient.dto;

import lombok.Data;

/**
 * Created by hadrien on 05/07/2017.
 */
@Data
public class TextDTO implements BaseMessageDTO {
    private final String text;

	public TextDTO(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
