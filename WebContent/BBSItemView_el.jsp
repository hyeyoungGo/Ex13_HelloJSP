<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bbsItem" class="web.BBSItem" />
<jsp:setProperty property="seqNo" name="bbsItem" value="${param.SEQ_NO }"/>
<% bbsItem.readDB(); %>
	<h3>게시글 읽기</h3>
	[제목] : ${bbsItem.title } <p/>
	[작성자] : ${bbsItem.writer } <p/>
	[작성일자] : ${bbsItem.date } ${bbsItem.time } <p/>
	------------------------------------------------ <p/>
	${bbsItem.content }
</body>
</html>