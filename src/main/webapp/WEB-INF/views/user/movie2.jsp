<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
	<h1>하루 전 리스트만 볼수있음.</h1>
	 <form action="/user/movie2" method="post">
		<input type="date" name="date" id="date"> 
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
<script>
var now = new Date();
var date2 = new Date(now.setDate(now.getDate() - 1));	// 어제

document.getElementById('date' ).setAttribute('max', formatDate(date2));

  function formatDate(date2) {

    var d = new Date(date2),

      month = '' + (d.getMonth() + 1),
      day = '' + d.getDate(),
      year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    return [year, month, day].join('-');

  }
</script>

<%@include file="../layout/footer.jsp"%>
