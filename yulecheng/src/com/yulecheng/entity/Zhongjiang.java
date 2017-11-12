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
@Table(name="tb_zhongjiang")
public class Zhongjiang
{
  @Id
  @GeneratedValue(generator="uuid")
  @GenericGenerator(name="uuid", strategy="uuid")
  private String id;
  private String price;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="lotteryId")
  private LotteryInfo lotteryType;
  
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getPrice()
  {
    return this.price;
  }
  
  public void setPrice(String price)
  {
    this.price = price;
  }
  
  public LotteryInfo getLotteryType()
  {
    return this.lotteryType;
  }
  
  public void setLotteryType(LotteryInfo lotteryType)
  {
    this.lotteryType = lotteryType;
  }
}
