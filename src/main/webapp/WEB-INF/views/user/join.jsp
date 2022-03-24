<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<table class="table">
			<tr>
				<th>*아이디</th>
				<td>
					<input type="text" id="userid" value="qwe">
				</td>
			</tr>
			<tr>
				<th>*비밀번호</th>
				<td><input type="password" id="password" value="qwe"></td>
			</tr>
			<tr>
				<th>*이메일</th>
				<td>
					<input type="email" id="email" value="qwe"> 
				</td>
			</tr>
			<tr>
				<th>*전화번호</th>
				<td><input type="text" id="phone" value="qwe"></td>
			</tr>
			<tr>
				<th>*주소</th>
				<td>
					<input type="text" id="postcode" placeholder="우편번호">
					<input type="button" class="btn btn-info" onclick="execDaumPostcode()" value="우편번호 찾기">
					<br>
					<input type="text" id="address" placeholder="주소" value="qwe">
					<br>
					<input type="text" id="detailAddress" placeholder="상세주소">
					<input type="text" id="extraAddress" placeholder="참고항목">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<p id="msg">*은 필수 입력 사항입니다.</p>
				</td>
			</tr>
		</table>
	</form>
	<button class="btn btn-info" id="joinuser">회원가입 완료</button>
</div>

<script src="/js/user.js">
	
</script>


<%@include file="../layout/footer.jsp"%>
