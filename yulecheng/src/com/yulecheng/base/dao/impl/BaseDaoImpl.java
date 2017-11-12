package com.yulecheng.base.dao.impl;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.yulecheng.base.dao.IBaseDao;

@SuppressWarnings("all")
/**
 * 基础Dao实现类
 * @author
 *
 * @param <E> -实体类型
 * @param <PK> -主键类型
 */
public class BaseDaoImpl<E,PK extends Serializable>  implements IBaseDao<E, PK>{
	
	//注入SessionFactory对象 
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<E> entityClass;
	
	/**
	 * 定义有参构造方法
	 * @param entityClass -实体类对应的Class<E>类型
	 */
	public BaseDaoImpl(Class<E> entityClass){
		this.entityClass = entityClass;
	}
	
	public BaseDaoImpl(){
		//获取子类中泛型实际类型
		entityClass = (Class<E>)(((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
	}
	
	/**
	 * 提供获取Session的方法，以便在当前类或者子类中使用
	 * @return
	 */
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public PK save(E e) {
		return (PK)session().save(e);
	}

	@Override
	public void update(E e) {
		session().update(e);
		
	}

	@Override
	public void delete(E e) {
		session().delete(e);
	}

	@Override
	public void delete(PK id) {
		//先加载实体对象
		Object obj = session().load(entityClass, id);
		//然后进行删除
		session().delete(obj);
	}

	@Override
	public E get(PK id) {
		
		return (E)session().get(entityClass, id);
	}

	@Override
	public List<E> find() {
		String hql = "from "+entityClass.getName();
	
		return session().createQuery(hql).list();
	}

	@Override
	public List<E> find(String hql, Object... args) {
		Query query = session().createQuery(hql);
		addParameter(query, args);
		return query.list();
	}

	@Override
	public Long count() {
		String hql = "select count(*) from "+entityClass.getName() + " where isdelete = 1" ;
		return (Long)session().createQuery(hql).uniqueResult();
	}

	@Override
	public Long count(String hql, Object... args) {
		Query query = session().createQuery(hql);
		addParameter(query, args);
		return (Long)query.uniqueResult();
	}

	@Override
	public List<E> findByPage(int pageNumber, int pageSize, String hql,
			Object... args) {
		Query query = session().createQuery(hql);
		addParameter(query, args);
		query.setFirstResult((pageNumber-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	public void addParameter(Query query, Object... args){
		if(args!=null && args.length>0){
			for(int i=0;i<args.length;i++){
				query.setParameter(i, args[i]);
			}
		}
	}

	@Override
	public boolean saveOrUpdate(E e) {
		session().saveOrUpdate(e);
		return true;
	}


}
