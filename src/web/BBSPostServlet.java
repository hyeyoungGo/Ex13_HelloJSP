package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/bbs-post")
public class BBSPostServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		try {
			int seqNo;
			String id = (String) session.getAttribute("LOGIN_ID");
			if(id == null) {
				try {
					throw new Exception("로그인을 해주세요.");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			String title = request.getParameter("TITLE");
			String content = request.getParameter("CONTENT");
			GregorianCalendar now = new GregorianCalendar();
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
			if(conn == null) {
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) as CNT from bbs;");
			rs.next();
			seqNo = rs.getInt("CNT") + 1;
			String query = String.format("Insert into bbs (seqno, title, content, writer, wdate, wtime) values (" + "%d, '%s', '%s', '%s', '%TF', '%TT');", seqNo, title, content, id, now, now);
			int rowNum = stmt.executeUpdate(query);
			if(rowNum<1) {
				throw new ServletException("데이터를 DB에 입력할 수 없습니다.");
			}
			
		} catch (NamingException e) {
			System.out.println(e.getMessage());
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
		response.sendRedirect("WebTemplate.jsp?BODY_PATH=bbs-list");
	}
}
/*Insert into bbs (seqno, title, writer, content, wdate, wtime) value (14, 'a', 'b', 'c', '2009-11-25', '13:20:15');*/