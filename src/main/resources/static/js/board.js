let index = {
		
		init: function() {
			$("#writesave").on("click", ()=>{	
				this.writesave();
				console.log("save함수 ...");
			});
			$("#writesave2").on("click", ()=>{	
				this.writesave2();
				console.log("save함수 ...");
			});
		},
		
		writesave: function() {
				console.log("save함수 ...");
			let data = {
				title: $("#title").val(),
				content: $("#content").val()
			};
			console.log(data);
			
			$.ajax({
				
				type:"post",
				url: "/board/test",
				data:JSON.stringify(data),
				contentType : "application/json; charset=UTF-8",
				dataType: "text",
				
				success: function(res){
					alert("글쓰기가 완료되었습니다");
					location="/";
				},
				error:function(error){
					alert(error);
				}
			});
		},
		writesave2: function() {
				console.log("save함수 ...");
			
			$.ajax({
				
				type:"get",
				url: "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101",
				
				success: function(res){
					console.log(res);
					console.log(res.boxOfficeResult.dailyBoxOfficeList);
//					location="/";
				},
				error:function(error){
					alert(error);
				}
			});
		},
		deleteByid: function() {
			console.log("deleteByid함수 호출 ...");
			var id = $("#id").text();
			console.log("id값 출력"+id);

			$.ajax({
				
				type:"delete",
				url: "/api/board/" + id,
				dataType: "json",
								
				success: function(res){
					alert("삭제가 완료되었습니다");
					location="/";
				},
				error:function(error){
					alert(JSON.stringify(error));
				}
			});
		}, 
		update: function () {
			let id = $("#id").val();
			let id2 = $("#id").text();
			console.log(id);
			console.log(id2);
			
			let data = {
				title: $("#title").val(),
				content: $("#content").val(),
			};

			$.ajax({

				type: "put",
				url: "/api/board/"+id,
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "json",

				success: function (res) {
					alert("글 수정이 완료되었습니다");
					location="/";
				},
				error: function (error) {
					alert(JSON.stringify(error));
				}
			});
		},
		replysave: function() {
			console.log("replysave함수 ...");
			let data = {
				userid: $("#userid").val(),
				boardid: $("#boardid").val(),
				content: $("#reply-content").val()	
			};
			
			console.log(data);
			
			$.ajax({
				
				type:"post",
				url:`/api/board/${data.boardid}/reply`,
				data:JSON.stringify(data),
				contentType:"application/json; charset=utf-8",
				dataType: "json",
								
				success: function(res){
					alert("댓글 작성이 완료되었습니다");
					location=`/board/${data.boardid}`;
				},
				error:function(error){
					alert(JSON.stringify(error));
				}
			});
		},
		replydelete: function(boardid,replyid) {
			console.log("replysave함수 ...");
			let data = {
				userid: $("#userid").val(),
				boardid: $("#boardid").val(),
				content: $("#reply-content").val()	
			};
			
			console.log(data);
			
			$.ajax({
				
				type:"delete",
				url: `/api/board/${boardid}/reply/${replyid}`,
				dataType: "json",
								
				success: function(res){
					alert("댓글 삭제 성공");
					location=`/board/${data.boardid}`;
				},
				error:function(error){
					alert(JSON.stringify(error));
				}
			});
		}
}

index.init();