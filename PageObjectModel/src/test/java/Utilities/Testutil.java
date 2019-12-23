package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseClass.testbase;

public class Testutil extends testbase{
	//To read data from excel file
	 static ExcelReader excel ;
	public static ArrayList<Object[]> getDataFromExcel(){
		String SheetName="Registration";
		ArrayList<Object[]> mydata=new ArrayList<Object[]>();
	try {
		 excel=new ExcelReader("C:\\kowsika\\LEARNING\\Projects\\Selenium\\Data driven\\src\\resources\\Excel\\AccountCreation.xlsx");
	}catch(Exception e) {
		e.printStackTrace();
	}
		
		for(int rownum=2; rownum<=excel.getRowCount(SheetName);rownum++) {
			String FirstName=excel.getCellData(SheetName, "FirstName", rownum);
			String LastName=excel.getCellData(SheetName, "LastName", rownum);
			String password=excel.getCellData(SheetName, "password", rownum);
			String DateofBirth=excel.getCellData(SheetName, "DateofBirth", rownum);
			String Email=excel.getCellData(SheetName, "Email", rownum);
			String Address=excel.getCellData(SheetName, "Address", rownum);
			String City=excel.getCellData(SheetName, "city", rownum);
			String state=excel.getCellData(SheetName, "state", rownum);
			String postcode=excel.getCellData(SheetName, "postcode", rownum);
			String country=excel.getCellData(SheetName, "country", rownum);
			String mobileno=excel.getCellData(SheetName, "mobileno", rownum);
			String AddressFuRef=excel.getCellData(SheetName, "AddressFuRef", rownum);
			Object ob[]= {FirstName,LastName,password,DateofBirth,Email,Address,City,state,postcode,country,mobileno,AddressFuRef};
			mydata.add(ob);
			}
	return mydata;
		
	}
	//To capture the Screenshot
	public static String screenshotpath;
	public static String screenshotname;
	public static void captureScreenshot() throws IOException {
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d= new Date();
		screenshotname=d.toString().replace(":","").replace("","")+ "pass.jpg";
	    FileUtils.copyFile(scrFile,  new File(System.getProperty("user.dir")+"\\test-output\\html\\"+screenshotname));
	
	}
	
	

}
