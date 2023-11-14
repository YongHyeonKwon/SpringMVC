package com.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.entity.Board;

@Mapper // scan 할 때, 알아볼 수 있게끔 어노테이션 달아주기!
public interface BoardMapper {

	// DBCP(DataBase Connection pool)
	// 미리 정해진 개수만큼만 Connection을 생성 
	// 기능 실행시 빌려갔다가 종료 후 반납하는 구조 
	
	// 달라진 점 
	// 1. 추상 메소드만으로 정의 
	// 2. interface로 작성 
	// 3. xml 파일과 interface 파일의 이름이 같아야함
	
	// 추상 메소드
	public List<Board> list();
	// selectList("list")
	
	
	public int write( Board board );
	
	
	public int delete ( int idx );
	
	
	public Board detail( int idx);
	
	
	public int update( Board board );
	
	
	public int count ( int idx );
	
	
	public List<Board> search( String search );
	
	
	public List<Board> chart();
	
}
