<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@include file="../layout/header.jsp"%>
<div class="container">
   <button id="selectbtn">조회하기</button>
	
	<div id="content">
		<table class="table">
			<thead>
				<tr>
					<td>주소</td>
					<td>병원이름</td>
					<td>병동이름</td>
				</tr>
			</thead>
			<tbody id="content2">
			
			</tbody>
		</table>
	</div>
</div>

<script src="/js/boardjs.js">

</script>
<%@include file="../layout/footer.jsp"%>
