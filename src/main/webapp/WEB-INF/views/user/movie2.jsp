<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../layout/header.jsp"%>
<div class="container">
	
	<form action="/user/movie2" method="post">
		<input type="date" name="date" id="date" max="2022-03-22"> 
		<input type="submit" value="선택" id="dateclick">
	</form>
	
	<table class="table">
    <thead>
      <tr>
        <th>영화 제목</th>
        <th>랭킹</th>
        <th>개봉일자</th>
        <th>오늘 관람객</th>
        <th>총 누적 관람객</th>
      </tr>
    </thead>
   <tbody>
  	<c:forEach var="dataArr" items="${dataArr}">
	  <tr>
        <td>${dataArr.movieNm }</td>
        <td>${dataArr.rank }</td>
        <td>${dataArr.openDt }</td>
        <td>${dataArr.audiCnt }</td>
        <td>${dataArr.audiAcc }</td>
      </tr>
	</c:forEach>
	</tbody>
  </table>
</div>
<script src="/js/user.js">
	
</script>
<%@include file="../layout/footer.jsp"%>
