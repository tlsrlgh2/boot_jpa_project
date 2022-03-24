<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
	<div>
		<label for="title" >글 번호 : ${updateform.id}</label>
		<input type="hidden" id="updateid" value="${updateform.id}">
		<br><br>
	</div>
	<div class="form-group">
		<label for="title">title:</label> <input type="text" class="form-control" id="title" value="${updateform.title}">
	</div>
	<div class="form-group">
		<label for="content">content:</label>
		<textarea class="form-control summernote" rows="5" id="content">${updateform.content}</textarea>
	</div>
	<input type="button" class="btn btn-info" value="수정 완료" id="updatesave">
	<input type="button" class="btn btn-info" value="이전 페이지로 이동" onclick="history.go(-1)">
	
</div>

<script>
	$('.summernote').summernote({
		tabsize : 2,
		height : 100
	});
</script>

<script src="/js/board.js">
	
</script>

<%@include file="../layout/footer.jsp"%>
</body>
</html>