package com.jiwon.blogPrj.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncordingTest {

	@Test
	public void 해쉬_암호화() {
		String encPassword = new BCryptPasswordEncoder().encode("1234");
		System.out.println(encPassword);
	}
	
}
