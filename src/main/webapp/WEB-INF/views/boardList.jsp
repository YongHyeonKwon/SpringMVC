<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="jumbotron">
			<h1>SpringMVC01</h1>
			<p>Spring을 활용한 게시판 만들기~</p>
		</div>

		<div class="card">
			<div class="card-header">게시판</div>

			<div class="card-body">

				<table class="table table-hover">

					<thead>
					
						<tr>
						
							<td colspan="4">
								<input type="text" id="search" class="form-control">
							</td>
							<td>
								<button id="searchBtn" class="btn btn-info" >검색</button>
							</td>
							
						
						</tr>
						
					
						<tr>
							<td>글 번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="board" items="${list}">
							<tr>
								<td>${board.idx}</td>
								<td><a href="detail?idx=${board.idx}">${board.title}</a></td>
								<td>${board.writer}</td>
								<td>${board.indate}</td>
								<td>${board.count}</td>
								<td><a href="delete?idx=${board.idx}">삭제</a></td>
							</tr>
						</c:forEach>

					</tbody>

				</table>

				<a href="goWrite" class="btn btn-success">작성하러가기</a>

				<button id="chartBtn" class="btn btn-warning">순위보기</button>

			</div>
			<div class="card-footer">인공지능 융합 서비스 개발자과정 권용현</div>
		</div>

		<div class="card" id="chartDiv" style="display:none">
			<div class="card-body">
			
			
			
			</div>
		</div>


	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script src="resources/js/list.js"></script>

</body>
</html>
