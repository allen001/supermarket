package com.jas.form;

import com.jas.model.TSell;

public class TSellForm extends TSell {

	private String sellTime1;
	private String suppName;
	private String goodName;
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public String getSellTime1() {
		return sellTime1;
	}
	public void setSellTime1(String sellTime1) {
		this.sellTime1 = sellTime1;
	}
	
}
