<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- presentation-layer.xml에 MessageSource bean으로 경로 설정을 했기 때문에 code 옵션에 key와 value만 작성한다.(패키지명까지 작성 x)  -->
<title><spring:message code="user.login.title" /></title>
<!-- <title>로그인</title> -->
</head>
<body>
<h1><spring:message code="user.login.title" /></h1>
<!-- <h1>로그인</h1> -->
<a href="login.do?lang=en">
<spring:message code="user.login.language.en" /></a>&nbsp;&nbsp;
<a href="login.do?lang=ko"><spring:message code="user.login.language.ko" /></a> 
<hr>
<form action="login.do" method="post">
<table border="1">
<tr>
<td><spring:message code="user.login.id" /></td>
<!-- <td>아이디</td> -->
<td><input type="text" name="id" value="${userVO.id}"/></td>
</tr>
<tr>
<td><spring:message code="user.login.password" /></td>
<!-- <td>비밀번호</td> -->
<td><input type="password" name="password" value="${userVO.password}"/></td>
</tr>
<tr>
<td colspan="2"><input type="submit" 
value="<spring:message code="user.login.loginBtn" />" /></td>
<!-- value="로그인" /></td> -->
</tr>
</table>
</form> 
</body>
</html>