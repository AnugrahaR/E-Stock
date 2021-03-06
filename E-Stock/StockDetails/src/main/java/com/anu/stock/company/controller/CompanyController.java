package com.anu.stock.company.controller;


import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anu.stock.company.model.Company;
import com.anu.stock.company.repository.CompanyRepository;

@RestController
@RequestMapping("/api/v1.0/market/company/")
public class CompanyController {
	
	private static final Logger logger = LogManager.getLogger(CompanyController.class.getName());
	
	@Autowired
	CompanyRepository repo;
	
	//private static final Logger LOG = LoggerManager
	@PostMapping("register")
	public void registerCompany(@RequestBody Company cmpy) {
		repo.save(cmpy);
		logger.log(Level.INFO, cmpy.getCode()+"  "+cmpy.getName());
	}
	
	@GetMapping("info/{companycode}")
	public Company getCompany(@PathVariable  int companycode) {
		return repo.getByCode(companycode);	
		
	}
	@GetMapping("/getall")
	public List<Company> getAllCompany(){
		
		
		return repo.findAll();
		
	}

}
