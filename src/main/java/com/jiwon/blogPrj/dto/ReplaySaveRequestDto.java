package com.jiwon.blogPrj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplaySaveRequestDto {

	private int userId;
	private int boardId;
	private String content;
	
}
