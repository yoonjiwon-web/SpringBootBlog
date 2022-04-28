package com.jiwon.blogPrj.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jiwon.blogPrj.dto.ResponseDto;
import com.jiwon.blogPrj.model.User;
import com.jiwon.blogPrj.service.UserService;

@RestController // 데이터만 return 해주기때문에 restController
public class UserApiController {

	@Autowired
	private UserService userService;
	 
	
	// 회원가입
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.print("save 호출");
		userService.Signup(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 1이 들어오면 OK.  // 자바오브젝트를 JSON으로 변환해서 리턴 (Jackson)
	}
	
	// 전통적인 로그인 방식 (스프링 시큐리티 아님!!)
	// @PostMapping("/api/user/login")
	// public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){  // 전역변수에 @Autowired로 선언해도됨
	// 	System.out.print("login 호출"); 
	// 	User logindata = userService.login(user);
	// 	if(logindata != null) {
	// 		session.setAttribute("logindata", logindata); // 세션만듦
	// 	}
	// 	return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 1이 들어오면 OK
	// }
	
	// 회원정보 수정
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user){ // @RequestBody 쓰는 이유는 json 형식으로 데이터를 받기위함!!
		userService.updateUser(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 1이 들어오면 OK		
	}
	
	
	 
	
}
