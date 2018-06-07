package example;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@Test 
public class fortestng  {
	WebDriver driver;
	public void createApp() throws Exception {
		
		
		System.setProperty("webdriver.gecko.driver", "/Users/yangwei/Documents/seleniumfile/geckodriver");
		WebDriver driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.baidu.com");
		Thread.sleep(5000);
		driver.findElement(By.id("kw")).sendKeys(new  String[] {"daocloud"});//找到kw元素的id，然后输入xxx
		Thread.sleep(2000);
        driver.findElement(By.id("su")).click(); //点击按扭
        Thread.sleep(2000);
    //    driver.quit();
	
	}

	
}
