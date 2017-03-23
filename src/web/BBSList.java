package web;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class BBSList {
	private ArrayList<Integer> seqNoList = new ArrayList<Integer>();		// 순번
	private ArrayList<String> titleList = new ArrayList<String>();					// 제목
	private ArrayList<String> writerList = new ArrayList<String>();				// 작성자
	private ArrayList<Date> dateList = new ArrayList<Date>();						// 날짜
	private ArrayList<Time> timeList = new ArrayList<Time>();						// 시간
	private boolean lastPage = false;																				// 게시글 목록의 마지막 페이지 여부
	private boolean firstPage = false;

	public BBSList() {
		
	}
	
	public void setSeqNo(int index, Integer seqNo) {
		this.seqNoList.add(index, seqNo);
	}
	
	public void setTitle(int index, String title) {
		this.titleList.add(index, title);
	}
	
	public void setWriter(int index, String writer) {
		this.writerList.add(index, writer);
	}
	
	public void setDate(int index, Date date) {
		this.dateList.add(index, date);
	}
	
	public void setTime(int index, Time time) {
		this.timeList.add(index, time);
	}
	
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	
	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}
	//int arr[] = new int[10];
	public Integer[] getSeqNo() {
		return seqNoList.toArray(new Integer[seqNoList.size()]);
	}
	//int String[] = new String[10];
	public String[] getTitle() {
		return titleList.toArray(new String[titleList.size()]);
	}
	
	public String[] getWriter() {
		return writerList.toArray(new String[writerList.size()]);
	}
	
	public Date[] getDate() {
		return dateList.toArray(new Date[dateList.size()]);
	}
	
	public Time[] getTime() {
		return timeList.toArray(new Time[timeList.size()]);
	}
	
	public boolean isLastPage() {
		return lastPage;
	}
	
	public boolean isFirstPage() {
		return firstPage;
	}
	
	public int getListSize() {				// 게시글의 수를 리턴하는 메소드
		System.out.println("BBSList getListSize - " + seqNoList.size());
		return seqNoList.size();
	}
}

