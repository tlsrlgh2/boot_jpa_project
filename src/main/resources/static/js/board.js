let index = {
		
		init: function() {
			$("#writesave").on("click", ()=>{	
				this.writesave();
				console.log("save함수 ...");
			});
			$("#updatesave").on("click", () => {
				this.updatesave();
				console.log("updatesave ...");
			});
			$("#boarddelete").on("click", () => {
				this.boarddelete();
				console.log("boarddelete ...");
			});
			$("#updateform").on("click", () => {
				this.updateform();
				console.log("updateform ...");
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
				url: "/board/save",
				data:JSON.stringify(data),
				contentType : "application/json; charset=UTF-8",
				
				success: function(res){
					alert("글쓰기가 완료되었습니다");
					location="/";
				},
				error:function(error){
					alert(error);
				}
			});
		},
		updatesave: function () {
			console.log("updatesave ...");
			let data = {
				id: $("#updateid").val(),
				title: $("#title").val(),
				content: $("#content").val()
			};
			console.log(data);

			$.ajax({

				type: "put",
				url: "/board/updatesave",
				data: JSON.stringify(data),
				contentType: "application/json; charset=UTF-8",

				success: function (res) {
					alert("글수정이 완료 되었습니다");
					location = "/board/list";
				},
				error: function (error) {
					alert(error);
				}
			});
		},
		boarddelete: function() {
				console.log("boarddelete ...");
			let id = $("#boarddetail_id").val()
			
			console.log(id);
			
			$.ajax({
				
				type:"delete",
				url: "/board/delete/"+id,
				data: JSON.stringify(id),
				contentType : "application/json; charset=UTF-8",
				
				success: function(res){
					alert("게시글이 삭제되었습니다");
					location="/board/list";
				},
				error:function(error){
					alert(error);
				}
			});
		},
		updateform: function () {
			let id = $("#boarddetail_id").val()
			location = "/board/detail/"+id +"/update";
		}
	}

index.init();