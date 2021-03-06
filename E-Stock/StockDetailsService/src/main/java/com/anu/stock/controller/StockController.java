package com.anu.stock.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anu.stock.dto.ResponseVO;
import com.anu.stock.model.Stock;
import com.anu.stock.repository.StockRepository;


@RestController
@RequestMapping("/api/v1.0/market/stock/")
public class StockController {
	
	  private static final Log LOG = LogFactory.getLog(StockController.class);

	@Autowired
	StockRepository repo;
	@Autowired
	private RestTemplate rest;

	@RequestMapping(value = "/add/{companycode}", method = RequestMethod.POST)
	public void addStockPrice(@PathVariable int companycode, @RequestBody Double price) {

		ResponseVO response = rest.getForObject("http://COMPANYDETAILS/api/v1.0/market/company/info/{companycode}",
				ResponseVO.class, companycode);

		Stock stck = new Stock(companycode, response.getName(), price);

		repo.save(stck);
		LOG.info("Stock details created"+ stck.toString());
		
	

	}

	@GetMapping("get/{companycode}/{startdate}/{enddate}")
	public List<Stock> getStocks(@PathVariable int companycode, @PathVariable LocalDate startdate,
			@PathVariable LocalDate enddate) {

		return repo.getByCompanyCodeAndDateBetween(companycode, startdate, enddate);
	}

	@GetMapping("getAll")
	public List<Stock> getAllStocks() {
		return repo.findAll();
	}

}
