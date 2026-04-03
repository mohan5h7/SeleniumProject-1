package basesetup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Reusenew.Reuse;

public class basesetupnew {
	/*
	protected WebDriver driver;

    @BeforeSuite
    public void setupReport() {
        // Initialize ExtentReports
        Reuse.createReport("TestReport.html", "Selenium Test Suite", "FlipkartModule");
    }

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void takeScreenshotOnTestResult(ITestResult result) throws IOException {
        String testName = result.getName();

        if (result.getStatus() == ITestResult.SUCCESS) {
            // Capture PASS screenshot automatically
            Reuse.captureScreenshotPass(driver, testName, "Test Passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            // Capture FAIL screenshot automatically
            Reuse.captureScreenshotFail(driver, testName, "Test Failed");
        }

        // Close browser after each test
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void closeReport() {
        // Flush and close ExtentReports
        Reuse.closeReport();
    }*/
}