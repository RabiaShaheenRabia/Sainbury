package com.sainsbury.fruits.ripe_fruits;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.commons.io.FileUtils;



public class ProcessTest {

	Process process = new Process();
	//String jsonObject = {"result":[{"Description":"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...","PricePerMeasure":0.45,"Title":"Sainsbury's Kiwi Fruit, Ripe & Ready x4","PricePerUnit":1.8},{"Description":"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...","PricePerMeasure":0.45,"Title":"Sainsbury's Kiwi Fruit, Ripe & Ready x4","PricePerUnit":1.8},{"Description":"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...","PricePerMeasure":0.45,"Title":"Sainsbury's Kiwi Fruit, Ripe & Ready x4","PricePerUnit":1.8},{"Description":"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...","PricePerMeasure":0.45,"Title":"Sainsbury's Kiwi Fruit, Ripe & Ready x4","PricePerUnit":1.8},{"Description":"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...\"\,\"PricePerMeasure\"\:0.45\,\"Title\"\:\"Sainsbury's Kiwi Fruit\, Ripe & Ready x4\"\,\"PricePerUnit\":1.8\}\,\{\"Description\":\"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...\"\,\"PricePerMeasure\"\:0.45\,\"Title\:\"Sainsbury's Kiwi Fruit, Ripe & Ready x4\"\,\"PricePerUnit\"\:1.8\}\,\{\"Description\"\:\"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...\"\,\"PricePerMeasure\"\:0.45\,\"Title\"\:\"Sainsbury's Kiwi Fruit, Ripe & Ready x4\",\"PricePerUnit\"\:1.8\}\],\"total\"\:15.100000000000001\\}";
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		process.processHtmlJson("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html","../productsTestJSON.txt");
		
		File file1 = new File("../productsTestJSON.txt");
		File file2 = new File("../productsCorrectFile.txt");
		

		boolean compare1and2=true;
		try {
			compare1and2 = FileUtils.contentEquals(file1, file2);
		} catch (IOException e) {
			e.getMessage();
		}
		
		
		assertTrue(compare1and2);
		
	}

}
