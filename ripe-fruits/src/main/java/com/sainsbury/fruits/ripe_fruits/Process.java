package com.sainsbury.fruits.ripe_fruits;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author Rabia Shaheen
 *
 */
public class Process {

	final Logger logger = LoggerFactory.getLogger(Process.class);
	
	
	/**
	 * 
	 * @param webAddress
	 * @param filePath
	 */
	void processHtmlJson(String webAddress,String filePath){
		logger.info("**** Enter in processHtmlJson method **** ");
		HTMLProcessor hTMLProcessor = new HTMLProcessor();
		JSONFileGenerator jsonFileGenerator = new JSONFileGenerator();
		HashMap<Integer, Product> products=null;
		JSONObject jSONObject = null;
		Document doc = hTMLProcessor.processHTML(webAddress);
    	if (doc!=null){
    		products = hTMLProcessor.populateProduct(doc);
    		if (products!=null && products.size()>0)
    			jSONObject = jsonFileGenerator.populateJSONObject(products);
    		else 
    			GenerateWarningMessage("**** Product Size=0 or null !! Can't Proceed further **** ");
    		if (jSONObject!=null && jSONObject.size()>0)
    			jsonFileGenerator.generateJSONFile(jSONObject,filePath);
    		else 
    			GenerateWarningMessage("**** jSONObject Size=0 or null !! Can't Proceed further **** ");	
    	}
    	else 
    		GenerateWarningMessage("**** Doc File not Generated successfully!! Can't Proceed further **** ");	
    	
    	logger.info("**** Leave processHtmlJson method **** ");
	}
	
	/**
	 *
	 * 
	*/ 
	 void GenerateWarningMessage(String message){
		 logger.warn(message);System.exit(0);
	 }
}
