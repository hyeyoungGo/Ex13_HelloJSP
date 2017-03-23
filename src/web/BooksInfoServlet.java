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
import javax.sql.DataSource;

@WebServlet("/books-info")
public class BooksInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lowerCode = request.getParameter("LAST_CODE");
		if(lowerCode == null) {
			lowerCode = "000000";
		}
		try {
			BooksInfo booksInfo = readDB(lowerCode);
			System.out.println("booksInfo - size : " + booksInfo.getSize());
			request.setAttribute("BOOKS_INFO", booksInfo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WebTemplate.jsp?BODY_PATH=BooksInfoView.jsp");
		dispatcher.forward(request, response);
	}

	private BooksInfo readDB(String lowerCode) throws Exception {
		BooksInfo booksInfo = new BooksInfo();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			conn=ds.getConnection();
			if(conn == null) {
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			System.out.println("BooksInfoServlet - conn : " + conn);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from goodsinfo where code > '" + lowerCode + "' order by code asc;");
			for (int cnt = 0; cnt < 5; cnt++) {
				if(!rs.next()) {
					break;
				}
				booksInfo.setCode(cnt, rs.getString("code"));
				booksInfo.setTitle(cnt, rs.getString("title"));
				booksInfo.setWriter(cnt, rs.getString("writer"));
				booksInfo.setPrice(cnt, rs.getInt("price"));			
			}
			if(!rs.next()) {
				booksInfo.setLastPage(true);
			}
		} finally {
			try {
				rs.close();
			} catch (Exception e) {}
			try {
				stmt.close();
			} catch (Exception e) {}
			try {
				conn.close();
			} catch (Exception e) {}
		}
		return booksInfo;
	}

}
