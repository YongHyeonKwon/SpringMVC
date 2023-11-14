-- 게시글을 저장할 테이블 생성 
-- 글 번호, 제목, 작성자, 내용, 작성일, 조회수 
create table BOARD
(
	idx int not null auto_increment,
	title varchar(100) not null,
	writer varchar(50) not null,
	content varchar(1000) not null,
	indate datetime default now(),
	count int default 0, 
	
	primary key(idx)
	
);
-- 실행 : 블록 지정 후, art + x

insert into BOARD(title, writer, content)
values( 'Spring 게시판 만들기 01', '권용현', '스프링을 활용한 게시판 만들기' );

insert into BOARD(title, writer, content)
values( 'Spring 게시판 만들기 02', '관리자', '스프링을 활용한 게시판 만들기' );

insert into BOARD(title, writer, content)
values( 'Spring 게시판 만들기 03', '안현진', '스프링을 활용한 게시판 만들기' );


