package Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.testbase;
import Utilities.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class registrationwithparametrisation extends testbase{
	public static WebDriver driver;
	@Test(priority=1)
	public void newcustomersignin() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.className("login")).click();
		WebDriverWait some_element = new WebDriverWait(driver,100); 
		some_element.until(ExpectedConditions.visibilityOfElementLocated(By.id("//input[@id='email_create']")));
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("umaram@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//form[@id='create-account_form']//span[1]")).click();
		Thread.sleep(5000);
		
	}
	@Test(priority=2)
	public void Entercusdetails() {
		WebElement radioBtn =driver.findElement(By.id(OR.getProperty("Gendername_id")));
		radioBtn.click();
		
		
		driver.findElement(By.xpath(OR.getProperty("Firstname_xpath"))).sendKeys("FirstName");
		driver.findElement(By.xpath(OR.getProperty("lastName_xpath"))).sendKeys("LastName");
		driver.findElement(By.xpath(OR.getProperty("email_xpath"))).getAttribute("Value");
		driver.findElement(By.xpath(OR.getProperty("password_xpath"))).sendKeys("password");
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
	public static void main(String[] args) throws InterruptedException, IOException {
		
		registrationwithparametrisation dr=new registrationwithparametrisation();
		dr.newcustomersignin();
		dr.Entercusdetails();
		
		ExcelReader excel=new ExcelReader("C:\\kowsika\\LEARNING\\Projects\\Selenium\\Data driven\\src\\resources\\Excel\\AccountCreation.xlsx");
		int rowcount=excel.getRowCount("Registration");
		for(int rowNum=2; rowNum<=rowcount; rowNum++)
		{
			String firstname=excel.getCellData("Registration", "Firstname", rowNum);
			System.out.println("Firstname");
			String LastName=excel.getCellData("Registration", "LastName", rowNum);
			System.out.println("Lastname");
			String Password=excel.getCellData("Registration", "Password", rowNum);
			System.out.println("password");	
			String Email=excel.getCellData("Registration", "Email",rowNum);
			System.out.println("Email");
			String Address=excel.getCellData("Registration", "Address", rowNum);
			System.out.println("Address");
			String city=excel.getCellData("Registration", "City", rowNum);
			System.out.println("City");
			String postcode=excel.getCellData("Registration", "postcode",rowNum);
			System.out.println("City");
			String mobileno=excel.getCellData("Registration", "mobileno", rowNum);
			System.out.println("City");
			String AddressFuRef=excel.getCellData("Registration", "City", rowNum);
			System.out.println("City");
			
		}
		
		}
	
	}
	
	
	


	
