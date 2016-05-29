package com.milan.cxf.jaxrs.exception;

public class ErrorMessage {
	private String code;
	private String message;
	private int status;
	
	public ErrorMessage()
	{
//		this(null);
	}
	
	public ErrorMessage(AppException exception)
	{
		this.message = exception.getMessage();
		this.code = exception.getCode();
		this.status = exception.getStatus();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
