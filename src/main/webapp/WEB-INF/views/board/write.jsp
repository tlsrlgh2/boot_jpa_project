<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
	<div class="form-group">
		<label for="title">title:</label> <input type="text" class="form-control" id="title">
	</div>
	<div class="form-group">
		<label for="content">content:</label>
		<textarea class="form-control summernote" rows="5" id="content"></textarea>
	</div>
	<input type="button" value="작성 완료" id="writesave">
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