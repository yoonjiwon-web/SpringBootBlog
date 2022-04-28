package com.jiwon.blogPrj.service;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jiwon.blogPrj.model.Board;
import com.jiwon.blogPrj.model.RoleType;
import com.jiwon.blogPrj.model.User;
import com.jiwon.blogPrj.repository.UserRepository;

// 스프링이 컴포넌트 스캔을 통해서 bean에 등록해줌. IOC 해줌.
@Service
public class UserService {
 
	// JPA 의존
	@Autowired
	private UserRepository userRepository;
	
	// 패스워드 암호화
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public int Signup(User user) {
			String oriPassword = user.getPassword(); // 패스워드 원문
			String encPassword = encoder.encode(oriPassword); // 암호화 처리 완료
			user.setPassword(encPassword);
			user.setRole(RoleType.USER);
			try {
				userRepository.save(user);
				return 1;
			} catch (Exception e) {
				return -1;
			}
	}
	
	// 전통적인 로그인 방식 (스프링 시큐리티 아님!!) 에서 호출
	// @Transactional(readOnly = true) // 트랙잭션이 종료될떄까지 정합성 유지. (select 여러번 하더라도 데이터 안정)
	// public User login(User user) {
	// 	return userRepository.login(user.getUsername(), user.getPassword()); // User를 return 해줌.
	// }
	 
	@Transactional
	public void updateUser(User requestUser) {
		// 수정시에는 User 오브젝트를 가져와서, 가져온 오브젝트를 수정하는 방식!!
		User user = userRepository.findById(requestUser.getId()) // principal 에 인증된 사용자 id
				.orElseThrow(()->{
					return new IllegalArgumentException("해당 사용자는 존재하지 않습니다. id 찾을 수 없음!!");
				}); // 영속화 완료
		String originPw = requestUser.getPassword();
		String encPw = encoder.encode(originPw); // 암호화 시킴 
		// update 자원 셋팅
		user.setPassword(encPw);
		user.setEmail(requestUser.getEmail()); 
		// 해당 함수로 종료시(service가 종료될때) 트랜잭션이 종료됨.--> 이때 더티체킹 발생!! -> 자동으로 db에 업데이트됨. (@Transactional 선언 필수) 
	}
	
}
