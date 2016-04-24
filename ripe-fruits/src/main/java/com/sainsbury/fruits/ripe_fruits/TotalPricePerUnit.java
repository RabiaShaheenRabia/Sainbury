package com.sainsbury.fruits.ripe_fruits;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Rabia Shaheen
 *
 */
public class TotalPricePerUnit {
	
	final Logger logger = LoggerFactory.getLogger(TotalPricePerUnit.class);
	

	/**
	 * 
	 * @param productMap
	 * @return
	 */
	double computeTotal(HashMap<Integer, Product> productMap){
		logger.info("**** Enter in computeTotal method **** ");
		double total=0;
		
		for(int i=0;i<productMap.size();i++){
			Product prod = (Product) productMap.get(i);
			total = total+ prod.getPricePerUnit();
		}
		logger.info("**** Leave computeTotal method **** ");
		return total;
	}
}
