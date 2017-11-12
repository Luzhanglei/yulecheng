package com.yulecheng.action;

import com.yulecheng.base.action.BaseAction;
import com.yulecheng.entity.Role;
import com.yulecheng.entity.User;
import com.yulecheng.service.RoleService;
import com.yulecheng.service.UserService;
import com.yulecheng.util.AES;
import com.yulecheng.util.ResultData;
import com.yulecheng.vo.UserVo;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class WelcomeAction
  extends BaseAction
{
  private User user;
  @Autowired
  private UserService userService;
  @Autowired
  private RoleService roleService;
  private ResultData buildSuccessResult;
  
  public String welcome()
  {
    return "welcome";
  }
  
  public String top()
  {
    return "top";
  }
  
  public String home()
  {
    return "home";
  }
  
  public void login()
    throws IOException
  {
    String username = this.user.getName();
    String password = this.user.getPassword();
    UserVo currentUser = this.userService.queryByName(username);
    int successFlag = 0;
    if (currentUser != null)
    {
      String userPassword = currentUser.getPassword();
      String checkPassword = AES.decrypt(userPassword, currentUser.getSalt());
      if (checkPassword.equals(password))
      {
        this.buildSuccessResult = ResultData.buildSuccessResult("登陆成功");
        successFlag = 1;
      }
      else
      {
        this.buildSuccessResult = ResultData.buildFailureResult("用户密码错误请重新输入");
      }
    }
    else
    {
      this.buildSuccessResult = ResultData.buildFailureResult("用户名不存在");
    }
    if (successFlag == 1) {
      getCurrentRequest().getSession().setAttribute("user", currentUser);
    }
    printJSONObject(this.buildSuccessResult);
  }
  
  public String register()
  {
    return "register";
  }
  
  public void add()
    throws IOException
  {
    Set<Role> roleSet = new HashSet();
    String username = this.user.getName();
    String password = this.user.getPassword();
    UserVo checkUser = this.userService.queryByName(username);
    String salt = UUID.randomUUID().toString().replace("-", "");
    if (StringUtils.isBlank(username))
    {
      this.buildSuccessResult = ResultData.buildFailureResult("用户名不能为空");
    }
    else if ((checkUser != null) && (checkUser.getName().equals(username)))
    {
      this.buildSuccessResult = ResultData.buildFailureResult("用户名已存在，请重新填写");
    }
    else if (StringUtils.isBlank(password))
    {
      this.buildSuccessResult = ResultData.buildFailureResult("密码不能为空");
    }
    else
    {
      Role r = new Role();
      r.setId("1001");
      roleSet.add(r);
      this.user.setRole(roleSet);
      this.user.setId(UUID.randomUUID().toString().replace("-", ""));
      this.user.setSalt(salt);
      this.user.setPassword(AES.encrypt(password, salt));
      this.user.setIsdelete(Integer.valueOf(1));
      boolean bool = this.userService.update(this.user);
      if (!bool) {
        this.buildSuccessResult = ResultData.buildFailureResult("注册失败");
      } else {
        this.buildSuccessResult = ResultData.buildSuccessResult("注册成功");
      }
    }
    printJSONObject(this.buildSuccessResult);
  }
  
  public User getUser()
  {
    return this.user;
  }
  
  public void setUser(User user)
  {
    this.user = user;
  }
}
