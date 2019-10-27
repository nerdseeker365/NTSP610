package com.nt.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder =
				                         new BCryptPasswordEncoder();
		String hashedPwd1 = passwordEncoder.encode("rani");
		String hashedPwd3 = passwordEncoder.encode("hyd");
		System.out.println(hashedPwd1+"            "+hashedPwd3);
		
	}

}
