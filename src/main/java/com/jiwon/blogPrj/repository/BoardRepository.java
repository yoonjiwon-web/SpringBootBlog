package com.jiwon.blogPrj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jiwon.blogPrj.dto.ReplaySaveRequestDto;
import com.jiwon.blogPrj.model.Board;
import com.jiwon.blogPrj.model.User;

public interface BoardRepository extends JpaRepository<Board, Integer>{

	// save()는 기본으로 JPA에서 제공해서 작성X
	 
}
