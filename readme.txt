1. ripe-fruits is an application that reads webPage using Jsoup.
2. Controller is main class that contains main method.
3. This application is maven based application, All dependencies being resolved by using pom.xml.
4. After retrieval of products JSON file is created and that is saved in parent folder of ripe-fruits application with following name. 
productsJSON.txt

Test case

Integrated Test is implemented that is covering nearly all methods
This test case retrieves products from web page and generates JSON file containing products.
There is file that already contains products.
Contents of both files are compared.
Following are Test Files names and are in parent folder of ripe-fruits application.
1. productsCorrectFile.txt  
2. productsTestJSON.txt