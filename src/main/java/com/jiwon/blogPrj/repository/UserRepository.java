package com.jiwon.blogPrj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jiwon.blogPrj.model.User;

// User 테이블의 pk는 integer형이라고 정의
// DAO. 자동으로 BEAN 등록
// @Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	// JPA 네이밍
	// 전통적인 로그인 방식 (스프링 시큐리티 아님!!) 에서 호출
	// SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ? 로 자동으로 JPA에서 RETURN 해줌.. 
	// 아래처럼 @Query로 명시해줘도 좋지만, 간단한 쿼리는 JPA에서 제공하는 네이밍규칙으로 자동쿼리 해주는게 좋음.
	////User findByUsernameAndPassword(String username, String password);
	//@Query(value = "SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?", nativeQuery = true)
	//User login(String username, String password); // 단순 select는 객체로 가져와도 상관없으나, update 등은 int형으로 수정된 갯수로 가져오기때문에 int형으로 선언.
	
	////User findByUsername(String username);
	Optional<User> findByUsername(String username);
	//@Query(value = "SELECT * FROM USER WHERE USERNAME = ?", nativeQuery = true)
	//User findByUsername(String username);
}
