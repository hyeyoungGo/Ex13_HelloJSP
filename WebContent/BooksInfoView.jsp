<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>책 정보</h3>
<table border="1" cellpadding="8" cellspacing="0" bordercolor="#33FFFF">
	<tr>
		<td width="110">상품코드</td>
		<td width="250">제목</td>
		<td width="80">저자</td>
		<td width="80">가격</td>
		<td width="120">비고</td>
	</tr>
	<c:forEach var="cnt" begin="0" end="${BOOKS_INFO.size -1 }">
		<tr>
			<td>${BOOKS_INFO.code[cnt] }</td>
			<td>${BOOKS_INFO.title[cnt] }</td>
			<td>${BOOKS_INFO.writer[cnt] }</td>
			<td>${BOOKS_INFO.price[cnt] }</td>
			<td>
			<a href="#" onclick='window.open("add-item-to-cart?CODE=${BOOKS_INFO.code[cnt] }", "cart_result", "width=400, height=150").focus()'>
				장바구니 담기</a>
			</td>
		</tr>	
	</c:forEach>
</table>
<c:if test="${BOOKS_INFO.lastPage }">
	<a href="books-info?LAST_CODE=${BOOKS_INFO.code[BOOKS_INFO.size -1] }">다음</a>
</c:if>