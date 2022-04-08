package com.olix.stock_system.api.helper;

import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class EncoderHelper {

	public String decodeAuthRequestHeader(String header) {
		String[] splittedHeader = header.split(" ");
		String encodedUsernameAndPassword = new String(Base64.getDecoder().decode(splittedHeader[1]));
		String[] decodedUsernameAndPassword = encodedUsernameAndPassword.split(":");
		String decodedUsername = decodedUsernameAndPassword[0];
		return decodedUsername;
	}
}
