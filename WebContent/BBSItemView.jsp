<%@page import="web.BBSItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int seqNo = Integer.parseInt(request.getParameter("SEQ_NO"));
	BBSItem bbsItem = new BBSItem();
	bbsItem.setSeqNo(seqNo);
	bbsItem.readDB();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트컴퓨터</title>
</head>
<body>
	<h2>게시글 읽기</h2>
	[제목] : <%=bbsItem.getTitle() %><p/>
	[작성자] : <%=bbsItem.getWriter() %><p/>
	[작성일자] : <%=bbsItem.getDate() %> <%=bbsItem.getTime() %><p/>
	---------------------------------------------------------------<p/>
	<%=bbsItem.getContent() %>
</body>
</html>