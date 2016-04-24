package com.sainsbury.fruits.ripe_fruits;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Rabia Shaheen
 *
 */
public class HTMLProcessor {

	HashMap<Integer, Product> productMap;
	
	final Logger logger = LoggerFactory.getLogger(HTMLProcessor.class);
	
	/**
	 * 
	 * @return Document 
	 */
	Document processHTML(String webAddress){
		logger.info("**** Enter in processHTML method **** ");
		Document doc = null;
    	try {
			doc = (Document) Jsoup.connect(webAddress).get();
		} catch (IOException e) {
			e.getMessage();
		}
    	logger.info("**** Leave processHTML method **** ");
		return doc;
	}
	
	/**
	 * 
	 * @param doc
	 * @return
	 */
	HashMap<Integer, Product> populateProduct(Document doc){
		logger.info("**** Enter in populateProduct method **** ");
		Elements products = doc.getElementsByClass("product");

		productMap = new HashMap<Integer, Product>();
		Product product;
		
		for(int i=0; i<products.size();i++){
			product = new Product();
			Elements link = products.get(i).getElementsByTag("a");
			String linkText =(link.text().length() > 0) ? link.text() : ""; 
			Elements pricing =products.get(i).getElementsByClass("pricing") ;
			SetPricing(product,  pricing);
			product.setDescription("Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...");
			product.setTitle(linkText);
			productMap.put(i,product);
		}
		logger.info("**** Leave populateProduct method **** ");
		return productMap;
	}
/**
 * 
 * @param product
 * @param parts
 * @param pricing
 */
	private void SetPricing(Product product,Elements pricing) {
		String[] parts=null;
		String pricingText = pricing.get(0).text(); //&pound3.50/unit &pound0.70/ea
		if (pricingText.contains("/")  )
			parts = pricingText.split("/");
		else 
		{
			product.setPricePerUnit(0.0);
			product.setPricePerMeasure(0.0);
			return;
		}
		if (parts[0].contains("&pound"))
			product.setPricePerUnit(new Double(parts[0].replace("&pound", "")));
		else 
			product.setPricePerUnit(0.0);
		
		if (parts[1].contains("unit &pound"))
			product.setPricePerMeasure(new Double(parts[1].replace("unit &pound", "")));
		else
			product.setPricePerMeasure(0.0);
		
	}
	
	
	
}
