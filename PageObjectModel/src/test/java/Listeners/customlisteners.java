package Listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Utilities.Testutil;

public class customlisteners implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {// this is to capture the screenshot during test run and add it to reports
	 System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			Testutil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("<a target=\"_blank\" href="+Testutil.screenshotname+">Click on Screenshot</a>"); 
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+Testutil.screenshotname+"><img src="+Testutil.screenshotname+" height=50 width=50></img></a>");
	 
	}
	/*public void onTestFailure(ITestResult result) {// this to add a screenshot from the local computer to the reports
		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("login success");
		Reporter.log("<a target=\"_blank\" href=\"E:\\screenshot\\error.jpg\">Screenshot</a>"); // to add a screenshot to the reports
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=\"E:\\screenshot\\error.jpg\"><img src=\"E:\\screenshot\\error.jpg\" height=50 width=50></img></a>");// to add thumbnail in the screenshot
		// TODO Auto-generated method stub
		}*/
		

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
