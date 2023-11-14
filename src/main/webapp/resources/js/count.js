
// 1. 사용자가 해당 페이지에 들어왔을 때 
$(document).ready( function(){
	
	
//	 1) 비동기 방식을 이용해서 요청 보내기 
$.ajax({
				url: "count",
				type: "get",
				data : {
					// 태그 이름[속성명=속성값]
					// textarea[rows=10]
					"idx" : $("input[name=idx]").val()
				},
				success : function(res){
					
					if( res > 0 ){
						console.log("조회수 올리기 성공!!")
					}else{
						console.log("조회수 올리기 실패ㅠㅠ")
					}
					
				}
			});
//   2) 해당 게시글의 조회수를 1 올리기 
//      조회수 올리기 성공 실패 여부를 응답 

//   3) 만약 성공했다면, js console에 "조회수 올리기 성공!" 출력 
// 			실패했다면, 			 :"조회수 올리기 실패!" 출력






	
	
});