package baseComponent;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import abstractP.ReportExtent;

public class Listners extends BaseTest implements ITestListener{
	      ExtentReports extnt  = ReportExtent.reportExtnt();
	      ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = extnt.createTest(result.getMethod().getMethodName());		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			dvr = (WebDriver) result.getTestClass().getRealClass().getField("dvr").get(result.getInstance());
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		String filepath = null;
		try {
			filepath = screenShot(result.getMethod().getMethodName(), dvr);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, "Test Failed");
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

		
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Skiped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extnt.flush();
		String pathToExtentReport=System.getProperty("user.dir")+"\\extentReport\\index.html";
		File extentReport= new File(pathToExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	


}
