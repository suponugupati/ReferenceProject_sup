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

public class ReadExcel {
	
	public static HashMap<String,HashMap<String,String>> storedValues = new HashMap();
	   public static HashMap<String,HashMap<String,String>> data(String filepath,String sheetName)
	   {
	      HashMap<String,HashMap<String,String>> data = new HashMap<>();
	      try
	      {
	         FileInputStream fs = new FileInputStream(filepath);
	         XSSFWorkbook workbook = new XSSFWorkbook(fs);
	         XSSFSheet sheet = workbook.getSheet(sheetName);
	         Row HeaderRow = sheet.getRow(0);
	         for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
	         {
	            Row currentRow = sheet.getRow(i);
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
	           data.put(currentRow.getCell(0).getStringCellValue(),currentHash);
	         }
	         fs.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return data;
	   }
	   
	   
	   
	   public static String getData(String sheetName,String rowName, String ColumnName){
		   String cellValue= null;
		   if(!storedValues.containsKey(rowName)) {
		   storedValues = ReadExcel.data(System.getProperty("user.dir")+"//src//test//resources//testData//datasheet.xlsx",sheetName);
		   }
	    	if(storedValues.containsKey(rowName)) {
	    		if(storedValues.get(rowName).containsKey(ColumnName)) {
	    			cellValue=storedValues.get(rowName).get(ColumnName);
	    		}
	    	}
	    	
	    	if(cellValue==null){
	    		cellValue = "";
	    	}
	    	return cellValue;
	   }
	   
	   
	   
	   
  }

