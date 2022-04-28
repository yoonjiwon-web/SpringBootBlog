package com.jiwon.blogPrj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 로 허용  --> 인증이 필요없는 파일은 /auth/~~ 붙이기
// 그냥 주소가 /이면 index.jsp 허용
// static 이하에 있는 정적 파일(js, css, image 등) 허용
@Controller
public class UserController {
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm"; // jsp 호출
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm"; // jsp 호출
	}
	
	@GetMapping("/user/updateForm") // 회원정보 수정이기 때문에, /auth 경로가 아닌 /user 경로로 지정
	public String updateForm() {
		return "user/updateForm"; // jsp 호출
	}
}
