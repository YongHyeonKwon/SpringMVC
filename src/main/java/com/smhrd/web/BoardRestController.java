package com.smhrd.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;

@RestController // 비동기 방식 요청만을 처리하는 Controller 라는 것을 명시
public class BoardRestController { // 메소드에 @ResponseBody를 생략 가능
	
		@Autowired
		private BoardMapper boardMapper;
		
		@RequestMapping("/count") // URLMAPPING 지정
		public String count( int idx ) {
			// 1. 파라미터 수집
			// 2. 기능 실행 - 특정 하나의 게시글의 조회수를 1 올리는
			int cnt = boardMapper.count(idx);
			// 3. 데이터 응답
			return cnt + "";
		}
	
	
		@RequestMapping("/search")
		public List<Board> search( String search ) {
			// 1. 파라미터 수집 
			// 2. 기능 실행 
			List<Board> list = boardMapper.search(search);
			// 3. 데이터 응답 
			return list;
		}
	
	
		@RequestMapping("/chart")
		public List<Board> chart() {
			// 1. 파라미터 수집 
			// 2. 기능 실행
			List<Board> list = boardMapper.chart();
			
			// 3. 데이터 응답
			return list;
			
		}
	
	
}
