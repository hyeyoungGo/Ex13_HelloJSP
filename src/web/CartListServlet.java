package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/cart-list")
public class CartListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("CART");
		if(cart != null) {
			try {
				System.out.println("CartListServlet  = doGet" );
				CartList cartlist = readDB(cart);
				System.out.println("CartListServlet   = readDB(cart) " );
				request.setAttribute("CART_LIST", cartlist);
				System.out.println("cartlist = " + cartlist);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			request.setAttribute("CART_LIST", null);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WebTemplate.jsp?BODY_PATH=CartListView.jsp");
		dispatcher.forward(request, response);
	}

	private CartList readDB(Cart cart) throws Exception {
		CartList cartlist = new CartList();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
			System.out.println("CartListServlet - readDB() - conn : " + conn);
			if(conn == null) {
				throw new Exception("데이터베이스에 연결할수 없습니다.");
			}
			stmt = conn.createStatement();
			int itemNum = cart.getSize();
			for (int cnt = 0; cnt < itemNum; cnt++) {
				String code = cart.getCode(cnt);
				int number = cart.getNumber(cnt);
				rs = stmt.executeQuery("select title, price from goodsinfo where code = '" + code + "';");
				if(!rs.next()) {
					throw new Exception("해당 상품이 없습니다. [상품 코드 : " + code + "]");
				}
				String title = rs.getString("title");
				int price = rs.getInt("price");
				cartlist.setCode(cnt, code);
				cartlist.setTitle(cnt, title);
				cartlist.setPrice(cnt, price);
				cartlist.setNumber(cnt, number);
			}
		} finally {
			try {
				rs.close();
			} catch (Exception e) {}
			try {
				stmt.close();
			} catch(Exception e) {}
			try{
				conn.close();
			} catch(Exception e) {}
		}
		return cartlist;
	}
}
