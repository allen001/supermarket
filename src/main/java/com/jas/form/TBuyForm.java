package com.jas.form;

import com.jas.model.TBuy;

public class TBuyForm extends TBuy {

	private String buyTime1;
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
	public String getBuyTime1() {
		return buyTime1;
	}
	public void setBuyTime1(String buyTime1) {
		this.buyTime1 = buyTime1;
	}
}
