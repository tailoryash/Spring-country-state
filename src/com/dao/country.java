package com.dao;

import com.model.countryVO;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class country {
	
	@Autowired
	private SessionFactory sessionFactory;
	
		public void insert(countryVO cVO){
			try{
				
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.saveOrUpdate(cVO);
				
				transaction.commit();
				
				session.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public List<countryVO> search(countryVO cVO)
		{
			List<countryVO> ls=new ArrayList<>();
			try
				{
			
					Session session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					Query q = session.createQuery("from countryVO");
				
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
		
		
		
		public void delete(countryVO cVO)
		{
			try{
				
				Session session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.delete(cVO);
				
				transaction.commit();
				
				session.close();
			
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public List<countryVO> edit(countryVO cVO)
		{
			List<countryVO> ls1 = new ArrayList<>();
			try
				{					
					Session session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					Query q = session.createQuery("from countryVO where id = ' "+cVO.getId()+"' ");
					
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
