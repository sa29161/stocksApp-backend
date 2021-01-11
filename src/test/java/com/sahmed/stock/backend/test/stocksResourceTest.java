package com.sahmed.stock.backend.test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sahmed.stock.backend.controllers.stocksResource;
import com.sahmed.stock.backend.services.stocksService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = stocksResource.class)
public class stocksResourceTest {

	@Mock
	private stocksService service;

	@Autowired
	private MockMvc mockMvc;

	private String ticker = "TEST";

	@Test
	public void testGetStock() throws Exception {

		when(service.getStocks(ticker)).thenReturn("something");

		mockMvc.perform(get("/stocks")).andExpect(status().isOk()).andExpect((content().string(equalTo("something"))));

		verify(service).getStocks(ticker);
	}

	@Test
	public void testGetStockNullTicker() throws Exception {
		mockMvc.perform(get("/stocks")).andExpect(status().isBadRequest());
		verify(service, times(0)).getStocks(ticker);
	}

	@After
	public void verifyNoMoreInteractions() {
		Mockito.verifyNoMoreInteractions(service);
	}

}
