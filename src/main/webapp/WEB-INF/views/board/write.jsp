<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
	<input type="text" id="title">
	<br><br>
	<textarea rows="3" cols="50" id="content"></textarea>

	<input type="button" value="확인" id="writesave">
	<input type="button" value="확인" id="writesave2">
	<input type="text" value="" id="test12">
	
</div>

<script src="/js/board.js">
/* 

	$("#writesave").on("click",function () {
			let data = {
				title: $("#title").val(),
				content: $("#content").val()
				}
			console.log(data);

			$.ajax({
				type: "post",
				url: "/board/test",
				data: JSON.stringify(data),
				contentType: "application/json; charset=utf-8",
				dataType: "data",

				success: function (res) {
					alert("댓글 작성이 완료되었습니다");
					location = `/board/${data.boardid}`;
				},
				error: function (error) {
					alert(JSON.stringify(error));
				}
			});
		});
 */
</script>

<%@include file="../layout/footer.jsp"%>
</body>
</html>