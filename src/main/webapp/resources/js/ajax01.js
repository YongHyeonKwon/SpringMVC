// 1. HTML DOM 객체 가져오기(JQuery ver)
const reqBtn = $("#reqBtn");

// 2. 이벤트 달아주기 
// .on("이벤트 종류", function)
reqBtn.on( "click", function(){
	
	// 3. 이벤트 내용 정의 
	console.log("클릭됨!");
	
	// 비동기 통신을 사용해서 요청하기 
	$.ajax({
		// http://localhost:8083/web/ajax01 여기로 가는거.
		url : "ajax01", // 요청 URL / URLMapping
		type : "get", // 요청 방식(GET, POST)
		data :{
			// key : value
			// 보내고 싶은 데이터
			"num1" : 20,
			"num2" : 50
		},
		success : function(res){
			// 요청-응답이 성공했을 때, 실행되는 함수
			// res : 응답받은 데이터가 담기는 변수
			console.log(res)
		},
		error : function(e){
			// 요청-응답이 실패했을 때, 실행되는 함수
		}
		
	});
		});
	// ===========================================================================================
	
	// 1. 사용자가 input태그에 두 수를 입력 
const calBtn = $( "#calBtn" );
	
	// 2. "계산하기" 버튼 클릭시 
calBtn.on( "click", function() { 

//			1) 비동기 통신을 이용해서, 두 수를 서버로 전송
// 			   ${"num1"}.val();
// 			   document.getElementByID("num1").value
			$.ajax({
				url: "multi",
				type: "get",
				data : {
					"num1" : $("#num1").val(),
					"num2" : $("#num2").val()
				},
				success : function(res){
					console.log(res);
				},
				error : function(e){
				
				}
			});

//			2) 서버에서 두 수를 수집하고, 두 수의 곱을 계산해서 응답

//			3) 응답받은 데이터를 javascript의 console창에 출력	
	
	

	
	
	
	
});	
	
	
	
	
	
	
	

