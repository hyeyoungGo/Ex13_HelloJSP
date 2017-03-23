package web;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BBSItem {
	private int seqNo;  				// 순번
	private String title;  				// 제목
	private String content; 		//내용
	private String writer;			//저자
	private Date date;					//저장 일시
	private Time time;					// 저장 시각
	
	public BBSItem() {
		
	}

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	public void readDB() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/mysql");
			conn = ds.getConnection();
			if(conn == null) {
				throw new Exception("데이터베이스에 연결할수 없습니다.");
			}
			System.out.println("conn : " + conn);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from bbs where seqNo = '" + seqNo + "';" );
			if(rs.next()) {
				this.title = rs.getString("title");
				this.content = rs.getString("content");
				this.writer = rs.getString("writer");
				this.date = rs.getDate("wdate");
				this.time = rs.getTime("wtime");
			}
			System.out.println(title + "," + content + "," + writer + "," + date + "," + time);
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
	}
/*select * from bbs where seqNo = ' seqNo'; */
}
