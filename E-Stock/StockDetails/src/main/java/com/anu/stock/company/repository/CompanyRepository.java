package com.anu.stock.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu.stock.company.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	public Company getByCode(int code);
	
	public List<Company> findAll();
}
