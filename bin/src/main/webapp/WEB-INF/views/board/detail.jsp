<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<div class="container">
	<div class="m_id margin-bottom:20">
		<span>글번호 : ${boarddetail.id}</span>
		<span>작성자 : ${boarddetail.user.userid}</span>
	</div>
	<div class="card">
		<div class="card-header">
			<h4 class="card-title">제목 :  ${boarddetail.title}</h4>
		</div>
		<div class="card-body">
			<p class="card-text">${boarddetail.content}</p>
			<input type="hidden" id="boarddetail_id" value="${boarddetail.id}">
			
			<input type="button" class="btn btn-info" value="수정" id="updateform">
			<input type="button" class="btn btn-info" value="삭제" id="boarddelete">
			<input type="button" class="btn btn-info" onclick="history.go(-1)" value="이전으로 가기">
		</div>
		<div class="card-footer">
			<p class="card-text">댓글 작성</p>
			<form>
				<input type="hidden" name="boardid" id="boardid" value="${boarddetail.id}">
				<input type="hidden" name="writerid" id="writerid" value="${boarddetail.user.user_count}">
				<input type="text" name="content" id="content">
				<input type="button" id="replychk" value="작성 완료">
			</form>
			<%-- <div class="card-header">댓글리스트</div>
			<ul id="reply--box" class="list-group">
				<c:forEach var="reply" items="${reply}">
						<div>${reply.content}</div>
						<div class="d-flex ">
						</div>
				</c:forEach>
			</ul> --%>
	</div>
		</div>
	</div>
</div>
<script src="/js/boardjs.js">

</script>

<%@include file="../layout/footer.jsp"%>