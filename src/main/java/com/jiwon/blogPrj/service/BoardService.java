package com.jiwon.blogPrj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jiwon.blogPrj.dto.ReplaySaveRequestDto;
import com.jiwon.blogPrj.model.Board;
import com.jiwon.blogPrj.model.Reply;
import com.jiwon.blogPrj.model.RoleType;
import com.jiwon.blogPrj.model.User;
import com.jiwon.blogPrj.repository.BoardRepository;
import com.jiwon.blogPrj.repository.ReplyRepository;
import com.jiwon.blogPrj.repository.UserRepository;

@Service
public class BoardService {
	// JPA 의존
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private ReplyRepository replyRepository;
		
	@Transactional
	public void Saveform(Board board, User user) {  // title, content
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	// 글 목록 리스트 SELECT
	// 전체 리스트 가져옴.
	@Transactional(readOnly = true)
	public Page<Board> selectList(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Board selectDetail(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패. 글id 를 찾을수없습니다.");
				});
	}
	
	@Transactional
	public void updateById(int id, Board requestBoard) { 
		Board board = boardRepository.findById(id)
						.orElseThrow(()->{
							return new IllegalArgumentException("글 찾기 실패. 글id 를 찾을수없습니다.");
						}); // 영속화 완료
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		// 해당 함수로 종료시(service가 종료될때) 트랜잭션이 종료됨.--> 이때 더티체킹 발생!! -> 자동으로 db에 업데이트됨. (@Transactional 선언 필수) 
	} 
	
	@Transactional
	public void deleteByID(int id) {
		boardRepository.deleteById(id);
	}
	

	// 게시글에 댓글쓰기
	@Transactional
	public void replyById(ReplaySaveRequestDto replyRequestDto) { 
		User user =  userRepository.findById(replyRequestDto.getUserId())
						.orElseThrow(()->{
							return new IllegalArgumentException("사용자 id 를 찾을수없습니다.");
						}); // 영속화 완료
		
		Board board =  boardRepository.findById(replyRequestDto.getBoardId())
				.orElseThrow(()->{
					return new IllegalArgumentException("게시글 id 를 찾을수없습니다.");
				}); // 영속화 완료
		
		// .set으로 안쓰고 그냥 아래처럼 바로 replyRepository에 수동 query로 정의해서 사용하면 더 좋다~~
		replyRepository.mSave(replyRequestDto.getUserId(), replyRequestDto.getBoardId(), replyRequestDto.getContent());
		
		// 해당 함수로 종료시(service가 종료될때) 트랜잭션이 종료됨.--> 이때 더티체킹 발생!! -> 자동으로 db에 업데이트됨. (@Transactional 선언 필수) 
	}  
}
