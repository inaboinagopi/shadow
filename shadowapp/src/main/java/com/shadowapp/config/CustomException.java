package com.shadowapp.config;

import com.shadowapp.dto.CustomMessageDTO;

@SuppressWarnings("serial")
public class CustomException extends RuntimeException {
	
	
	public CustomException(String msg, String status) {
		super(msg);
	}

	public CustomException(String msg) {
		super(msg);
	}

	public CustomMessageDTO getCustomMessage(String msg, String Status) {
		CustomMessageDTO errorMessageDTO = new CustomMessageDTO();
		errorMessageDTO.setStatus(Status);
		if (msg == null || msg.isEmpty() || msg.equals("")) {
			errorMessageDTO.setMessage("noDataFound");
		} else {
			errorMessageDTO.setMessage(msg);
		}
		return errorMessageDTO;
	}

}
