let index = {
		
		init: function() {
			$("#btn-save").on("click", ()=>{	// function() {} 대신 ()=>{} 을 사용하는 이유는 this를 바인딩 하기 위함.
				this.save();
				console.log("save함수 ...");
			});
			$("#btn-update").on("click", ()=>{
				this.update();
				console.log("유저 update함수 ...");
			});
			
			// 스프링 시큐리티 사용 전 코드
//			$("#btn-login").on("click", ()=>{	// function() {} 대신 ()=>{} 을 사용하는 이유는 this를 바인딩 하기 위함.
//				this.login();
//				console.log("login ...");
//			});
		},
		
		save: function() {
				console.log("save함수 ...");
			let data = {
				username: $("#username").val(),
				password: $("#password").val(),
				email: $("#email").val()
			};

			// ajax통신을 이용해서 3개의 데이터를 json으로 변경하는 insert 요청
			// ajax호출시 default가 비동기 호출이다
			// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환됨. 
			$.ajax({
				//회원 가입 수행 요청
				type:"post",
				url:"/auth/joinProc",
				data:JSON.stringify(data),	//http body 데이터이다
				contentType:"application/json; charset=utf-8",	// body데이터가 어떤 타입인지 작성해주는것
				dataType: "json",	// 요청을 했을경우 응답이 왔을때 기본적으로 모든것을 문자열로 받는데
								// 문자열의 타입이 json이라면 javascript로 변경을 해준다
				success: function(res){
					if(res.status === 500) {	// 중복된 아이디 처리
						alert("회원가입이 실패하었습니다");
					}else {
						alert("회원가입이 완료되었습니다");
//						console.log(res);
						location="/";
					}
					
					
				},
				error:function(error){
					alert(JSON.stringify(error));
				}
			});
		}, 
		update: function () {
			console.log("update함수 ...");
			let id = $("#id").val();
			let pw = $("#password").val();
			let em = $("#email").val();
			let username = $("#username").val();
			console.log(id);
			console.log(pw);
			console.log(em);
			console.log(username);

		let data = {
			id: $("#id").val(),
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};

		// ajax통신을 이용해서 3개의 데이터를 json으로 변경하는 insert 요청
		// ajax호출시 default가 비동기 호출이다
		// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환됨. 
		$.ajax({
			//회원 가입 수행 요청
			type: "PUT",
			url: "/user",
			data: JSON.stringify(data),	//http body 데이터이다
			contentType: "application/json; charset=utf-8",	// body데이터가 어떤 타입인지 작성해주는것
			dataType: "json",	// 요청을 했을경우 응답이 왔을때 기본적으로 모든것을 문자열로 받는데
			// 문자열의 타입이 json이라면 javascript로 변경을 해준다
			success: function (res) {
				alert("회원수정이 완료되었습니다");
				//					console.log(res);
				location = "/";
			},
			error: function (error) {
				alert(JSON.stringify(error));
			}
		});
//			}).success: (function (res){
//				// 성공시 이쪽 코드
//				alert(res+"성공");
//				
//			}).fail(function (error) {
//				// 실패시 이쪽 코드
//				alert("실패메세지");
//				console.log(JSON.stringify(error));
//
//			});	
			
			// console.log(data);
		}
		// 스프링 시큐리티 사용 전 코드
		//,
//		login: function() {
//				console.log("login 함수 ...");
//			let data = {
//				username: $("#username").val(),
//				password: $("#password").val(),
//			};
//
//			// ajax통신을 이용해서 3개의 데이터를 json으로 변경하는 insert 요청
//			// ajax호출시 default가 비동기 호출이다
//			// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환됨. 
//			$.ajax({
//				//회원 가입 수행 요청
//				type:"post",
//				url:"/api/user/login",
//				data:JSON.stringify(data),	//http body 데이터이다
//				contentType:"application/json; charset=utf-8",	// body데이터가 어떤 타입인지 작성해주는것
//				dataType: "json",	// 요청을 했을경우 응답이 왔을때 기본적으로 모든것을 문자열로 받는데
//								// 문자열의 타입이 json이라면 javascript로 변경을 해준다
//				success: function(res){
//					alert("로그인이 완료되었습니다");
//					location="/";
//				},
//				error:function(error){
//					alert(JSON.stringify(error));
//				}
//			});
//			}).success: (function (res){
//				// 성공시 이쪽 코드
//				alert(res+"성공");
//				
//			}).fail(function (error) {
//				// 실패시 이쪽 코드
//				alert("실패메세지");
//				console.log(JSON.stringify(error));
//
//			});	
			
			// console.log(data);
//		}
	}
index.init();
