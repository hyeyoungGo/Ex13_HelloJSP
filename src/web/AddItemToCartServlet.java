package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add-item-to-cart")
public class AddItemToCartServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("CODE");
		if(code == null) {
			throw new ServletException("상품 코드가 입력되지 않았습니다.");
		}
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("CART");
		if(cart == null) {
			cart = new Cart();
		}
		cart.addItem(code, 1);
		session.setAttribute("CART", cart);
		response.sendRedirect("AddItemToCartResult.jsp?ITEM_NUM=" + 1);
	}
}
