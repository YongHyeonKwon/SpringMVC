package com.smhrd.web;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smhrd.entity.Board;
import com.smhrd.mapper.BoardMapper;

// Controller(POJO) 새성 
// 1. scan 하고 있는 폴더 내에서 Class 파일 만들기 
// 2. @Controller 어노테이션을 통해, POJO임을 알려주기 
@Controller
public class BoardController {

	@Autowired // Spring 메모리에 있는 bean 중에서, 집어넣어줄 수 있는 객체를 자동으로 주입
	private BoardMapper boardMapper;

	// 어떤 요청을 받았을 때, 무슨 일을 할지?
	// http://localhost:8083/web/list
	@RequestMapping("/list") // URLMAPPING 지정
	public String list( Model model ) {
		// 1. 파라미터 수집 
		// 2. 기능 실행 --> DB에 저장된 모든 게시글 가져오기 
		List<Board> list = boardMapper.list();
		
		// 객체바인딩 
		// 필요한 객체가 있으면, 매개변수에 선언해주기 --> Spring이 자동으로 넣어줌 
		// request.setAttribute("list", list);
		// Model : 다이어트한 request, request에서 객체 바인딩에 필요한 기능만 남김 
		// 		   객체 바인딩 시, request 영역에 저장됨
		model.addAttribute("list", list);
		
		// 3. View 선택 --> boardList.jsp로 forward 이동
		// RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/boardList.jsp");
		// rd.forward(request, response)
		// 이동하고자 하는 View를 골라서 리턴
		return "boardList"; // 이동하고 싶은 jsp 파일의 이름만!
	}
	
	@RequestMapping("/goWrite")
	public String goWrite() {
		// 1. 파라미터 수집 
		// 2. 기능 실행 
		// 3. View 선택
		return "boardWrite";
	}
	
	
	@RequestMapping("/write")
	public String write( Board board ) {
		
//		// 1. 파라미터 수집 
//		request.setCharacterEncoding("UTF-8");
//		
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
//		
//		Board board = new Board();
//		board.setTitle(title);
//		board.setWriter(writer);
//		board.setContent(content);
		
		// Spring 달라진점 : 메소드 매개변수에 수집할 변수만 선언해주면 자동으로 수집과정이 일어난다.
		// 1) 여러 개의 데이터가 전송되었을 때
		// 조건 : Table 컬럼 이름 == DTO 필드 변수 명 == input name 
		//		 기본생성자가 있어야만 함.
		
		// 2) 각각의 데이터를 따로 받아올 때 
		// 조건 : 매개변수에 선언한 변수명 == input name
		// int 타입으로 형변환도 자동으로 일어난다. 
		// 만약에 input name과 다른 이름의 변수로 수집하고 싶다면 @RequestParam("name") 을 붙이면 된다.
		
		
		// 2. 기능 실행 - 수집한 데이터를 Board 테이블에 저장
		int cnt = boardMapper.write(board);
		
		
		// 3. view 선택
		// Controller --> Controller로 다시 요청을 보내는 상황 
		// redirect 방식을 사용해야함 --> url mapping 앞에 redirect:/를 붙이면 됨
		return "redirect:/list";
		
	}
	
	
	@RequestMapping("/delete")
	public String delete( int idx ) {
		// 1. 파라미터 수집 
		
		// 2. 기능 실행 - idx와 같은 글번호를 가진 게시글 데이터를 삭제 
		int cnt = boardMapper.delete(idx);
		
		// 3. View 선택
		return "redirect:/list";
	}
	
	@RequestMapping("/detail")
	public String detail( int idx, Model model ) {
		// 1. 파라미터 수집 
		// 2. 기능 실행 - idx와 같은 글번호를 가진 게시글 조회
		Board board = boardMapper.detail(idx);
		
		model.addAttribute("board", board);
		// 3. View 선택
		// Controller --> JSP : forward 방식 
		return "boardDetail";
	}
	
	// @GetMapping("/URLMapping") --> GET 방식의 요청만 받겠다.
	// @PostMapping("/URLMapping") --> Post방식의 요청만 받겠다.
	// 400 --> 수집해야하는 데이터가 제대로 보내지지 않은 경우
	// 404 --> Not Found : URLMapping이 틀렸거나, jsp 파일 이름이 틀린 경우
	// 405 --> 허용되지 않은 접근 : 지정해둔 방식과 다른 방식으로 요청이 이루어진 경우 
	// 500
	@RequestMapping("/update")
	public String update( Board board ) {
		// 1. 파라미터 수집 
		// 2. 기능 실행 - 사용자가 입력한 데이터 대로 DB에 저장된 글을 수정 
			boardMapper.update(board);
		// 3. View 선택
		return "redirect:/list";
		
		
		
		
	}
	
	
	
	
}

