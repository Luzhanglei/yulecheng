package com.yulecheng.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tb_role")
public class Role
{
  @Id
  @GeneratedValue(generator="uuid")
  @GenericGenerator(name="uuid", strategy="uuid")
  private String id;
  private String roleName;
  @ManyToMany(cascade={javax.persistence.CascadeType.ALL}, mappedBy="role")
  private Set<User> userSet;
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getRoleName()
  {
    return this.roleName;
  }
  
  public void setRoleName(String roleName)
  {
    this.roleName = roleName;
  }
  
  public Set<User> getUserSet()
  {
    return this.userSet;
  }
  
  public void setUserSet(Set<User> userSet)
  {
    this.userSet = userSet;
  }
}
