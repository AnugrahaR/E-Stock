package com.anu.stock.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu.stock.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
	
	
	
	public List<Stock> getByCompanyCodeAndDateBetween(int companyCode, LocalDate date1, LocalDate date2);
	public void deleteByCompanyCode(int code);


}
