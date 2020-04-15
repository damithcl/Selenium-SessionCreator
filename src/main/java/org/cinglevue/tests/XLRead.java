package org.cinglevue.tests;



import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLRead {
	
	
	private static int rowCount;
	static HashMap<String,String> domainList = new HashMap<String, String>();
    public static HashMap<String,String> readXcel (String filePath,String fileName,String sheetName) throws IOException{

    //Create an object of File class to open xlsx file

    	  File file =    new File(filePath+"/"+fileName);

    //Create an object of FileInputStream class to read excel file

    FileInputStream inputStream = new FileInputStream(file);

    Workbook workbook = null;

    //Find the file extension by splitting file name in substring  and getting only extension name

    String fileExtensionName = fileName.substring(fileName.indexOf("."));

    //Check condition if the file is xlsx file

    if(fileExtensionName.equals(".xlsx")){

    //If it is xlsx file then create object of XSSFWorkbook class

    workbook = new XSSFWorkbook(inputStream);


    }

    //Check condition if the file is xls file

    else if(fileExtensionName.equals(".xls")){

        //If it is xls file then create object of HSSFWorkbook class

        workbook = new HSSFWorkbook(inputStream);

    }

    //Read sheet inside the workbook by its name

    Sheet sheet = workbook.getSheet(sheetName);

    //Find number of rows in excel file

     rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

    //Create a loop over all the rows of excel file to read it

    for (int i = 0; i < rowCount+1; i++) {

        Row row = sheet.getRow(i);

        //Create a loop to print cell values in a row

       // for (int j = 0; j < row.getLastCellNum();) {


           // domainList.add(row.getCell(j).getStringCellValue());
            domainList.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());

       // }
    } 
    
    return domainList;

    }  
    
    public static int getRowCount(String filePath,String fileName,String sheetName) throws IOException {
        //Create an object of File class to open xlsx file

  	  File file =    new File(filePath+"/"+fileName);

  //Create an object of FileInputStream class to read excel file

  FileInputStream inputStream = new FileInputStream(file);

  Workbook workbook = null;

  //Find the file extension by splitting file name in substring  and getting only extension name

  String fileExtensionName = fileName.substring(fileName.indexOf("."));

  //Check condition if the file is xlsx file

  if(fileExtensionName.equals(".xlsx")){

  //If it is xlsx file then create object of XSSFWorkbook class

  workbook = new XSSFWorkbook(inputStream);


  }

  //Check condition if the file is xls file

  else if(fileExtensionName.equals(".xls")){

      //If it is xls file then create object of HSSFWorkbook class

      workbook = new HSSFWorkbook(inputStream);

  }

  //Read sheet inside the workbook by its name

  Sheet sheet = workbook.getSheet(sheetName);

  //Find number of rows in excel file

   return rowCount = sheet.getLastRowNum()+1;

    }


}