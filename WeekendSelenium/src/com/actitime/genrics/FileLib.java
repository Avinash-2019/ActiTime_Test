package com.actitime.genrics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileLib {
	
	/**
	 * this method is used to get Data from property file. 
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
 public  String getPropperty(String key) throws IOException{
	 FileInputStream fis =new FileInputStream("C:\\Users\\user\\Desktop\\User_Data.property");
	 Properties p=new Properties();
	 p.load(fis);
	 String Value = p.getProperty(key);
	return Value;
 }
 
/**
 * this method is used to get Data from excel sheet.
 * 
 * @param Sheetname
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
 public  String getExcelValue(String Sheetname, int row ,int cell) throws EncryptedDocumentException, IOException{
	 FileInputStream fis=new FileInputStream(" ");
	 Workbook wb=WorkbookFactory.create(fis);
	String Value = wb.getSheet(Sheetname).getRow(0).getCell(1).getStringCellValue();
	return Value; 
 }
 
 public void WritetoExcelSheet(String Sheetname, int row, int cell ,String Value) throws EncryptedDocumentException, IOException{
	 FileInputStream fis=new FileInputStream(" ");
	 Workbook wb = WorkbookFactory.create(fis);
	 wb.getSheet(Sheetname).getRow(0).getCell(1).setCellValue(Value);
	 FileOutputStream fos= new FileOutputStream(" ");
	 wb.write(fos);
	 wb.close();
	 
 }
 public void implicitWait(WebDriver driver){
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
 public void excplicitWait(WebDriver driver ){
	
	WebDriverWait wait = new WebDriverWait(driver,30);
 }
 
}
