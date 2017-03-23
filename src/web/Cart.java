package web;

import java.util.LinkedList;

public class Cart {
	private LinkedList<String> codeList = new LinkedList<String>();
	private LinkedList<Integer> numberList = new LinkedList<Integer>();
	public void addItem(String code, int num) {
		for (int cnt = 0; cnt < codeList.size(); cnt++) {
			if(codeList.get(cnt).equals(code)) {
				this.numberList.set(cnt, numberList.get(cnt) + num);
				return;
			}
		}
		codeList.add(code);
		numberList.add(num);
	}
	public void removeItem(int index) {
		codeList.remove(index);
		numberList.remove(index);
	}
	public String getCode(int index) {
		return codeList.get(index);
	}
	public int getNumber(int index) {
		return numberList.get(index);
	}
	public int getSize() {
		return codeList.size();
	}
	public void setNumber(int cnt, int num) {
		this.numberList.set(cnt, num);
	}

}
