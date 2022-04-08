package com.olix.stock_system.api.helper;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordHelper {

	public PasswordEncoder getEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
