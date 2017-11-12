package com.yulecheng.service;

import com.yulecheng.entity.User;
import com.yulecheng.vo.UserVo;

public abstract interface UserService
{
  public abstract UserVo queryByName(String paramString);
  
  public abstract boolean update(User paramUser);
}
