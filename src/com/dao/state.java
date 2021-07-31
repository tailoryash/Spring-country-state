package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.stateVO;

@Repository
public class state {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(stateVO sVO){
		try{
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.saveOrUpdate(sVO);
			
			transaction.commit();
			
			session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<stateVO> search(stateVO sVO)
	{
		List<stateVO> ls=new ArrayList<>();
		try
			{
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				Query q = session.createQuery("from stateVO");
			
				ls = q.list();
						
				transaction.commit();
				
				session.close();
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
			}
		return ls;
	}
	
	
	
	public void delete(stateVO sVO)
	{
		try{
			
			Session session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.delete(sVO);
			
			transaction.commit();
			
			session.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<stateVO> edit(stateVO sVO)
	{
		List<stateVO> ls1 = new ArrayList<>();
		try
			{		
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				Query q = session.createQuery("from stateVO where id = ' "+sVO.getId()+"' ");
				
				ls1 = q.list();
				
				transaction.commit();
				
				session.close();
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
			}
	
		return ls1;
	}
}
