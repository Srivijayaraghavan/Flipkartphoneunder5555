package flipkartpackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.stream.Location;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.FindElement;

public class Flipkartnew {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vijay\\eclipse-workspace\\Java april one\\Selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com");
		
		Thread.sleep(2222);
		
      WebElement btn=  driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
      
      btn.click();

		driver.findElement(By.xpath("//input[@class='LM6RPg']")).sendKeys("mobile under 5555");
		
        WebElement stn = driver.findElement(By.xpath("//button[@class='vh79eN']"));
        
        stn.click();
        
		Thread.sleep(2222);

        
        WebElement searchd = driver.findElement(By.xpath("//div[text()='Redmi Go (Blue, 16 GB)']"));
        
        searchd.click();
        
        String parentwindow = driver.getWindowHandle();
        
        Set <String> childwindow = driver.getWindowHandles();
        
        for (String wh : childwindow) {
        	
        	if (!parentwindow.equals(wh)) {
        		
        		driver.switchTo().window(wh);
        		 
				}
        	
        		}
           
        Thread.sleep(5555);
        List <WebElement> name = driver.findElements(By.xpath("//li[@class='_2-riNZ']"));
       for (WebElement Highlights : name) {
		String name1 = Highlights.getText();
		
		System.out.println(name1);
	}
                 
				}
	}
    
