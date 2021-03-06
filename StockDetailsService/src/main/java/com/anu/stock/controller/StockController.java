package com.anu.stock.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public List<Stock> getStocks(@PathVariable int companycode, @PathVariable String startdate,
			@PathVariable String enddate) {
LocalDate stDate= LocalDate.parse(startdate);
LocalDate edDate= LocalDate.parse(startdate).plusDays(1);

		return repo.getByCompanyCodeAndDateBetween(companycode, stDate, edDate);
	}

	@GetMapping("getAll")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Stock> getAllStocks() {
		return repo.findAll();
	}
	
	@DeleteMapping ("delete/{companycode}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteCompany(int code) {
		rest.delete("http://STOCKDETAILS/api/v1.0/market/stock/delete/{companycode}", code);
		repo.deleteByCompanyCode(code);
	}

}
