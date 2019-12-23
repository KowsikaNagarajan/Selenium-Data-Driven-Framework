package Testcases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClass.testbase;

public class Login extends testbase {
	
	@Test
	public void clicksignin() throws InterruptedException, IOException {
		driver.findElement(By.xpath(OR.getProperty("sigin_xpath"))).click();
	}
	@Test
	public void exslogin() {
		
		driver.findElement(By.cssSelector(OR.getProperty("Email_CSS"))).sendKeys("Kowshisuman@gmail.com");
		driver.findElement(By.cssSelector(OR.getProperty("Password_CSS"))).sendKeys("lovebirds123");
		driver.findElement(By.xpath(OR.getProperty("loginBtn_xpath"))).click();
		//String title=driver.getTitle();
		//System.out.println("title of the page is"+ title);
		//Assert.assertTrue(title.contains("My Account"));
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("verifytitle_xpath"))),"Login not successfull");// 
		log.debug("login successfull");
		
	}
	}
