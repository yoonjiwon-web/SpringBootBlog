package com.jiwon.blogPrj.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HttpControllerTest {

	// localhost:8080/blogs/home (/blogs가 선행되어야하며, yml 파일에 명시)
	@GetMapping("/home")
	public String getTest(Member member) {
		// prefix: /WEB-INF/views/
	    //  suffix: .jsp 로 yml 파일에 명시해놨으니깐
		// 최종경로는 /WEB-INF/views/test.jsp
		return "test";
	}
}
