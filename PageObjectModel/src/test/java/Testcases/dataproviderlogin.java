package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.testbase;

public class dataproviderlogin extends testbase {
	
	@Test(dataProvider="logindetails")
	public void clicksignin(String Username, String Password) throws InterruptedException, IOException {
		driver.findElement(By.xpath(OR.getProperty("sigin_xpath"))).click();
		driver.findElement(By.cssSelector(OR.getProperty("Email_CSS"))).sendKeys(Username);
		driver.findElement(By.cssSelector(OR.getProperty("Password_CSS"))).sendKeys(Password);
		driver.findElement(By.xpath(OR.getProperty("loginBtn_xpath"))).click();
		String title=driver.getTitle();
		System.out.println("title of the page is"+ title);
		Assert.assertTrue(title.contains("My account - My Store"), "invalid credentials");
		//Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("verifytitle_xpath"))),"Login not successfull");// 
		
		log.debug("login successfull");
		}
	@AfterMethod
		public void teardown() {
			driver.close();
		
	}
	@DataProvider(name="logindetails")
	// create method and mention return type as OBJECT
	public Object[][] passdata()
	{
		//create two dimensional object array(object array is used because if you use string -accepts only string array, integer -accepts only int value, so object array accepts all types of data	
		Object[][] data=new Object[3][2]; //declared array
		data[0][0]="kowshisuman@gmail.com"; //initialized array
		data[0][1]="lovebirds1234";
		data[1][0]="kowshisuman@gmail.com";
		data[1][1]="lovebirds123";
		data[2][0]="kowshisuman@gmail.com";
		data[2][1]="lovebirds1234";
		return data; //Getting the data from the return type Object
	}
	
}
