// 비동기 방식으로 요청해서, 데이터 받아오기 

const btn = $("#btn");

btn.on( "click", loadData);

function loadData(){
	
	// 비동기 통신 요청 
	$.ajax({
		url : "load",
		type : "get",
		success : function(res){
			
			console.log(res[1].title)
			
		}
	});
	
	
}

