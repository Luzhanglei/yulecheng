package com.yulecheng.util;

import java.io.Serializable;

public class ResultData
  implements Serializable
{
  private static final long serialVersionUID = -8967147927300560419L;
  private boolean success = true;
  private String message = "";
  private Object data;
  
  public ResultData() {}
  
  public ResultData(boolean success, String message)
  {
    this(success, message, null);
  }
  
  public ResultData(boolean success, String message, Object data)
  {
    this.success = success;
    this.message = message;
    this.data = data;
  }
  
  public static ResultData buildSuccessResult()
  {
    return buildSuccessResult("");
  }
  
  public static ResultData buildSuccessResult(String message)
  {
    return buildSuccessResult(message, null);
  }
  
  public static ResultData buildSuccessResult(String message, Object data)
  {
    return new ResultData(true, message, data);
  }
  
  public static ResultData buildFailureResult()
  {
    return buildFailureResult("");
  }
  
  public static ResultData buildFailureResult(String message)
  {
    return buildFailureResult(message, null);
  }
  
  public static ResultData buildFailureResult(String message, Object data)
  {
    return new ResultData(false, message, data);
  }
  
  public boolean isSuccess()
  {
    return this.success;
  }
  
  public void setSuccess(boolean success)
  {
    this.success = success;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public void setMessage(String message)
  {
    this.message = message;
  }
  
  public Object getData()
  {
    return this.data;
  }
  
  public void setData(Object data)
  {
    this.data = data;
  }
}
