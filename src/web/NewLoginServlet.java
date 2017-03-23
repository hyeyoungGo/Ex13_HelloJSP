package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/new-login")
public class NewLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String currentURL = request.getParameter("CURRENT_URL");
		System.out.println(id + ", " + pw + ", "  + currentURL);
		
		try {
			if(checkLoginInfo(id, pw)) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGIN_ID", id);
				System.out.println("LOGIN 성공");
			} else {
				System.out.println("LOGIN 실패");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		response.sendRedirect(currentURL);
	}
	
	private boolean checkLoginInfo(String id, String password) throws Exception {
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs =null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
			if(conn == null) {
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select password from userinfo where id = '" + id + "';");
			if(!rs.next())
				return false;
			String correntPassword = rs.getString("password");
			if(password.equals(correntPassword)) {
				return true;
			} else {
				return false;
			}
		} finally {
			try {
				rs.close();
			} catch(Exception e) {}
			try {
				stmt.close();
			} catch(Exception e) {}
			try {
				conn.close();
			} catch(Exception e) {}
		}
		
	}

}
