<%@page import="web.BBSItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	BBSItem bbsItem = new BBSItem();
	bbsItem.readDB();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트 컴퓨터</title>
</head>
<body>
	<h2>비트 컴퓨터</h2>
	<table border="1" cellpadding="10" cellspacing="0" bordercolor="#003366" bgcolor="#FFF0F0"  width="1500px" height="700px" >
		<tr>
			<td width=190 valign="top">
				<c:choose>
					<c:when test = "${sessionScope.LOGIN_ID == null }">
						<jsp:include page="LoginWindow.html"/>
					</c:when>
					<c:otherwise>
						<jsp:include page="LogoutWindow.jsp"/>
					</c:otherwise>
				</c:choose><p>
				<a href="WebTemplate.jsp?BODY_PATH=Intro.html">회사소개</a><p>
				<a href="books-info">책정보</a><p>
				<a href="WebTemplate.jsp?BODY_PATH=BBSInput.html">게시판 글쓰기</a><p>
				<a href="bbs-list">게시판 글읽기</a><p>
				<a href="cart-list">장바구니</a><p>
			</td>
			<td width=650 valign="top">
				<jsp:include page="${param.BODY_PATH }"/>
			</td>
		</tr>
	</table>
	<h4>Copyright@1234-5678 비트 컴퓨터</h4>
</body>
</html>