package com.milan.cxf.jaxrs.exception;

public class AppException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	private int status;
	
	public AppException()
	{
		this(null);
	}
	public AppException(String message)
	{
		this(null,message,-1);
	}
	public AppException(String code,String message,int status)
	{
		super(message);
		this.message = message;
		this.code=code;
		this.status = status;
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
