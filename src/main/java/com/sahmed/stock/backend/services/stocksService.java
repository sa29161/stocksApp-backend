package com.sahmed.stock.backend.services;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class stocksService {

	private RestTemplate template = new RestTemplate();
	
	private final String apiKey = "69VI8RZRMR2EMJPN";
	
	private final String polyApiKey = "y8SusbPohQxKoARjZCl6f_AbqYQy2nQe";
	
	private final String newsKey = "f1aed6c4e0f54012bde8e4093a59eb38";

	public String getStocks(String stock) {
		String info = template.getForObject("https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords="+stock+
				"&apikey="+apiKey, String.class);

		return info;
	}
	
	public String getInfo(String stock) {
		String info = template.getForObject("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol="
				+stock+"&apikey="+apiKey,String.class);

		return info;
	}
	
	public String getCompanyInfo(String stock) {
		String info = template.getForObject("https://api.polygon.io/v2/aggs/ticker/"+stock+
				"/prev?unadjusted=true&apiKey="+polyApiKey,String.class);

		return info;
	}
	
	public String getNews(String stock) {
		String info = template.getForObject("https://newsapi.org/v2/everything?q="+stock+" stock"+
				"&apiKey="+newsKey,String.class);

		return info;
	}
	
	public String getChart(String stock) {
		String info = template.getForObject("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="
	+stock+"&interval=5min&apikey="+apiKey,String.class);

		return info;
	}

}