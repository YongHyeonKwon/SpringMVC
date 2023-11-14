package com.smhrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor
@Data
public class Board {
	// Data Transfer Object(DTO)
	// 계층간 데이터 전송시에 데이터를 담는 용도 
	
	private int idx;
	private String title;
	private String writer;
	private String content;
	private String indate;
	private int count;
	
	
}
