package SeleniumPrograms;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import Reusenew.Reuse;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumPrograms1 {

	static WebDriver driver;
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	public Reuse Data;

	
	@BeforeMethod
	public void setup() {
	
		 spark = new ExtentSparkReporter("Selenium.html");
		 extent = new ExtentReports();
	     extent.attachReporter(spark);
	     test = extent.createTest("SeleniumPrograms1");
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Data = PageFactory.initElements(driver, Reuse.class);
	}
		 
	@Test
	public void Open() throws InterruptedException, IOException {
		Reuse.createReport("Filpkart_Report.html", "Selenium_ScriptName", "Filpkart_Module");
		
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		WebElement req = driver.findElement(By.xpath("//*[text()='Request OTP']"));
		
		if(req.isDisplayed()) {
		    Reuse.captureScreenshotPass(driver, "FilpkarLoginScreen", "Filpkart opened");

		}
		
		else {
			
		    Reuse.captureScreenshotFail(driver, "FilpkarLoginScreen", "Filpkart not opened");
		    Assert.fail("Filpkart not opened");
		}
	}
	
	
	
	
	
		
	}

