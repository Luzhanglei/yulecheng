package com.yulecheng.service.impl;

import com.yulecheng.dao.UserDao;
import com.yulecheng.entity.User;
import com.yulecheng.service.UserService;
import com.yulecheng.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl
  implements UserService
{
  @Autowired
  private UserDao userDao;
  
  public UserVo queryByName(String username)
  {
    User user = this.userDao.queryByName(username);
    if (user != null) {
      return UserVo.toUserVo(user);
    }
    return null;
  }
  
  public boolean update(User user)
  {
    return this.userDao.saveOrUpdate(user);
  }
}
