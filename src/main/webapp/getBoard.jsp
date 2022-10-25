<%@page import="glory.spring.web.board.impl.BoardDAO"%>
<%@page import="glory.spring.web.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션에 저장한 게시글 정보를 추출한다. 
	BoardVO board = (BoardVO) session.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Article Content</title>
</head>
<body>
<h1>글 상세</h1>
<a href="logout.do">Log Out</a><hr>
<form action="updateBoard.do" method="post">
<!-- 글 수정을 위해 시퀀스 번호를 hidden으로 보내준다. -->
<input name="seq" type="hidden" value="<%=board.getSeq()%>"/>
<table border="1">
<tr>
	<td>제목</td>
	<td><input name="title" type="text" value="<%=board.getTitle() %>"></td>
</tr>
<tr>
<td>작성자</td>
<td><%=board.getWriter() %></td>
</tr>
<tr>
<td>내용</td>
<td><textarea name="content"><%=board.getContent() %></textarea></td>
</tr>
<tr>
<td>등록일</td>
<td><%=board.getRegDate() %></td>
</tr>
<tr>
<td>조회수</td>
<td><%=board.getCnt() %></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="글수정"/></td>
</tr>
</table>
</form><hr>
<a href="insertBoard.jsp">글등록</a> &nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=<%=board.getSeq()%>">글삭제</a> &nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글목록</a>
</body>
</html>