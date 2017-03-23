<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bbsItem" class="web.BBSItem"></jsp:useBean>
<jsp:setProperty property="seqNo" name="bbsItem" value="${param.SEQ_NO }"/>
<% bbsItem.readDB(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트컴퓨터</title>
</head>
<body>
	<h2>게시글 읽기</h2>
	[제목] : <jsp:getProperty property="title" name="bbsItem"/> <p/>
	[작성자] : <jsp:getProperty property="writer" name="bbsItem"/> <p/>
	[작성일자] : <jsp:getProperty property="date" name="bbsItem"/> <p/>
							  <jsp:getProperty property="time" name="bbsItem"/> <p/>
	-------------------------------------------------------------------<p/>
	<jsp:getProperty property="content" name="bbsItem"/>
</body>
</html>