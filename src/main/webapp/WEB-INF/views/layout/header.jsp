<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
<!DOCTYPE html>
<html lang="en">
<head>
<title>solo project</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}
</style>
</head>
<body>

	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1>My First solo project</h1>
		<p>혼자 완성하는 프로젝트</p>
	</div>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="/">홈으로</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<c:choose>
			<c:when test="${empty userid}">
				<div class="collapse navbar-collapse" id="collapsibleNavbar">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/user/login">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="/board/write">글쓰기</a></li>
						<li class="nav-item"><a class="nav-link" href="/board/list">게시글 보기</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/hospital">보건 센터 보기</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/hospital2">보건 센터 보기(비동기식)</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/movie2">영화 리스트보기</a></li>
					</ul>
				</div>
			</c:when>
				
			<c:otherwise>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/user/modify">${userid}님 안녕하세요.</a></li>
					<li class="nav-item"><a class="nav-link" href="/board/write">글쓰기</a></li>
					<li class="nav-item"><a class="nav-link" href="/board/list">게시글 보기</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/hospital">보건 센터 보기</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/hospital2">보건 센터 보기(비동기식)</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/movie2">영화 리스트보기</a></li>
					<li class="nav-item"><a class="nav-link" href="/user/logout">로그아웃</a></li>
				</ul>
			</c:otherwise>
		</c:choose>
		
	</nav>
	<br>
<script src="/js/board.js">

</script>