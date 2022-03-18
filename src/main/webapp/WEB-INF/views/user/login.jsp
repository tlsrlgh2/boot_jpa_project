<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<div class="container">
        <form action="/user/login" method="post">
                <input type="text" name="userid" id="userid"  placeholder="아이디"><br>
                <input type="password" name="password" id="password" placeholder="비밀번호">
                <button class="btn btn-info" id="userlogin">로그인</button>
        </form>
        
        <a href="/user/join">회원가입</a>&nbsp; | &nbsp;<a class="joinBox" onclick="find_id_pw()" id="find_id_pw">ID/PW찾기</a>
</div>
<%@include file="../layout/footer.jsp"%>
