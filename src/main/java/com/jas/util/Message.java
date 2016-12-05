package com.jas.util;

public class Message {
	private boolean isSuccess;
	private String message;
	private Object others;

	public static Message getMessage(boolean isSuccess, String message) {
		Message resultMsg = new Message();
		resultMsg.setMessage(message);
		resultMsg.setSuccess(isSuccess);
		return resultMsg;
	}

	public boolean isSuccess() {
		return this.isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getOthers() {
		return this.others;
	}

	public void setOthers(Object others) {
		this.others = others;
	}
}
