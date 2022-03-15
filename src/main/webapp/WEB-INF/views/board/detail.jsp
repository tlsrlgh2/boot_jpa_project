<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<div class="container">
	<div class="m_id margin-bottom:20">
		<span>글번호 : ${boarddetail.id}</span>
	</div>
	<div class="card">
		<div class="card-body">
			<h4 class="card-title">${boarddetail.title}</h4>
			<p class="card-text">${boarddetail.content}</p>
			<input type="hidden" id="boarddetail_id" value="${boarddetail.id}">
			
			<input type="button" class="btn btn-info" value="수정" id="updateform">
			<input type="button" class="btn btn-info" value="삭제" id="boarddelete">
			<input type="button" class="btn btn-info" onclick="history.go(-1)" value="이전으로 가기">
		</div>
	</div>
</div>
<script src="/js/board.js">

</script>

<%@include file="../layout/footer.jsp"%>