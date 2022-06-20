package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest logger;
	
	public void onStart(ITestContext ir)
	{
		String timeStamp= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report-" + timeStamp + ".html";
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReports/"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-report.xml");

		extentReport= new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Host name", "localhost");
		extentReport.setSystemInfo("Tester", "Anushra");
		extentReport.setSystemInfo("Browser", "Chrome");
		htmlReporter.config().setDocumentTitle("MakeMyTrip Project");
		htmlReporter.config().setReportName("Functional Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
		public void onTestSuccess(ITestResult tr) {
			logger = extentReport.createTest(tr.getName()); 
			logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); 
		}
		
		public void onTestFailure(ITestResult tr) {
			logger = extentReport.createTest(tr.getName()); 
			logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); 

			String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";

			File f = new File(screenshotPath);

			if (f.exists()) {
				try {
					logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			
		}
		public void onFinish(ITestContext testContext) {
			extentReport.flush();
		}
		
		
		
	}
	
