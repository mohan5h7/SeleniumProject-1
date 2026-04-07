package SeleniumPrograms;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for(WebElement link : links){

            String url = link.getAttribute("href");

            if(url == null || url.isEmpty()){
                continue;
            }

            URL linkURL = new URL(url);//Convert URL String to URL Object
            HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection();//Open Connection

            connection.connect();//Conect to server
            

            if(connection.getResponseCode() >= 400){
                System.out.println(url + " → Broken Link");
            }
            else{
                System.out.println(url + " → Valid Link");
            }
        }

       // driver.quit();
}
}