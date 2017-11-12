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
@Table(name="tb_lottery")
public class LotteryInfo
{
  @Id
  @GeneratedValue(generator="uuid")
  @GenericGenerator(name="uuid", strategy="uuid")
  private String id;
  private String lotteryType;
  private String lotteryNum;
  private Integer lotteryCount;
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
  
  public String getLotteryType()
  {
    return this.lotteryType;
  }
  
  public void setLotteryType(String lotteryType)
  {
    this.lotteryType = lotteryType;
  }
  
  public String getLotteryNum()
  {
    return this.lotteryNum;
  }
  
  public void setLotteryNum(String lotteryNum)
  {
    this.lotteryNum = lotteryNum;
  }
  
  public Integer getLotteryCount()
  {
    return this.lotteryCount;
  }
  
  public void setLotteryCount(Integer lotteryCount)
  {
    this.lotteryCount = lotteryCount;
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
