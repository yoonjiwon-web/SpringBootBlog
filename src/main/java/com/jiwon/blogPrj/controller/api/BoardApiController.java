package com.jiwon.blogPrj.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jiwon.blogPrj.conf.auth.PrincipalDetail;
import com.jiwon.blogPrj.dto.ReplaySaveRequestDto;
import com.jiwon.blogPrj.dto.ResponseDto;
import com.jiwon.blogPrj.model.Board;
import com.jiwon.blogPrj.model.Reply;
import com.jiwon.blogPrj.service.BoardService;

@RestController
public class BoardApiController {
 
	@Autowired
	private BoardService boardService;
 
	// 
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
		System.out.print("save 호출");
		boardService.Saveform(board, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 1이 들어오면 OK
	}
	
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id){
		System.out.print("deleteById 호출");
		boardService.deleteByID(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 1이 들어오면 OK
	}
	
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> updateById(@PathVariable int id, @RequestBody Board board){
		System.out.print("updateById 호출");
		boardService.updateById(id, board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 1이 들어오면 OK
	}
	
	// 데이터를 받을때는 Controller에서 dto를 만들어서 받는게 좋음.
	@PostMapping("/api/board/{boardId}/reply")
	public ResponseDto<Integer> reply(@RequestBody ReplaySaveRequestDto replyDto) {
		System.out.print("reply 호출"); 
		boardService.replyById(replyDto); // js에서 data값 (userId, boardId, reply-content) 가져와서 dto에 넣은 값 처리
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); // 1이 들어오면 OK
	}
}
