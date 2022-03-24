<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@include file="../layout/header.jsp"%>
<div class="container">
   <table class="table">
    <thead>
      <tr>
        <th>주소</th>
        <th>이름</th>
      </tr>
    </thead>
   <tbody>
  	<c:forEach var="data" items="${data}">
	  <tr>
        <td>${data.address }</td>
        <td>${data.centerName }</td>
      </tr>
	</c:forEach>
	</tbody>
  </table>
</div>
<%@include file="../layout/footer.jsp"%>
