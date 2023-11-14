package com.smhrd.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Board;

@RestController
public class AjaxRestController {
	
	@RequestMapping("/ajax01")
	public String ajax01( int num1, int num2 ) {
		// 1. 파라미터 수집 
		// 2. 기능 실행 
		System.out.println("요청이 들어옴! : " + (num1 + num2));
		// 3. View 선택
		// @ResponseBody 어노테이션을 붙이면 
		// 	 리펀한 문자열을 그대로 응답
		return "ajax01"; 
	}
	
	
	@RequestMapping("/multi")
	public @ResponseBody String multi( int num1, int num2 ) {
		// 1. 파라미터 수집 
		// 2. 기능 실행 
		// 3. 데이터 응답
		return num1 * num2 + ""; 
	}

	
	@RequestMapping("/load")
	public ArrayList<Board> load() {
		// 1. 파라미터 수집 
        // 2. 기능 실행 
		// 임시 데이터 생성
		ArrayList<Board> list = new ArrayList<Board>();
		
		Board board = new Board();
		board.setTitle("비동기 통신");
		board.setWriter("권용현");
		
		list.add(board);
		
		Board board2 = new Board();
		board2.setTitle("데이터 응답하기");
		board2.setWriter("관리자");
		
		list.add(board2);
		
		Board board3 = new Board();
		board3.setTitle("게시판 만들기");
		board3.setWriter("관리자");
		
		list.add(board3);
		
		
		// 3. 데이터 응답
		// ArrayList와 같은 java의 객체 리턴
		// java Object --> 특정 데이터 양식으로 포멧
		
		// CSV -> ,를 이용해 데이터를 구분하는 양식
		// 		  용량이 작음, 가독성이 매우 안좋음 
		
		// XML -> 태그와 속성을 이용해서 데이터를 구분하는 양식
		//        가독성이 좋음, 데이터를 저장하기 위한 용량이 많이 필요 
		
		// JSON -> JAVAScript Object Notation
		// 		   javascript 객체 형식으로 데이터를 정리
		//         { "key" : "value", ... }
		//         [ {}, {}, {}, .... ]
		// 		   호환성이 좋음
		
		// Gson, jackson-databind 라이브러리를 이용해서 
		// 1. Gson
		// JSON --> JavaObject
		// 우리가 원하는 형태의 JSON 객체를 만들 때
		
		// 2. jackson-databind
		// JAVAObect <---> JSON
		// 변환하고 싶은 값 리턴 --> 값을 JSON으로 변환 --> 응답
		
		// JAVAObect <---> JSON
		return list;
	}
	
	
	
	
	
	
	
	
	
	
}


