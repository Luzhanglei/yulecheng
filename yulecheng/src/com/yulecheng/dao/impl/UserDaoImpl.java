package com.yulecheng.dao.impl;

import com.yulecheng.base.dao.impl.BaseDaoImpl;
import com.yulecheng.dao.UserDao;
import com.yulecheng.entity.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl
  extends BaseDaoImpl<User, String>
  implements UserDao
{
  public User queryByName(String username)
  {
    Criteria userCriteria = session().createCriteria(User.class);
    List<User> userList = userCriteria.add(Restrictions.eq("name", username)).list();
    if (userList.size() > 0) {
      return (User)userList.get(0);
    }
    return null;
  }
}
