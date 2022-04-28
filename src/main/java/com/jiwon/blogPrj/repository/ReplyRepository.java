package com.jiwon.blogPrj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jiwon.blogPrj.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

	// 작성한 Query로 작동함.
	@Modifying
	@Query(value = "INSERT INTO REPLY(userId, boardId, content, createDate) VALUES(?1, ?2, ?3, now())", nativeQuery = true)
	int mSave(int userId, int boardId, String content); // 업데이트 된 행의 개수를 return 해주기떄문에 int형으로 선언!!
}
