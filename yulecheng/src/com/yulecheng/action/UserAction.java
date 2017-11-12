package com.yulecheng.action;

import com.yulecheng.base.action.BaseAction;
import com.yulecheng.entity.User;
import com.yulecheng.service.RoleService;
import com.yulecheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class UserAction
  extends BaseAction
{
  private User user;
  @Autowired
  private UserService userService;
  @Autowired
  private RoleService roleService;
  
  public User getUser()
  {
    return this.user;
  }
  
  public void setUser(User user)
  {
    this.user = user;
  }
}
