package com.jiwon.blogPrj.conf.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jiwon.blogPrj.model.User;

import lombok.Data;

@Data
public class PrincipalDetail implements UserDetails {
	
	@Autowired
	private User user;

	public PrincipalDetail(User user) {
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	// 계정이 만료되었는지 return. true 여야지 만료안됨
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정 잠겼는지 return. true 여야지 안잠김
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	// 비번 만료되었는지 retrun, true 여야지 안만료
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정 활성화. true 여야지 사용가능
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		// 람다식으로 표현
		collectors.add(()->{return "ROLE_" + user.getRole();}); // 반드시 ROLE_ 을 앞에 붙여서, ROLE_USER로 리턴해야됨.
		return collectors;
	}

	
	
}
