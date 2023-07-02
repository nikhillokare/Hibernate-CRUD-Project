package com.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book_Info")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private int id;
	 @Column(name="Book_Name")
	 private String bname;
	 @Column(name="Author_Name")
	 private String aname;
	 @Column(name="Book_Price")
	 private float bprice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public float getBprice() {
		return bprice;
	}
	public void setBprice(float bprice) {
		this.bprice = bprice;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bname=" + bname + ", aname=" + aname + ", bprice=" + bprice + "]";
	}
	 
	 
	

}
