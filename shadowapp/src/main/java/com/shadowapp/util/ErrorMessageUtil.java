package com.shadowapp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.shadowapp.dto.CustomMessageDTO;

@Component
public class ErrorMessageUtil {
	
	 private static final Logger logger = LoggerFactory.getLogger(ErrorMessageUtil.class);

	    public CustomMessageDTO getError(HttpStatus status, String msg) {
	        CustomMessageDTO errorMessageDTO = new CustomMessageDTO();
	        errorMessageDTO.setHttpStatus(status.toString());
	        errorMessageDTO.setMessage((msg == null || msg.isEmpty()) ? "An error occurred" : msg);
	        return errorMessageDTO;
	    }

}
