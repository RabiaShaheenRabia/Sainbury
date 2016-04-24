1. ripe-fruits is an application that reads webPage using Jsoup.
2. Controller is main class that contains main method.
3. This application is maven based application, All dependencies being resolved by using pom.xml.
4. After retrieval of products from web address provided, JSON file is created and that is saved in parent folder of ripe-fruits application with following name. 
productsJSON.txt

Test case

Integrated Test is implemented that is covering nearly all methods
This test case retrieves products from web page and generates JSON file containing products.
There is file that already contains products.
Contents of both files are compared.
Following are Test Files names and are in parent folder of ripe-fruits application.
1. productsCorrectFile.txt  
2. productsTestJSON.txt

There is folder named ProjectWithJarAndScriptFile that contains jar file and script batch file.
As this project will be executed by providing two parameters to main Controller File.

Following is batch file content 
jar file = ripe-fruits-0.0.1-SNAPSHOT-jar-with-dependencies.jar
Controller class contains main method.
First Argument for main method = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html"
second Argument for main method = output file path  

java -cp ripe-fruits-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.sainsbury.fruits.ripe_fruits.Controller "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html" "../productsJSON.txt"


On execution of above batch file, Following is output:
C:\Users\RabiaShaheen\Desktop\ProjectWithJarAndScriptFile>java -cp ripe-fruits-0.0.1-SNAPSHOT-jar-with-dependencies.jar com.sainsbury.fruits.ripe_fruits.Controller "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html" "../productsJSON.txt"
[main] INFO com.sainsbury.fruits.ripe_fruits.Controller - **** Enter in main method ****
[main] INFO com.sainsbury.fruits.ripe_fruits.Controller - **** webAddress = http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html
[main] INFO com.sainsbury.fruits.ripe_fruits.Controller - **** fileOutputPath = ../productsJSON.txt
[main] INFO com.sainsbury.fruits.ripe_fruits.Process - **** Enter in processHtmlJson method ****
[main] INFO com.sainsbury.fruits.ripe_fruits.HTMLProcessor - **** Enter in processHTML method ****
[main] INFO com.sainsbury.fruits.ripe_fruits.HTMLProcessor - **** Leave processHTML method ****
[main] INFO com.sainsbury.fruits.ripe_fruits.HTMLProcessor - **** Enter in populateProduct method ****
[main] INFO com.sainsbury.fruits.ripe_fruits.HTMLProcessor - **** Leave populateProduct method ****
[main] INFO com.sainsbury.fruits.ripe_fruits.JSONFileGenerator - **** Enter in populateJSONObject method ****
[main] INFO com.sainsbury.fruits.ripe_fruits.JSONFileGenerator - **** All Products [
{"Description":"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...","PricePerMeasure":0.7,"Title":"Sainsbury's Apricot Ripe & Ready x5","PricePerUnit":3.5},
{"Description":"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...","PricePerMeasure":1.5,"Title":"Sainsbury's Avocado Ripe & Ready XL Loose 300g","PricePerUnit":1.5},
{"Description":"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...","PricePerMeasure":1.8,"Title":"Sainsbury's Avocado, Ripe & Ready x2","PricePerUnit":1.8},
{"Description":"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...","PricePerMeasure":3.2,"Title":"Sainsbury's Avocados, Ripe & Ready x4","PricePerUnit":3.2},{"Description":"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...","PricePerMeasure":1.5,"Title":"Sainsbury's Conference Pears, Ripe & Ready x4 (minimum)","PricePerUnit":1.5},{"Description":"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...","PricePerMeasure":0.45,"Title":"Sainsbury's Golden Kiwi x4","PricePerUnit":1.8},{"Description":"Great to eat now - refrigerate at home 1 of 5 a day 1 avocado counts as 1 of your 5...","PricePerMeasure":0.45,"Title":"Sainsbury's Kiwi Fruit, Ripe & Ready x4","PricePerUnit":1.8}]
[main] INFO com.sainsbury.fruits.ripe_fruits.TotalPricePerUnit - **** Enter in computeTotal method ****
[main] INFO com.sainsbury.fruits.ripe_fruits.TotalPricePerUnit - **** Leave computeTotal method ****
[main] INFO com.sainsbury.fruits.ripe_fruits.JSONFileGenerator - **** Leave populateJSONObject method ****
[main] INFO com.sainsbury.fruits.ripe_fruits.JSONFileGenerator - **** Enter in generateJSONFile method ****
[main] INFO com.sainsbury.fruits.ripe_fruits.JSONFileGenerator - **** Leave generateJSONFile method ****
[main] INFO com.sainsbury.fruits.ripe_fruits.Process - **** Leave processHtmlJson method ****
[main] INFO com.sainsbury.fruits.ripe_fruits.Controller - **** Leave main method ****

