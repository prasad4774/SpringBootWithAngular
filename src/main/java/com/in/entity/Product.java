package com.in.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
	  private Integer pid;
      private String pname;
	  public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	private Integer pprice;
	  private String pdetails;
	  private  String pcategory;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getPprice() {
		return pprice;
	}
	public void setPprice(Integer pprice) {
		this.pprice = pprice;
	}
	public String getPdetails() {
		return pdetails;
	}
	public void setPdetails(String pdetails) {
		this.pdetails = pdetails;
	}
	public String getPcategory() {
		return pcategory;
	}
	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}
}
