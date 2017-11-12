package com.yulecheng.base.dao;

import java.io.Serializable;
import java.util.List;

public abstract interface IBaseDao<E, PK extends Serializable>
{
  public abstract PK save(E paramE);
  
  public abstract void update(E paramE);
  
  public abstract void delete(E paramE);
  
  public abstract void delete(PK paramPK);
  
  public abstract E get(PK paramPK);
  
  public abstract List<E> find();
  
  public abstract List<E> find(String paramString, Object... paramVarArgs);
  
  public abstract Long count();
  
  public abstract Long count(String paramString, Object... paramVarArgs);
  
  public abstract List<E> findByPage(int paramInt1, int paramInt2, String paramString, Object... paramVarArgs);
  
  public abstract boolean saveOrUpdate(E paramE);
}
