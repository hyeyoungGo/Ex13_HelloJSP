<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>게시판 목록 보기</h3>
<table border="1" cellpadding="8" cellspacing="0">
	<tr>
		<td>순번</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일자</td>
		<td>작성시간</td>
	</tr>
	<c:forEach var="cnt" begin="0" end="${BBS_LIST.listSize -1 }">
	<tr>
		<td>${BBS_LIST.seqNo[cnt] }</td>
		<td>
			<a href = "WebTemplate.jsp?BODY_PATH=BBSItemView.jsp?SEQ_NO=${BBS_LIST.seqNo[cnt] }">
			${BBS_LIST.title[cnt] } </a>
		</td>
		<td>${BBS_LIST.writer[cnt] }</td>
		<td>${BBS_LIST.date[cnt] }</td>
		<td>${BBS_LIST.time[cnt] }</td>
	</tr>
	</c:forEach>
</table>
<c:if test="${!BBS_LIST.firstPage }">
	<a href="bbs-list?FIRST_SEQ_NO=${BBS_LIST.seqNo[BBS_LIST.listSize +1] }">이전</a>
</c:if>
<c:if test="${!BBS_LIST.lastPage }"> 
	<a href="bbs-list?LAST_SEQ_NO=${BBS_LIST.seqNo[BBS_LIST.listSize -1] }">다음</a>
</c:if>

