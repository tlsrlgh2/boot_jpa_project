<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../layout/header.jsp"%>
<div class="container">
	
	<form action="/user/movie2" method="post">
		<input type="date" name="date" id="date" max="2022-03-22"> 
		<input type="submit" value="선택" id="dateclick">
	</form>
</div>
<h1>${dataArr }</h1>
<script src="/js/user.js">
	
</script>
<%@include file="../layout/footer.jsp"%>
