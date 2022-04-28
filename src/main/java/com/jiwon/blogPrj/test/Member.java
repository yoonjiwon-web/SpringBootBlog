package com.jiwon.blogPrj.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter
@AllArgsConstructor
@NoArgsConstructor // 빈생성자
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;

}
