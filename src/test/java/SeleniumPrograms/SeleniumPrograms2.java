package SeleniumPrograms;


import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import Reusenew.Reuse;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SeleniumPrograms2 {
	
	static WebDriver driver;
	static String path1 = System.getProperty("user.dir");
	static ExtentReports extent;
	static ExtentTest test;
	
    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(Reuse.class);	
    //private static final Logger log = LogManager.getLogger(Reuse.class);
	
	public void Setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	public static void ReportSetup() {
		String reportPath = path1 + "/Reports/Report.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
		 extent = new ExtentReports();
		 extent.attachReporter(spark);
		 test = extent.createTest("SeleniumPrograms2");
	}
	
	
	

	public static void captureScreenshot(WebDriver driver, String name) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		long time = System.currentTimeMillis();
		String path = path1 + "/Screesnhot/" + name +"_"+ time + ".png";
		File Des = new File(path);
		FileUtils.copyFile(src,Des);
		log.info("path");
		test.addScreenCaptureFromBase64String(path);
	}
	
	
}
