package com.yulecheng.base.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yulecheng.entity.User;
import com.yulecheng.util.ResultData;
import com.yulecheng.vo.UserVo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

public abstract class BaseAction
  extends ActionSupport
{
  private static final long serialVersionUID = 1L;
  protected Long page = Long.valueOf(1L);
  protected Long rows = Long.valueOf(10L);
  protected ResultData resultData;
  
  public ResultData getResultData()
  {
    return this.resultData;
  }
  
  public void setResultData(ResultData resultData)
  {
    this.resultData = resultData;
  }
  
  protected User getCurrentUser()
  {
    HttpSession session = ServletActionContext.getRequest().getSession();
    UserVo userVo = (UserVo)session.getAttribute("user");
    return UserVo.toUser(userVo);
  }
  
  protected HttpServletRequest getCurrentRequest()
  {
    return ServletActionContext.getRequest();
  }
  
  protected void printJSONObject(Object obj)
    throws IOException
  {
    printJSONObject(obj, new String[0]);
  }
  
  protected void printJSONObject(Object obj, String... excludeProperties)
    throws IOException
  {
    HttpServletResponse response = ServletActionContext.getResponse();
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=UTF-8");
    
    PrintWriter out = response.getWriter();
    
    JsonConfig config = new JsonConfig();
    config.setExcludes(excludeProperties);
    
    JSONObject json = JSONObject.fromObject(obj, config);
    
    out.print(json.toString());
    out.flush();
  }
  
  public Long getPage()
  {
    return this.page;
  }
  
  public void setPage(Long page)
  {
    this.page = page;
  }
  
  public Long getRows()
  {
    return this.rows;
  }
  
  public void setRows(Long rows)
  {
    this.rows = rows;
  }
}
