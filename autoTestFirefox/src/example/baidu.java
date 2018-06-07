package example;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class baidu  {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Applications/Google Chrome.app/Contents/MacOS/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
		ChromeDriver driver = new ChromeDriver(options);
		
		//WebDriver driver =new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.baidu.com");
		Thread.sleep(5000);
		driver.findElement(By.id("kw")).sendKeys(new  String[] {"明月松间照"});//找到kw元素的id，然后输入xxx
		Thread.sleep(2000);
        driver.findElement(By.id("su")).click(); //点击按扭
        Thread.sleep(2000);
        driver.quit();
	
	
	}

	//private static WebDriver ChromeDriver() {
		// TODO Auto-generated method stub
	//	return null;
	//}
	
}
