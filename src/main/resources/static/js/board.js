let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
				this.save();
			});
			$("#btn-update").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
				this.update();
			});
			$("#btn-delete").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
				this.delete();
			});
			$("#btn-reply-save").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
				this.replySave();
			});
			 
		},

		/* 게시글 등록 */
		save: function(){
			//alert('user의 save함수 호출됨');
			let data = {
					title: $("#title").val(),
					content: $("#content").val()
			};
			
			$.ajax({ 
				type: "POST",
				url: "/api/board",
				data: JSON.stringify(data), // http body데이터.. 위에 save:function()에서 선언한 변수 data
				contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
				dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
			}).done(function(resp){ // 성공
				if(resp.status === 500){
					alert("글쓰기에 실패하였습니다.");
				}else{
					alert("글쓰기가 완료되었습니다.");
					location.href = "/";
				} 
			}).fail(function(error){ // 실패
				alert(JSON.stringify(error));
			}); 
		},
		
		delete: function(){
			let id = $("#id").text();
			$.ajax({ 
				type: "DELETE",
				url: "/api/board/" + id,
				dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
			}).done(function(resp){ // 성공
				if(resp.status === 500){
					alert("글쓰기에 실패하였습니다.");
				}else{
					alert("글쓰기가 완료되었습니다.");
					location.href = "/";
				} 
			}).fail(function(error){ // 실패
				alert(JSON.stringify(error));
			}); 
		},
		
		update: function(){
			let id = $("#id").val();
			let data = {
					title: $("#title").val(),
					content: $("#content").val()
			};
			
			$.ajax({ 
				type: "PUT",
				url: "/api/board/" + id,
				data: JSON.stringify(data), // http body데이터.. 위에 save:function()에서 선언한 변수 data
				contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
				dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
			}).done(function(resp){ // 성공
				if(resp.status === 500){
					alert("글 수정에 실패하였습니다.");
				}else{
					alert("글 수정이 완료되었습니다.");
					location.href = "/";
				} 
			}).fail(function(error){ // 실패
				alert(JSON.stringify(error));
			}); 
			
		},
		
		replySave: function(){
			let data = {
					userId: $("#userId").val(),
					boardId: $("#boardId").val(),
					content: $("#reply-content").val()
			};
			
			$.ajax({ 
				type: "POST",
				url: `/api/board/${data.boardId}/reply`,
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json"
			}).done(function(resp){// 성공
				if(resp.status === 500){
					alert("댓글작성이 실패하였습니다.");
				}else{ 
					alert("댓글작성이 완료되었습니다.");
					location.href = `/board/${data.boardId}`;
				} 
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
}

index.init();