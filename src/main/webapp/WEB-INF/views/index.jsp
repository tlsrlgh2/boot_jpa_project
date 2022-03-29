<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="layout/header.jsp"%>
<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-4">
      <h3>개발툴 : Eclipse</h3>
      <h3>DB : MySql</h3>
      <br><br>
      <h1>사용 스킬</h1>
      <h3>front-end</h3>
      <h6>bootstrap, JQuery, Ajax</h6>
      <h3>back-end</h3>
      <h6>Java, JPA, Spring Boot</h6>
    </div>
    <div class="col-sm-8">
      <h2>solo 프로젝트 기능</h2>
      <h5>solo 프로젝트 기간  22-03-14 ~ 22-03-29</h5>
      <div>
      	<ul>
      		<li>
      			유저 회원 가입
	      		<ul>
	      			<li>회원 주소 daum api 사용</li>
	      			<li>회원 비밀번호 sha-512 암호화</li>
	      		</ul>
      		</li>	
      		<li>
      			유저 로그인
	      		<ul>
	      			<li>로그인 Intercepter 사용하여 회원 아닐경우 글쓰기 ,글 상세보기 방지</li>
	      			<li>로그인시 header nav변경</li>
	      			<li>회원 이름 클릭시 회원정보 수정 페이지로 이동</li>
	      			<li>회원정보 수정시 데이터 적용</li>
	      		</ul>
      		</li>
      		<li>
      			글쓰기
	      		<ul>
	      			<li>summernote 사용</li>
	      			<li>이미지, 영상으로 작성 가능</li>
	      		</ul>
      		</li>
      		<li>
      			게시글 보기
	      		<ul>
	      			<li>게시글 pageable 사용하여 페이징 처리 </li>
	      			<li>게시글 수정 삭제 기능</li>
	      			<li>해당 게시글 댓글 확인 가능</li>
	      		</ul>
      		</li>
      		<li>
      			보건 센터 보기
	      		<ul>
	      			<li>open api 사용 하여 데이트 출력</li>
	      		</ul>
      		</li>
      		<li>
      			보건 센터 보기(비동기)
	      		<ul>
	      			<li>ajax 사용하여 open api 사용 하여 비동기 식 출력</li>
	      		</ul>
      		</li>
      		<li>
      			영화 리스트보기
	      		<ul>
	      			<li>open api 사용 하여 데이트 표출</li>
	      			<li>원하는 날짜 선택 시 데이터 표출</li>
	      		</ul>
      		</li>
      		<li>
      			로그아웃
	      		<ul>
	      			<li>로그아웃 시 로그인 세션 초기화</li>
	      		</ul>
      		</li>
      	</ul>
   	  </div>
    </div>
  </div>
</div>

<%@include file="layout/footer.jsp"%>
