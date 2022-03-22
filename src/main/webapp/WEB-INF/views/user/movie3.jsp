<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../layout/header.jsp"%>


<div class="container">
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


<%@include file="../layout/footer.jsp"%>
