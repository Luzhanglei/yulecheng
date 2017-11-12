package com.yulecheng.dao;

import com.yulecheng.base.dao.IBaseDao;
import com.yulecheng.entity.User;

public abstract interface UserDao
  extends IBaseDao<User, String>
{
  public abstract User queryByName(String paramString);
}
