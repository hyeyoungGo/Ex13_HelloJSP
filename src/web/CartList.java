package web;

import java.util.ArrayList;

public class CartList {
	private ArrayList<String> codeList = new ArrayList<String>();   //상품 코드
	private ArrayList<String> titleList = new ArrayList<String>();
	private ArrayList<Integer> priceList = new ArrayList<Integer>();
	private ArrayList<Integer> numberList = new ArrayList<Integer>();
	
	public CartList() {	
	}
	
	public void setCode(int index, String code) {
		this.codeList.add(index, code);
	}
	
	public void setTitle (int index, String title) {
		this.titleList.add(index, title);
	}
	
	public void setPrice(int index, int price) {
		this.priceList.add(index, price);
	}
	
	public void setNumber(int index, int number) {
		this.numberList.add(index, number);
	}
	
	public String[] getCode() {
		return codeList.toArray(new String[codeList.size()]);
	}
	
	public String[] getTitle() {
		return titleList.toArray(new String[titleList.size()]);
	}
	
	public Integer[] getPrice() {
		return priceList.toArray(new Integer[priceList.size()]);
	}
	
	public Integer[] getNumber() {
		return numberList.toArray(new Integer[numberList.size()]);
	}
	
	public int getTotalAmount() {
		int total = 0;
		for (int cnt = 0; cnt < codeList.size(); cnt++) {
			total += priceList.get(cnt) * numberList.get(cnt);
		}
		return total;
	}
	
	public int getSize() {				// 장바구니 목록에 있는 항목의 수를 리턴
		return this.codeList.size();
	}
}
