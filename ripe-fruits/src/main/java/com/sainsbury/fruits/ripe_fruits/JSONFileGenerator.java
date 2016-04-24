package com.sainsbury.fruits.ripe_fruits;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Rabia Shaheen
 *
 */
public class JSONFileGenerator {

	final Logger logger = LoggerFactory.getLogger(JSONFileGenerator.class);
	
	/**
	 * 
	 * @param productMap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	JSONObject populateJSONObject(HashMap<Integer, Product> productMap){

		logger.info("**** Enter in populateJSONObject method **** ");

		JSONObject obj = null;
		JSONObject resultObj = new JSONObject();
		JSONArray prodJSONArray = new JSONArray();
		if(productMap!=null && productMap.size()>0){
			for(int i=0;i<productMap.size();i++){
				Product prod = productMap.get(i);
				obj = new JSONObject();
				obj.put("Title", prod.getTitle());
				obj.put("PricePerUnit", prod.getPricePerUnit());
				obj.put("PricePerMeasure", prod.getPricePerMeasure());
				obj.put("Description", prod.getDescription());
				prodJSONArray.add(i,obj);
			}
		}
		logger.info("**** All Products " + prodJSONArray);
		resultObj.put("results", prodJSONArray);
		TotalPricePerUnit totalPricePerUnit = new TotalPricePerUnit();
		resultObj.put("total", totalPricePerUnit.computeTotal(productMap));
		logger.info("**** Leave populateJSONObject method **** ");
		return resultObj;
	}
	/**
	 * 
	 * @param resultObj
	 */
	void generateJSONFile(JSONObject resultObj,String filePath){
		logger.info("**** Enter in generateJSONFile method **** ");
		
		FileWriter file = null;
		try {
			file = new FileWriter(filePath);
			file.write(resultObj.toJSONString());
			file.flush();
		} catch (IOException e1) {
			logger.warn("**** generateJSONFile" + e1.getMessage());
		}
		logger.info("**** Leave generateJSONFile method **** ");
	}
	
}
