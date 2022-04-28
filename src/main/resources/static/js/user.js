let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
				this.save();
			});
			/* 전통방식 로그인. 스프링 시큐리티 사용으로 인해 주석처리 */
			/*$("#btn-login").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
				this.login();
			});*/
			$("#btn-update").on("click", ()=>{ // function(){} , ()=>{} this를 바인딩하기 위해서!! 
				this.update();
			});
		},

		/* 회원가입 (스피링 시큐리티 로그인) */
		save: function(){
			//alert('user의 save함수 호출됨');
			let data = {
					username: $("#username").val(),
					password: $("#password").val(),
					email: $("#email").val()
			};
			
			//console.log(data);
			
			// ajax호출시 default가 비동기 호출. 순차적 실행이 아니라, 다같이 진행된다.
			// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!!
			// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환
			$.ajax({ 
				type: "POST",
				url: "/auth/joinProc",
				data: JSON.stringify(data), // http body데이터.. 위에 save:function()에서 선언한 변수 data
				contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
				dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
			}).done(function(resp){ // 성공
				if(resp.status === 500){
					alert("회원가입에 실패하였습니다.");
				}else{
					alert("회원가입이 완료되었습니다.");
					location.href = "/";
				}

			}).fail(function(error){ // 실패
				alert(JSON.stringify(error));
			}); 
			
		},
		
		/* 전통방식 로그인. 스프링 시큐리티 사용으로 인해 주석처리 */
		/*login: function(){
			//alert('user의 save함수 호출됨');
			let data = {
					username: $("#username").val(),
					password: $("#password").val(),
			};
			
			//console.log(data);
			
			// ajax호출시 default가 비동기 호출. 순차적 실행이 아니라, 다같이 진행된다.
			// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!!
			// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환
			$.ajax({ 
				type: "POST",
				url: "/api/user/login",
				data: JSON.stringify(data), // http body데이터.. 위에 save:function()에서 선언한 변수 data
				contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
				dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
			}).done(function(resp){ // 성공
				if(resp.status === 500){
					alert("로그인에 실패하였습니다.");
				}else{
					alert("로그인이 완료되었습니다.");
					location.href = "/";
				}

			}).fail(function(error){ // 실패
				alert(JSON.stringify(error));
			}); 
			
		},*/
		
		update: function(){
			//alert('user의 save함수 호출됨');
			let data = {
					id: $("#id").val(),
					password: $("#password").val(),
					email: $("#email").val()
			}; 
			$.ajax({ 
				type: "PUT",
				url: "/user",
				data: JSON.stringify(data), // http body데이터
				contentType: "application/json; charset=utf-8",// body데이터가 어떤 타입인지(MIME)
				dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
			}).done(function(resp){ // 성공 
				console.log("결과...==============" + data);
				console.log("결과값좀보자....==============" + resp);
				if(resp.status === 500){ 
					alert("회원정보 수정에 실패하였습니다.");
				}else{
					alert("회원정보 수정이 완료되었습니다.");
					location.href = "/";
				} 
			}).fail(function(error){ // 실패
				alert(JSON.stringify(error));
			}); 
			 
			
		},
}

index.init();