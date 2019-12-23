package Testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.testbase;

public class Accountcreation1 extends testbase{
	
	

	@Test
	public void newcustomersignin() throws InterruptedException, IOException {
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		//wait=new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("sigin_xpath"))));
		driver.findElement(By.xpath(OR.getProperty("sigin_xpath"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(OR.getProperty("Email_xpath"))).sendKeys("umaram@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		log.debug("signup form displayed");
	}
	
	@Test
	(dataProvider="getdata")
	public void Entercusdetails(String FirstName, String LastName, String Password, String Email, String Address, String City, String postcode, Integer mobileno, String AddressFUREF) {
		WebElement radioBtn =driver.findElement(By.id(OR.getProperty("Gendername_id")));
		radioBtn.click();
		driver.findElement(By.xpath(OR.getProperty("Firstname_xpath"))).sendKeys("FirstName");
		driver.findElement(By.xpath(OR.getProperty("lastName_xpath"))).sendKeys("LastName");
		driver.findElement(By.xpath(OR.getProperty("email_xpath"))).getAttribute("Value");
		driver.findElement(By.xpath(OR.getProperty("password_xpath"))).sendKeys("Password");
		Select day= new Select(driver.findElement(By.xpath(OR.getProperty("DOBday_xpath"))));
		day.selectByVisibleText("19");
		Select month= new Select(driver.findElement(By.xpath(OR.getProperty("DOBmon_xpath"))));
		month.selectByVisibleText("Oct");
		Select year= new Select(driver.findElement(By.xpath(OR.getProperty("DOByear_xpath"))));
		year.selectByVisibleText("1992");
		String newsLetterReq="yes";
		 if (newsLetterReq.equalsIgnoreCase(newsLetterReq)){
		driver.findElement(By.xpath(OR.getProperty("newsletter_xpath"))).click();
		driver.findElement(By.xpath(OR.getProperty("Firstname_xpath"))).sendKeys("FirstName");
		driver.findElement(By.xpath(OR.getProperty("lastName_xpath"))).sendKeys("LastName");
		driver.findElement(By.xpath(OR.getProperty("Address1_xpath"))).sendKeys("Address");
		driver.findElement(By.xpath(OR.getProperty("city_xpath"))).sendKeys("City");
		Select state= new Select(driver.findElement(By.xpath(OR.getProperty("state_xpath"))));
		state.selectByValue("43");
		driver.findElement(By.xpath(OR.getProperty("Postcode_xpathh"))).sendKeys("postcode");
		Select country= new Select(driver.findElement(By.xpath(OR.getProperty("country_xpath"))));
		country.selectByVisibleText("United States");
		driver.findElement(By.xpath(OR.getProperty("Mobilephone_xpath"))).sendKeys("mobileno");
		driver.findElement(By.xpath(OR.getProperty("alias_xpath"))).sendKeys("AddressFUREF");
		driver.findElement(By.id(OR.getProperty("Register_id"))).click();
		Reporter.log("no excel data");
		
	}
	}
	
	@DataProvider
	public Object[][] getData(){
		String SheetName="AccountCreation";
		int rows=excel.getRowCount(SheetName);
		int cols=excel.getColumnCount(SheetName);
		Object[][] data=new Object[rows-1][cols];
		for(int rowNum=2; rowNum<=rows;rowNum++) {
			for(int colNum=0; colNum<cols;colNum++) {
				data[rowNum-2][colNum]=excel.getCellData(SheetName, colNum, rowNum);
			}
		}
	return data;
	}
	}
