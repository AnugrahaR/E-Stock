package com.anu.stock.company.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int code;
	private String name;
	private String ceo;
	private int turnover;
	private String stockExchange;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public int getTurnover() {
		return turnover;
	}
	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ceo == null) ? 0 : ceo.hashCode());
		result = prime * result + code;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stockExchange == null) ? 0 : stockExchange.hashCode());
		result = prime * result + turnover;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (ceo == null) {
			if (other.ceo != null)
				return false;
		} else if (!ceo.equals(other.ceo))
			return false;
		if (code != other.code)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stockExchange == null) {
			if (other.stockExchange != null)
				return false;
		} else if (!stockExchange.equals(other.stockExchange))
			return false;
		if (turnover != other.turnover)
			return false;
		return true;
	}
	
	
	
}
