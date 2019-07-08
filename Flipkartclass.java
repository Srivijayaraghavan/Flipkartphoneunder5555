package flipkartpackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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

public class Flipkartclass {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vijay\\eclipse-workspace\\Java april one\\Selenium\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com");

		WebElement Search5 = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		Search5.click();
		WebElement Search = driver.findElement(By.xpath("//input[@name='q']"));
		Search.sendKeys("phone");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		List<WebElement> locator = driver.findElements(By.xpath("//div[@class=\"_3wU53n\"]"));
//		for (int i = 0; i < locator.size(); i++) {
//			System.out.println(locator.get(i).getText());
//		}
		

		for (int i = 0; i < locator.size(); i++) {
			Row ro = s.createRow(i);
			Cell ce = ro.createCell(0);
			String mobileNames = locator.get(i).getText();
			ce.setCellValue(mobileNames);

		}
		FileOutputStream o = new FileOutputStream(loc);
		w.write(o);
		System.out.println("file created");
		Thread.sleep(1000);

		WebElement buyphone = driver.findElement(By.xpath("(//div[@class='_3wU53n'])[5]"));
		buyphone.click();

		String parId = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();

		for (String links : allwindows) {
			if (!parId.equals(links)) {
				driver.switchTo().window(links);
			}
		}

		Thread.sleep(2666);

		WebElement buyphonefinal = driver.findElement(By.xpath("//button[@class=\"_2AkmmA _2Npkh4 _2MWPVK\"]"));

		buyphonefinal.click();

		Thread.sleep(2666);
		//FileInputStream stream = new FileInputStream(loc);
		Workbook w1 = new XSSFWorkbook();
		Sheet s2 = w1.getSheet("Data");
		Row r2 = s2.getRow(4);
		Cell C2 = r2.getCell(0);
		String cellVal = C2.getStringCellValue();
		System.out.println(cellVal);
		Thread.sleep(2666);
		String label = driver.findElement(By.xpath("(//div/a)[5]")).getText();
		System.out.println(label);
		if (label.equals(cellVal)) {
			System.out.println("Product Matching");
		}
	}
}
