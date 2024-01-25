package CommonUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenerimplementation implements ITestListener {

	public ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		Reporter.log("Testscript execution is started",true);
		test=report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodname = result.getMethod().getMethodName();
		//Reporter.log(methodname+"Testscript is passed",true);
		test.log(Status.PASS, methodname+"Testscript is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String message = result.getThrowable().toString();
		String methodname = result.getMethod().getMethodName();
		//Reporter.log("Testscript is failed"+message,true);
		test.log(Status.FAIL, methodname+"Testscript is failed");
		test.log(Status.FAIL, result.getThrowable());
		WebDriverUtils wutil = new WebDriverUtils();
		try {
			wutil.totakescreenshot(BaseClass.sdriver, "Contact");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		//Reporter.log("Testscript is skipped",true);
		test.log(Status.SKIP, methodname+"Testscript is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/Report.html");
		htmlreport.config().setDocumentTitle("VtigerCRM Framework");
		htmlreport.config().setReportName("VtigerCRM");
		htmlreport.config().setTheme(Theme.DARK);
		
		 report = new ExtentReports();
		 report.attachReporter(htmlreport);
		 report.setSystemInfo("Operating System", "Windows");
		 report.setSystemInfo("Browser", "Chrome");
		 report.setSystemInfo("Chrome Version", "120.060");
		 report.setSystemInfo("Programming Langauge", "Java");
		 report.setSystemInfo("Author", "Supriya");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}
	
	
}
