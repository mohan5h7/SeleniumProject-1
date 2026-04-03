package Reusenew;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reuse {
	
	
	  static ExtentReports report;
   static ExtentTest test;

   // Initialize report
       public static void createReport(String reportName, String scriptName, String moduleName) 
       {
       String path = System.getProperty("user.dir") + "/" + moduleName + "/" + reportName;
       ExtentSparkReporter spark = new ExtentSparkReporter(path);
       report = new ExtentReports();
       report.attachReporter(spark);

       test = report.createTest(scriptName);
   }
       
       
       // Logger instance
       private static final Logger log = LogManager.getLogger(Reuse.class);	

       // Capture screenshot and log as PASS
       public static void captureScreenshotPass(WebDriver driver, String screenshotName, String data) throws IOException {
           // 1️⃣ Create unique timestamp
           String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

           // 2️⃣ Capture screenshot as a file
           File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

           // 3️⃣ Destination path with timestamp
           String destPath = System.getProperty("user.dir") + "/pass/" + screenshotName + "_" + time + ".png";

           // 4️⃣ Copy the screenshot file to destination
           FileUtils.copyFile(srcFile, new File(destPath));

           // 5️⃣ Log screenshot in ExtentReports
           test.pass(data, MediaEntityBuilder.createScreenCaptureFromPath(destPath).build());
           report.flush();

           // 6️⃣ Log in console/log file
           log.info("PASS: Screenshot captured successfully - " + destPath);
       }

       // Capture screenshot and log as FAIL
       public static void captureScreenshotFail(WebDriver driver, String screenshotName, String data) throws IOException 
       {
           // 1️⃣ Create unique timestamp
           String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

           // 2️⃣ Capture screenshot as a file
           File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

           // 3️⃣ Destination path with timestamp
           String destPath = System.getProperty("user.dir") + "/fail/" + screenshotName + "_" + time + ".png";

           // 4️⃣ Copy the screenshot file to destination
           FileUtils.copyFile(srcFile, new File(destPath));

           // 5️⃣ Log screenshot in ExtentReports as FAIL
           test.fail(data, MediaEntityBuilder.createScreenCaptureFromPath(destPath).build());
           report.flush();

           // 6️⃣ Log in console/log file
           log.error("FAIL: Screenshot captured - " + destPath);
       }
       
//Flush and close report
public static void closeReport() 
{
   if (report != null) 
   {
       report.flush();
   }
}




}    
        
        
        
        
        


