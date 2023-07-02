package com.bean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.dao.BookDao;

public class MainApplication {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ch,i = 0;
		String bn,an,pn,o;
		float p;
		List<Book> l;
		Book b;
		
		do
		{
			System.out.println("1:Insert\n2:Update\n3:Delete\n4:FetchAllRecords\n5:FetchAllRecordsByRestriction\n6:FetchAllRecordsByOrder\n7:Exit");
			System.out.println("Enter Your Choices");
			ch = Integer.parseInt(br.readLine());
			switch(ch)
			{
			case 1: //Insert
			System.out.println("Enter Book Details:\nBook Name,Author Name,Price");
			b = new Book();
			b.setBname(br.readLine());
			b.setAname(br.readLine());
			b.setBprice(Float.parseFloat(br.readLine()));
			i=BookDao.insertBook(b);
			if(i>0)
			{
				System.out.println("Records added Succcessfully");
			}
			else
			{
				System.out.println("Try Again");	
			}
			break;
			
			case 2://Update
			System.out.println("Enter Book Details:\nBook Name,price");
			b = new Book();
			bn=br.readLine();
			p=Float.parseFloat(br.readLine());
			i=BookDao.updateBook(bn, p);
			if(i>0)
			{
				System.out.println("Records added Succcessfully");
			}
			else
			{
				System.out.println("Try Again");	
			}
			break;
			
			case 3://Delete
			System.out.println("Enter Book Details:\nBoo_Name");
			b=new Book();
			bn=br.readLine();
			i=BookDao.deleteBook(bn);
			if(i>0)
			{
				System.out.println("Records added Succcessfully");
			}
			else
			{
				System.out.println("Try Again");	
			}
			break;
			
			case 4://fetch All Records
			System.out.println("fetch All Book records:");
			l=BookDao.fetchBook();
			if(i>0)
			{
				System.out.println("Records added Succcessfully");
			}
			else
			{
				System.out.println("Try Again");	
			}
			break;	
			
			case 5://Fetched records by Restriction
			System.out.println("Enter Price to br apply based on Restriction==>");
			p=Float.parseFloat(br.readLine());
			l = BookDao.FetchByRestriction(p);
			for(Book b1:l)
			{
				System.out.println(b1);
			}
			break;
			
			case 6://Fetch record by order
		    System.out.println("Enter order and property name to apply order with==>");
		    o=br.readLine();
		    pn=br.readLine();
		    l=BookDao.fetchByOrder(o, pn);
		    for(Book b1:l)
			{
				System.out.println(b1);
			}
			break;
			
			case 7://Exit
			System.out.println("Thank you for using this application");
			System.exit(0);
			break;
			
			default:
			System.out.println("Enter Your Choice 1/2");
			
		    }
		 
		
		}
		while(true);
		

	}	

}
