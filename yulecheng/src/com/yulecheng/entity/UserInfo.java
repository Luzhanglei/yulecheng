package com.yulecheng.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tb_userInfo")
public class UserInfo
{
  @Id
  @GeneratedValue(generator="uuid")
  @GenericGenerator(name="uuid", strategy="uuid")
  private String id;
  private String card;
  private String trueName;
  private String shenfenId;
  private Double yue;
  private String withdrawPassword;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="userId")
  private User user;
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getCard()
  {
    return this.card;
  }
  
  public void setCard(String card)
  {
    this.card = card;
  }
  
  public String getUsername()
  {
    return this.trueName;
  }
  
  public void setUsername(String trueName)
  {
    this.trueName = trueName;
  }
  
  public String getShenfenId()
  {
    return this.shenfenId;
  }
  
  public void setShenfenId(String shenfenId)
  {
    this.shenfenId = shenfenId;
  }
  
  public Double getYue()
  {
    return this.yue;
  }
  
  public void setYue(Double yue)
  {
    this.yue = yue;
  }
  
  public String getPassword()
  {
    return this.withdrawPassword;
  }
  
  public void setPassword(String withdrawPassword)
  {
    this.withdrawPassword = withdrawPassword;
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
