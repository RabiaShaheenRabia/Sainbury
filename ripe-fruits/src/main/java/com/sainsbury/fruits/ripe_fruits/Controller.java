package com.sainsbury.fruits.ripe_fruits;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author Rabia Shaheen
 *
 */
public class Controller 
{
	 final static Logger logger = LoggerFactory.getLogger(Controller.class);
	 
    /**
     * 
     * @param args
     */
	public static void main( String[] args )
    {
		logger.info("**** Enter in main method **** ");
		
		
		if(args!=null && args.length>0){
			Process process = new Process();
			process.processHtmlJson(args[0],args[1]);
		}
		else {
			logger.info("**** Please enter arguments - First web address than folder where you want your output jason file  **** ");
			System.exit(0);
		}
		//Process process = new Process();
		//process.processHtmlJson("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html", "../productsJSON.txt");
		
		logger.info("**** Leave main method **** ");
		
    }
}
