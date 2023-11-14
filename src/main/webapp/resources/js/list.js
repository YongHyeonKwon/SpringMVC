// 1. 검색버튼 클릭시 
$('#searchBtn').on( " click", boardSearch);

function boardSearch(){
	
//  1) input 태그에 작성된 내용을 가지고, 비동기 요청 
	$.ajax({
		url: "search",
		type : "get",
		data : {
			"search" : $("#search").val()
		},
		success : updateTable,
		
	});
	
//  2) 파라미터 수집, 해당 검색어를 포함하는 게시글만을 조회해서 결과 응답
}


function updateTable(res){
//  3) 태아불 내용 수정 
	console.log(res);
	
	// 1. 테이블 내용 초기화
	const tbody = $('tbody');
	
	// .html(): 해당 태그 안에 있는 코드 리턴
	// .html("text") : 해당 태그 안에 있는 코드 덮어쓰기
	tbody.html("");
	
	// 2. 받아온 JSON 데이터를 이용해서, 테이블 내용 구성
	for(var i = 0; i < res.length; i++){
		let board = res[i];
		
		// 문자열 포맷팅
		
		// num1 = 5, num2 = 10
		
		// num1 + "*" + num2 + "=" + num1*num2
		
		// `${num1}*10=50`
		
		//${변수명} : 백틱 내에서, 해당자리에 변수값을 집어넣기 위해서 사용 
		let tr = `
			<tr>
				<td>${board.idx}</td>
				<td><a href="detail?idx=${board.idx}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.indate}</td>
				<td>${board.count}</td>
				<td><a href="delete?idx=${board.idx}">삭제</a></td>
			</tr>
		`;
		
		// .append("text") : 해당 태그 안에, 코드 추가
		tbody.append(tr);
	}
	
	
	
}


// chart.js 라이브러리 이용, 데이터 시각

$("#chartBtn").on( "click", open );

function open(){
	
	const div = $("#chartDiv");
	
	// .css("속성명"); --> 해당 속성값 리턴
	// .css("속성명", "속성값"); --> 해당 속성의 값을 수정
	// 만약 div가 보이지 않는 상태 --> block
	// 			보이는 상태 --> none
	
	div.slideToggle();
	
	// 1) 차트를 그리기 위한 데이터를 가져오기(비동기 통신)

		$.ajax({
			url : "chart",
			type : "get",
			success : drawChart
			
		});
	
	
	function drawChart(res){
	// 2) 만약 데이터를 잘 가져왔다면, 차트 그려주기
		console.log(res);
	
		const div = $("#chartDiv").children("div");
	
		div.html(""); // 차트를 그리기 위해 초기화
		
		div.append("<canvas id='myChart'></canvas>") // 새로운 canvas 태그 생성
		
		// JSON 데이터를 이용할 수 있게끔 옮겨닮기
		
		let writer = []; // labels, x축
		let count = []; // data, y축
		
		for(let i =0; i < res.length; i++){
			
			writer.push( res[i].writer );
			count.push( res[i].count)
		}
		
		
		
		// chat.js를 이용한 시각화
		const ctx = document.getElementById('myChart');

	  new Chart(ctx, {
	    type: 'bar',
	    data: {
	      labels: writer,
	      datasets: [{
	        label: 'writer', // 차트의 의미
	        data: count, // 차트로 표현할 데이터
	        borderWidth: 1,
			backgroundColor : 'gray' // 배경색 지정
	      }]
	    },
	    options: {
	      scales: {
	        y: {
	          beginAtZero: true
	        }
	      }
	    }
	  });
		
		
		
		
		
	}
	
	
	
	
	
		
}









