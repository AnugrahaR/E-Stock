package com.anu.company.controller;


import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anu.company.model.Company;
import com.anu.company.repository.CompanyRepository;

@RestController
@RequestMapping("/api/v1.0/market/company/")
public class CompanyController {
	
	private static final Logger logger = LogManager.getLogger(CompanyController.class.getName());
	
	@Autowired
	CompanyRepository repo;
	@Autowired
	private RestTemplate rest;
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
	@DeleteMapping ("delete/{companycode}")
	public void deleteCompany(int code) {
		rest.delete("http://STOCKDETAILS/api/v1.0/market/stock/delete/{companycode}", code);
		repo.deleteByCode(code);
	}

	
	@GetMapping("getall")
	public List<Company> getAllCompany(){
		
		
		return repo.findAll();
		
	}

}
