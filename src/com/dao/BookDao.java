package com.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.bean.Book;

public class BookDao {

	    static Configuration cf = new AnnotationConfiguration().configure();
	    
	    //Insert
	    public static int insertBook(Book b)
	    {
	    	Session s = cf.buildSessionFactory().openSession();
	    	Transaction t = s.beginTransaction();
	    	int i = (int)s.save(b);
	    	if(i>0)
	    	{
	    		t.commit();
	    		System.out.println("Record Added Successfully");
	    	}
	    	else
	    	{
	    		System.out.println("Try Again");
	    	}
	    	return i;
	   }
	    
	    //Update
     public static int updateBook(String bn,float p)
     {
    	 Session s = cf.buildSessionFactory().openSession();
	     Transaction t = s.beginTransaction();
	     //HQL
	     Query q = s.createQuery("update Book SET bprice=:x where bname=:y");
	     q.setParameter("x", p);
	     q.setParameter("y", bn);
	     int i = q.executeUpdate();
	     t.commit();
	     return i;
	     
     }
     
     //Delete
     public static int deleteBook(String bn)
     {
    	 Session s = cf.buildSessionFactory().openSession();
	     Transaction t = s.beginTransaction();
	     Query q  = s.createQuery("delete from Book where bname=:x");
	     q.setParameter("x", bn);
	     int i = q.executeUpdate();
	     t.commit();
	     return i;
     }
     
     //Fetch Records
     public static List<Book> fetchBook()
     {
    	 Session s = cf.buildSessionFactory().openSession();
	     Transaction t = s.beginTransaction();
	     Query q  = s.createQuery("from Book");
	     return q.list();
     }
     
     //by criteria fetch the records
     //select 8 from Book where price>50;
     public static List<Book> FetchByRestriction(float p)
     {
    	 Session s = cf.buildSessionFactory().openSession();
	     Transaction t = s.beginTransaction();
	     
	     Criteria c = s.createCriteria(Book.class);
	     c.add(Restrictions.gt("bprice",p));
	     return c.list();
	  }
     
     //Order ascending and descending
     public static List<Book> fetchByOrder(String order, String pn)
     {
    	 Session s = cf.buildSessionFactory().openSession();
	     Transaction t = s.beginTransaction();
	      Criteria c = s.createCriteria(Book.class);
	      if(order.equalsIgnoreCase("asc"))
	      {
	    	  c.addOrder(Order.asc(pn));
	      }
	      else
	      if(order.equalsIgnoreCase("desc"))
	      {
	    	  c.addOrder(Order.desc(pn));
	      }
	      return c.list();
     }

}