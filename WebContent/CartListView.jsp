<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>장바구니 관리</h3>
<c:choose>
	<c:when test="${CART_LIST == null || CART_LIST.size <= 0 }">
		장바구니 비어있지롱~<p>
		호롤롤로<p>
	</c:when>
	<c:otherwise>
		<table border="1">
			<tr>
				<td width="70">상품코드</td>
				<td width="250">제목</td>
				<td width="80">단가</td>
				<td width="50">수량</td>
				<td width="100">금액</td>
			</tr>
			<c:forEach var="cnt" begin="0" end="${CART_LIST.size-1 }">
			<tr>
				<td>${CART_LIST.code[cnt] }</td>
				<td>${CART_LIST.title[cnt] }</td>
				<td>${CART_LIST.price[cnt] }</td>
				<td>${CART_LIST.number[cnt] }</td>
				<td>${CART_LIST.price[cnt] * CART_NUM.number[cnt] }원</td>
			</tr>
			</c:forEach>
		</table>
		<form action="pay.jsp" method="post">
			총계 : ${CART_LIST.totalAmount }원 <p/>
			<input type="hidden" name="TOTAL_AMOUNT" value="${CART_LIST.totalAmount }">
			<input type="submit" value="카드결제">
		</form>
	</c:otherwise>
</c:choose>