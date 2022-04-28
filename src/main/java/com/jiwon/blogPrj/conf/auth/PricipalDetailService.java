package com.jiwon.blogPrj.conf.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jiwon.blogPrj.model.User;
import com.jiwon.blogPrj.repository.UserRepository;

@Service
public class PricipalDetailService  implements UserDetailsService  {

	@Autowired
	UserRepository userRepository;
	
	// password 부분은 알아서 처리하기때문에, username이 db에 있는지만 확인
	// 꼭 만들어야됨!!!!
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. " + username);
				});
		System.out.println("loadUserByUsername 들어옴...." + principal.getUsername());
		return new PrincipalDetail(principal); // 시큐리티 세션에 유저정보가 저장이 됨. 타입은 userDetails 타입.
		                                       // 이걸 안하면, id는 무조건 user고, 패스워드는 console 창에 뜨는 거임...
	}
	

}
