package com.jiwon.blogPrj.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogPrjTest {

	@GetMapping("/test")
	public String test() {
		return "<h1>hello</h1>";
	}
}
