package abstractP;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportExtent {
	   static ExtentReports extnt;
	  
	
	public static ExtentReports reportExtnt() {
//		DateFormat df = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
//		String dateStamp = df.format(new Date());
//	    File fpath=new File(System.getProperty("user.dir")+"\\extentReport\\index.html");
		
		 String path= System.getProperty("user.dir")+"\\extentReport\\index.html";
		 ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		 reporter.config().setReportName("Web Automation");
		 reporter.config().setDocumentTitle("Test Result");
		 extnt =new ExtentReports();
		 extnt.attachReporter(reporter);
		 extnt.setSystemInfo("Automation Tester", "Vivek Pandey");
		 return extnt;
	}

}
