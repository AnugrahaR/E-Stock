package com.anu.stock.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int companyCode;
	private BigDecimal stockPrice;
	private String companyName;
	//@Column(name = "local_time", columnDefinition = "TIME")
	private LocalTime time;

	private LocalDate date;

	public Stock() {
		
	}
	public Stock(int companycode,String companyName, Double  price) {
		this.companyCode = companycode;
		this.setCompanyName(companyName);
		this.stockPrice = BigDecimal.valueOf(price);
		this.date= LocalDate.now();
		this.time =LocalTime.now();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}

	public BigDecimal getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(BigDecimal stockPrice) {
		this.stockPrice = stockPrice;
	}

	public LocalTime getLocalTime() {
		return time;
	}

	public void setLocalTime(LocalTime localTime) {
		this.time = localTime;
	}

	public LocalDate getLocalDate() {
		return date;
	}

	public void setLocalDate(LocalDate localDate) {
		this.date = localDate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	

}
