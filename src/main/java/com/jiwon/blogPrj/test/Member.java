package com.jiwon.blogPrj.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter
@AllArgsConstructor
@NoArgsConstructor // λΉμμ±μ
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;

}
