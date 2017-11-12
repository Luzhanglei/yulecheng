package com.yulecheng.vo;

import com.yulecheng.entity.Role;
import com.yulecheng.entity.User;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserVo
{
  private String id;
  private String name;
  private String salt;
  private String password;
  private String telephone;
  private Integer isdelete;
  private Date logout;
  private String role;
  
  public static User toUser(UserVo userVo)
  {
    User user = new User();
    Set<Role> setRole = new HashSet();
    user.setId(userVo.getId() == null ? null : userVo.getId());
    user.setName(userVo.getName() == null ? null : userVo.getName());
    user.setSalt(userVo.getSalt() == null ? null : userVo.getSalt());
    user.setPassword(userVo.getPassword() == null ? null : userVo.getPassword());
    user.setTelephone(userVo.getTelephone() == null ? null : userVo.getTelephone());
    user.setIsdelete(userVo.getIsdelete() == null ? null : userVo.getIsdelete());
    user.setIsdelete(userVo.getIsdelete() == null ? null : userVo.getIsdelete());
    user.setLogout(userVo.getLogout() == null ? null : userVo.getLogout());
    Role role = new Role();
    if ("1".equals(userVo.getRole())) {
      role.setId("1");
    } else {
      role.setId("2");
    }
    setRole.add(role);
    user.setRole(setRole);
    return user;
  }
  
  public static UserVo toUserVo(User user)
  {
    UserVo userVo = new UserVo();
    userVo.setId(user.getId() == null ? null : user.getId());
    userVo.setName(user.getName() == null ? null : user.getName());
    userVo.setSalt(user.getSalt() == null ? null : user.getSalt());
    userVo.setPassword(user.getPassword() == null ? null : user.getPassword());
    userVo.setTelephone(user.getTelephone() == null ? null : user.getTelephone());
    userVo.setIsdelete(user.getIsdelete() == null ? null : user.getIsdelete());
    userVo.setIsdelete(user.getIsdelete() == null ? null : user.getIsdelete());
    userVo.setLogout(user.getLogout() == null ? null : user.getLogout());
    String role = "";
    for (Role r : user.getRole()) {
      role = role + r.getRoleName() + ",";
    }
    role.subSequence(0, role.lastIndexOf(","));
    userVo.setRole(role);
    return userVo;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getSalt()
  {
    return this.salt;
  }
  
  public void setSalt(String salt)
  {
    this.salt = salt;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public String getTelephone()
  {
    return this.telephone;
  }
  
  public void setTelephone(String telephone)
  {
    this.telephone = telephone;
  }
  
  public Integer getIsdelete()
  {
    return this.isdelete;
  }
  
  public void setIsdelete(Integer isdelete)
  {
    this.isdelete = isdelete;
  }
  
  public Date getLogout()
  {
    return this.logout;
  }
  
  public void setLogout(Date logout)
  {
    this.logout = logout;
  }
  
  public String getRole()
  {
    return this.role;
  }
  
  public void setRole(String role)
  {
    this.role = role;
  }
}
