package SeleniumPrograms;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import Reusenew.Reuse;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SeleniumPrograms2 {
	
	static WebDriver driver;
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	public Reuse Data;

	
	@BeforeMethod
	public void setup() {
	
		 spark = new ExtentSparkReporter("Selenium2.html");
		 extent = new ExtentReports();
	     extent.attachReporter(spark);
	     test = extent.createTest("SeleniumPrograms2");
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Data = PageFactory.initElements(driver, Reuse.class);
	}
		 
	@Test
	public void Open() throws InterruptedException, IOException {
		Reuse.createReport("Amazon_Report.html", "SeleniumAmazon_ScriptName", "Amazon_Module");
		
		driver.get("https://www.amazon.com/");
		Thread.sleep(5000);
		WebElement req = driver.findElement(By.xpath("(//*[text()='Prime Video'])[2]"));
		try {
		if(req.isDisplayed()) {
		    Reuse.captureScreenshotPass(driver, "AmazonLoginScreen", "Amazon opened");

		}
		}
		catch (Exception e) {
			
		    Reuse.captureScreenshotFail(driver, "AmazonLoginScreen", "Amazon not opened");
		    Assert.fail("Amazon not opened");
		}
	}
	
	
	
	
	
		
	}


