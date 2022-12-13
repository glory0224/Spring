<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>

<!-- 카페 하이 헤더  -->   
<%-- <jsp:include page="/cafeHi_module/header.jsp"/> --%>
<h2><c:out value="${error }"/></h2>
<h2><c:out value="${logout }"/></h2>


<div class="container">
<div class="m-auto w-50 p-50">
<main class="form-signin">
  <form class="m-auto w-50 p-50" action="/login" method="post" id="loginForm">
    <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">

    <h1 class="h3 mb-3 fw-normal">로그인</h1><br>
	
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Id" name="username">
      <label for="floatingInput">아이디</label>
    </div><br>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
      <label for="floatingPassword">비밀번호</label><br>
    </div>
	<div class="form-floating">
		<input type="checkbox" name="remember-me"> Remember Me
	</div>
    <div class="checkbox mb-3">
    </div>
    <button class="w-100 btn btn-lg btn-success" type="submit">로그인</button><br>
 <div class="d-flex justify-content-evenly" style="margin-top: 20px">
	<span><a href="cafehi_pwSearch.jsp" onclick="window.open('cafehi_pwSearch.jsp','', 'width=800, height=600'); return false;" style="text-decoration: none; color:black">비밀번호 찾기</a></span>
	<!-- window 내장 메소드 open 사용 시 return false;를 해주지 않으면 팝업창이 열리고 해당 페이지도 넘어간다. 그렇기 때문에 return false로 href가 실행되지 않도록 한다. -->
	<span><a href="" onclick="window.open('idSearch.do','', 'width=800, height=600'); return false;" style="text-decoration: none; color:black">아이디 찾기</a></span>
	<span><a href="signup.do" style="text-decoration: none; color:black">회원 가입</a></span>
	</div>
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		
  </form>





</main>
</div>
<!--카페 하이 FOOTER -->
<%-- <jsp:include page="/cafeHi_module/footer.jsp"/> --%>

</div>





</body>

</html>