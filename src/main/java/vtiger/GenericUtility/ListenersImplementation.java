package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{
	
	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"-> Test execution started",true);
		
		test = reports.createTest(methodName);
		test.log(Status.INFO,"Test script execution started");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"-> is passed",true);
		test.log(Status.PASS,methodName+"--passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		String methodName = result.getMethod().getMethodName();
		String screenShotName = methodName+ " " + jLib.getSystemDateInFormat();
		
		try {
			String path = wLib.takeScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Reporter.log(methodName+"-> is failed",true);
		//Reporter.log(result.getThrowable().toString()+ "->reason for fail",true );
		
		test.log(Status.FAIL,result.getThrowable());
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"-> is skipped",true);
		//Reporter.log(result.getThrowable().toString()+ "->reason for skip",true );
		
		test.log(Status.SKIP,result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("Execution started",true);
		
		//Since execution starts here, we have to configure ExtentReports here
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Execution Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTiger Execution Report");
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Base Browser", "Chrome");
		reports.setSystemInfo("Base Environment", "Testing");
		reports.setSystemInfo("Base URL", "http://localhost:8888");
		reports.setSystemInfo("Base Platform", "Windows");
		reports.setSystemInfo("Reporter Name", "Dhananjay");
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("Execution completed",true);
		reports.flush(); //mandatory to provide, which gives only final reports of last test execution.
	}
	
	

}
