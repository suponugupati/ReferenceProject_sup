package com.cucumber.framework.helpers.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataHelper {
	static int rowIndex = 0;
	static int rowCount;
	static int passRowCount;
	public static HashMap<String,String> storeValues = new HashMap();
	   public static List<HashMap<String,String>> data(String filepath,String sheetName)
	   {
	      List<HashMap<String,String>> mydata = new ArrayList<>();
	      try
	      {
	         FileInputStream fs = new FileInputStream(filepath);
	         XSSFWorkbook workbook = new XSSFWorkbook(fs);
	         XSSFSheet sheet = workbook.getSheet(sheetName);
	         Row HeaderRow = sheet.getRow(0);
	         for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
	         {
	            Row currentRow = sheet.getRow(i);
	            //System.out.println("CURRENT CELLS IN THE ROWWW  "+currentRow.getPhysicalNumberOfCells());
	            HashMap<String,String> currentHash = new HashMap<String,String>();
	            for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
	            {
	               Cell currentCell = currentRow.getCell(j);
	               switch (currentCell.getCellType())
	               {
	               case Cell.CELL_TYPE_STRING:
	                  currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
	                  break;
	               case Cell.CELL_TYPE_NUMERIC:
	            	   currentHash.put(HeaderRow.getCell(j).getStringCellValue(), Integer.toString((int)(currentCell.getNumericCellValue())));
	               }
	            }
	            mydata.add(currentHash);
	         }
	         fs.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return mydata;
	   }
	   
	   public static String getRegisteredUser(String regUser){
		   return getDataFor("LoginCredentials",regUser, "email");
	   }
	   
	   public static String getPassword(String regUserPwd){
		   return getDataFor("LoginCredentials",regUserPwd, "password");
	   }
	   
	   public static String getProduct(String productType){
		   return getDataFor("Products",productType, "productArticle");
	   }
	   public static String getZipcode(String productType){
		   return getDataFor("Products",productType, "zipCode");
	   }
	   public static String getGlobalNotifZipcode(String zipCodeInfo){
		   return getDataFor("GlobalNotifications",zipCodeInfo, "zipCode");
	   }
	   
	   public static String getCardNumber(String cardType){
		   return getDataFor("CreditCards",cardType, "cardNumber");
	   }
	   
	   public static String getCardCVV(String cardType){
		   return getDataFor("CreditCards",cardType, "cvv");
	   }
	   public static String getCardExpMonth(String cardType){
		   return getDataFor("CreditCards",cardType, "expiryMonth");
	   }
	   public static String getCardExpYear(String cardType){
		   return getDataFor("CreditCards",cardType, "expiryYear");
	   }
	   public static String getGiftCard(String cardWorth){
		   return getDataFor("GiftCards",cardWorth, "cardNumber");
	   }
	   public static String getDiscount(String cardNum){
		   return getDataFor("DiscountCards",cardNum, "discntCardNumber");
	   }
	   public static String getPageURL(String cardNum){
		   return getDataFor("PageUrls",cardNum, "pageURL");
	   }
	   public static String getPageMetaDescription(String pageName){
		   return getDataFor("SEOMetaDesc",pageName, "metaDescription");
	   }
	   public static String getPageMetaTitle(String pageName){
		   return getDataFor("SEOTitles",pageName,"pageTitle");
	   }
	   public static String getPageURLForMetaTitle(String pageName){
		   return getDataFor("SEOTitles",pageName,"pageUrl");
	   }
	   public static String getECCStoreId(String storeId){
		   return getDataFor("eccStoreMapping",storeId, "eccstoreid");
	   }
	   
	   public static String getStateName(String stateId){
		   return getDataFor("StateAbbreviation",stateId, "stateName");
	   }
	   
	   public static String getDataFor(String sheetName,String arg1, String arg2){
		   List<HashMap<String,String>> datamap;
		   String cellValue= null;
		   datamap = DataHelper.data(System.getProperty("user.dir")+"//src//test//resources//testData//default.xlsx",sheetName);
	    	int siz = datamap.size();
	    	for(int i =0;i<siz;i++){
	    		String param=datamap.get(i).get("parameter").toString().trim();
	    		//System.out.println("param param param "+param);
	    		//System.out.println("arg1 arg1 arg1 "+arg1 );
	    		if(param.equalsIgnoreCase(arg1)){
	    			//System.out.println("INSIDEEEEEEEEEEEEEEE IFFFFFFFFFFFFFFf ");
	    			cellValue = datamap.get(i).get(arg2);
	    		}
	    	}
	    	if(cellValue==null){
	    		cellValue = "";
	    	}
	    	return cellValue;
	   }
	   
	   public static void setData(String scenario, String orderNum, String orderDate) throws IOException, InterruptedException{
		   
		   //FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//testData//Output//output.xlsx");
		   FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/testData/Output/output.xlsx");
	         XSSFWorkbook workbook1 = new XSSFWorkbook(fs);
	         
	         //readExcel(System.getProperty("user.dir")+"//src//test//resources//testData//Output//output.xlsx", "output");
	         readExcel(System.getProperty("user.dir")+"/src/test/resources/testData/Output/output.xlsx", "output");
	         Row row = sheet.createRow(++rowCount);
	         int columnCount =0;
	         row.createCell(columnCount++).setCellValue(scenario);
	         row.createCell(columnCount++).setCellValue(orderNum);
	         row.createCell(columnCount++).setCellValue(orderDate);
	         FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/src/test/resources/testData/Output/output.xlsx");
	         //FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"//src//test//resources//testData//Output//output.xlsx");
	         workBook.write(fos);
	         fos.close();
	   }
	   public static void metaTitlesResults(String pageName, String expectedTitle, String actualTitle, String result) throws IOException, InterruptedException{
		   FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//testData//Output//metatitleresults.xlsx");
	         XSSFWorkbook workbook1 = new XSSFWorkbook(fs);
	         
	         readExcel(System.getProperty("user.dir")+"//src//test//resources//testData//Output//metatitleresults.xlsx", "metatitleresults");
	         Row row = sheet.createRow(++rowCount);
	         int columnCount =0;
	         row.createCell(columnCount++).setCellValue(pageName);
	         row.createCell(columnCount++).setCellValue(expectedTitle);
	         row.createCell(columnCount++).setCellValue(actualTitle);
	         row.createCell(columnCount++).setCellValue(result);
	         FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"//src//test//resources//testData//Output//metatitleresults.xlsx");
	         workBook.write(fos);
	         fos.close();
		   
	   }
	   public static void publishVertexTaxResults(String State,String City,String Zip,Double TotalAmount,Double TaxRate,String ActualCart, String ExpectedCart, String Result, String ActualChkOut, String ExpectedChkOut, String ChkResult) throws IOException, InterruptedException{
		   
		   FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//testData//taxcalculations.xlsx");
	         XSSFWorkbook workbook1 = new XSSFWorkbook(fs);
	         
	         readExcel(System.getProperty("user.dir")+"//src//test//resources//testData//taxcalculations.xlsx", "Results");
	         Row row = sheet.createRow(++rowCount);
	         int columnCount =1;
	         row.createCell(columnCount++).setCellValue(State);
	         row.createCell(columnCount++).setCellValue(City);
	         row.createCell(columnCount++).setCellValue(Zip);
	         row.createCell(columnCount++).setCellValue(TotalAmount);
	         row.createCell(columnCount++).setCellValue(TaxRate);
	         row.createCell(columnCount++).setCellValue(ActualCart);
	         row.createCell(columnCount++).setCellValue(ExpectedCart);
	         row.createCell(columnCount++).setCellValue(Result);
	         row.createCell(columnCount++).setCellValue(ActualChkOut);
	         row.createCell(columnCount++).setCellValue(ExpectedChkOut);
	         row.createCell(columnCount++).setCellValue(ChkResult);
	         FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"//src//test//resources//testData//taxcalculations.xlsx");
	         workBook.write(fos);
	         fos.close();
	   }
	   
	   public static void publishOrderDetFromHybBackOffice(String orderDate, String orderNum,String HybrisCustomerID, String ECCCustomerID, String UserType, String Cust_FristName, String Cust_LastName, String EmailID, 
			   String PhoneNumber, String Billing_FirstName, String Billing_LastName, String Billing_EmailID, String Billing_PhoneNumber, String BillingAddress,
			   String productName, String SKUDetails,
			   String delivery_Code, String delivery_Name, String Shipping_FristName, String Shipping_LastName, String Shipping_emailID, String Shipping_phoneNumber, 
			   String ShippingAddress, String PaymentDetails, String PickUpLocation, String ProfitCenter, String StoreVisited, String SpecialInstructions, 
			   String WhoHelpedInStore, String Subtotal, String GoofProofFee, String RecyclingFee, String ShippingFee, String TaxFee ,
			   String OrderTotal) throws IOException, InterruptedException{
		   
		   FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//testData//Output//hybrisBackofficeOrderData.xlsx");
	         XSSFWorkbook workbook1 = new XSSFWorkbook(fs);
	         
	         readExcel(System.getProperty("user.dir")+"//src//test//resources//testData//Output//hybrisBackofficeOrderData.xlsx", "OrderDetails");
	         Row row = sheet.createRow(++rowCount);
	         int columnCount =2;
	         row.createCell(columnCount++).setCellValue(orderDate);
	         row.createCell(columnCount++).setCellValue(orderNum);
	         columnCount =5;
	         row.createCell(columnCount++).setCellValue(HybrisCustomerID);
	         row.createCell(columnCount++).setCellValue(ECCCustomerID);
	         columnCount =10;
	         row.createCell(columnCount++).setCellValue(UserType);
	         row.createCell(columnCount++).setCellValue(Cust_FristName);
	         row.createCell(columnCount++).setCellValue(Cust_LastName);
	         row.createCell(columnCount++).setCellValue(EmailID);
	         row.createCell(columnCount++).setCellValue(PhoneNumber);
	         row.createCell(columnCount++).setCellValue(Billing_FirstName);
	         row.createCell(columnCount++).setCellValue(Billing_LastName);
	         row.createCell(columnCount++).setCellValue(Billing_EmailID);
	         row.createCell(columnCount++).setCellValue(Billing_PhoneNumber);
	         row.createCell(columnCount++).setCellValue(BillingAddress);
	         row.createCell(columnCount++).setCellValue(productName);
	         row.createCell(columnCount++).setCellValue(SKUDetails);
	         
	         row.createCell(columnCount++).setCellValue(delivery_Code);
	         row.createCell(columnCount++).setCellValue(delivery_Name);
	         row.createCell(columnCount++).setCellValue(Shipping_FristName);
	         row.createCell(columnCount++).setCellValue(Shipping_LastName);
	         row.createCell(columnCount++).setCellValue(Shipping_emailID);
	         row.createCell(columnCount++).setCellValue(Shipping_phoneNumber);
	         row.createCell(columnCount++).setCellValue(ShippingAddress);
	         row.createCell(columnCount++).setCellValue(PaymentDetails);
	         row.createCell(columnCount++).setCellValue(PickUpLocation);
	         row.createCell(columnCount++).setCellValue(ProfitCenter);
	         row.createCell(columnCount++).setCellValue(StoreVisited);
	         row.createCell(columnCount++).setCellValue(SpecialInstructions);
	         row.createCell(columnCount++).setCellValue(WhoHelpedInStore);
	         row.createCell(columnCount++).setCellValue(Subtotal);
	         row.createCell(columnCount++).setCellValue(GoofProofFee);
	         row.createCell(columnCount++).setCellValue(RecyclingFee);
	         row.createCell(columnCount++).setCellValue(ShippingFee);
	         row.createCell(columnCount++).setCellValue(TaxFee);
	         row.createCell(columnCount++).setCellValue(OrderTotal);
	         FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"//src//test//resources//testData//Output//hybrisBackofficeOrderData.xlsx");
	         workBook.write(fos);
	         fos.close();
	   }
	   
	   static Sheet sheet;
       static Workbook workBook = null;
	   
	   public static void readExcel(String filePath, String sheetName) throws IOException, InterruptedException {
		   FileInputStream inputStream = new FileInputStream(filePath);
		   workBook = new XSSFWorkbook(inputStream);
		   sheet = workBook.getSheet(sheetName);
		   rowCount = (sheet.getLastRowNum()) - (sheet.getFirstRowNum());
		   setRowCount(rowCount);
	   }
	   public static  void setRowCount(int rc){
           passRowCount =rc;
       }
       public  int getRowCount(){
           return passRowCount;
       }
       
  }

