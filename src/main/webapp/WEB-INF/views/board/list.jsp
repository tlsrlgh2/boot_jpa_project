<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@include file="../layout/header.jsp" %>

   <h1> ${boardlist}</h1>
<div class="container">
  <table class="table">
    <thead>
      <tr>
        <th>게시글 번호 </th>
        <th>게시글 제목</th>
        <th>상세내용</th>
        <th>작성 날짜</th>
      </tr>
    </thead>
    <%-- <c:forEach var="boardlist" items="${boardlist}">
    <tbody>
      <tr>
        <td>${boardlist.id }</td>
        <td>${boardlist.title }</td>
        <td><a href="/board/detail/${boardlist.id}">상세보기</a></td>
        <td>${boardlist.createDate}</td>
      </tr>
    </tbody>
    </c:forEach> --%>
  </table>
</div>

<%-- <ul class="pagination justify-content-center">
	<c:choose>
		<c:when test="${boardlist.first }">
		<li class="page-item disabled"><a class="page-link" href="?page=${boardlist.number-1}">Previous</a></li>
 
		</c:when>
		<c:otherwise>
		<li class="page-item"><a class="page-link" href="?page=${boardlist.number-1}">Previous</a></li>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${boardlist.last }">
		<li class="page-item disabled"><a class="page-link" href="?page=${boardlist.number+1}">Next</a></li>
 
		</c:when>
		<c:otherwise>
		<li class="page-item"><a class="page-link" href="?page=${boardlist.number+1}">Next</a></li>
		</c:otherwise>
	</c:choose>
</ul> --%>


<%@include file="../layout/footer.jsp" %>