package com.yulecheng.entity;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tb_user")
public class User
{
  @Id
  @GeneratedValue(generator="uuid")
  @GenericGenerator(name="uuid", strategy="uuid")
  private String id;
  @Column(nullable=false, length=20)
  private String name;
  private String salt;
  @Column(nullable=false, length=64)
  private String password;
  @Column(length=20)
  private String telephone;
  private Integer isdelete;
  private Date logout;
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name="tb_user_role", joinColumns={@javax.persistence.JoinColumn(name="user_id", updatable=false)}, inverseJoinColumns={@javax.persistence.JoinColumn(name="role_id", updatable=false)})
  private Set<Role> role;
  
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
  
  public Set<Role> getRole()
  {
    return this.role;
  }
  
  public void setRole(Set<Role> role)
  {
    this.role = role;
  }
}
