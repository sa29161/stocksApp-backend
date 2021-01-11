package com.sahmed.stock.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahmed.stock.backend.services.stocksService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class stocksResource {
	
	@Autowired
	private stocksService service;
	
	
	@RequestMapping(value = "/stocks")
	@ResponseBody
	public ResponseEntity<String> getStock(@RequestParam String stock) throws Exception{
		if(stock == null) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(service.getStocks(stock),HttpStatus.OK);}
	
	@RequestMapping(value = "/info")
	@ResponseBody
	public ResponseEntity<String> getInfo(@RequestParam String stock) throws Exception{
		return new ResponseEntity<String>(service.getInfo(stock),HttpStatus.OK);}
	
	@RequestMapping(value = "/company")
	@ResponseBody
	public ResponseEntity<String> getCompanyInfo(@RequestParam String stock) throws Exception{
		return new ResponseEntity<String>(service.getCompanyInfo(stock),HttpStatus.OK);}
	
	@RequestMapping(value = "/news")
	@ResponseBody
	public ResponseEntity<String> getNews(@RequestParam String stock) throws Exception{
		return new ResponseEntity<String>(service.getNews(stock),HttpStatus.OK);}
	
	@RequestMapping(value = "/chart")
	@ResponseBody
	public ResponseEntity<String> getChart(@RequestParam String stock) throws Exception{
		return new ResponseEntity<String>(service.getChart(stock),HttpStatus.OK);}
	

}


