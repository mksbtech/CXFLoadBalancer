package com.milan.cxf.exception;

public class ServiceException
  extends RuntimeException
{
  private static final long serialVersionUID = -3895160243925235480L;
  private String message;
  
  public ServiceException()
  {
    this(null);
  }
  
  public ServiceException(String message)
  {
    super(message);
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public void setMessage(String message)
  {
    this.message = message;
  }
}
