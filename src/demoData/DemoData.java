package demoData;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.Alert;

//import org.openqa.selenium.interactions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class DemoData {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().
		Thread.sleep(5000);	
	driver.get("https://demo.dealsdray.com/");
	driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
	driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//span[text()='chevron_right']")).click();	
	Thread.sleep(5000);
	driver.findElement(By.linkText("Orders")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Panchal\\Downloads\\demodata.xlsx");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[text()='Import']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
Thread.sleep(5000);


Alert alert=driver.switchTo().alert();
alert.accept();

Thread.sleep(5000);
WebElement element = driver.findElement(By.xpath("//td[text()='4']"));
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollIntoView(true)",element);
//the issue about this website is the scrolling screen function  Page is not working as expected.
//Actions ac = new Actions(driver);
//ac.scrollToElement(element);
//Robot rb = new Robot();
//rb.keyPress(KeyEvent.VK_PAGE_DOWN);
//rb.keyRelease(KeyEvent.VK_PAGE_DOWN);
//rb.keyPress(KeyEvent.VK_PAGE_DOWN);
//rb.keyRelease(KeyEvent.VK_PAGE_DOWN);
//rb.keyPress(KeyEvent.VK_PAGE_DOWN);
//rb.keyRelease(KeyEvent.VK_PAGE_DOWN);
Thread.sleep(5000);


File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
Files.copy(f, new File("C:\\Users\\Panchal\\Downloads\\sitemapscreenshot.png"));

Thread.sleep(5000);
//driver.close();
}

}