package web;

import java.util.ArrayList;

public class BooksInfo {
	private ArrayList<String> codeList = new ArrayList<String>();  		   // 상품코드
	private ArrayList<String> titleList = new ArrayList<String>();   		   // 제목
	private ArrayList<String> writerList = new ArrayList<String>();    	   // 저자
	private ArrayList<Integer> priceList = new ArrayList<Integer>();    // 가격
	private boolean lastPage = false;  																	   // 책 정보 목록의 마지막 페이지인지 확인
	
	public void setCode(int index, String code) {
		this.codeList.add(index, code);
	}
	
	public void setTitle(int index, String title) {
		this.titleList.add(index, title);
	}
	
	public void setWriter(int index, String writer) {
		this.writerList.add(index, writer);
	}
	
	public void setPrice(int index, int price) {
		this.priceList.add(index, price);
	}
	
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	
	public String[] getCode() {
		return codeList.toArray(new String[codeList.size()]);
	}
	
	public String[] getTitle() {
		return titleList.toArray(new String[titleList.size()]);
	}
	
	public String[] getWriter() {
		return writerList.toArray(new String[writerList.size()]);
	}
	
	public Integer[] getPrice() {
		return priceList.toArray(new Integer[priceList.size()]);
	}
	
	public boolean isLastPage() {
		return this.lastPage;
	}
	public int getSize() {						// 책 정보의 수를 리턴하는 메소드
		return this.codeList.size();
	}
}
