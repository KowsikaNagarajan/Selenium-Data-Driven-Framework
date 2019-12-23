package BaseClass;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testbase {
	/*
	 * WebDriver
	 * Properties- browserconfig
	 * LOGS - created.log files(application and Selenium) add Log4j properties
	 * ExtentReports
	 * DB
	 * Excel
	 * Mail
	 * 
	 */
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR=new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static String browser;
	public static ExtentTest test;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel=new ExcelReader("C:\\kowsika\\LEARNING\\Projects\\Selenium\\Data driven\\src\\resources\\Excel\\AccountCreation.xlsx");
	
	@BeforeSuite
	public void setup() {     //****TO CONFIG THE BROWSER USING THE PROPERTIES ****//
		if(driver==null) {
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\resources\\Properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\resources\\Properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){
			
			browser = System.getenv("browser");
		}else{
			
			browser = config.getProperty("browser");
			
		}
		
		config.setProperty("browser", browser);
		if (config.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (config.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.debug("Chrome Launched !!!");
		} else if (config.getProperty("browser").equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			}
        driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to : " + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
	}
	public void click(String locator) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
		test.log(LogStatus.INFO, "Clicking on : " + locator);
	}

	public void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}

		test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);

	}
	public boolean isElementPresent(By by) {  //****TO VERIFY THE ELEMENT PRESENCE we need to initiate a method***//
		try {
			driver.findElement(by);
			return true;
			}catch(NoSuchElementException e) {
				return false;
			}
	}
	
	@AfterSuite
	public void teardown() {
		if(driver!=null);
		driver.quit();
		log.debug("test execution completed");
	}
}
