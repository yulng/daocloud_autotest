package dce.app;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import common.Base;
import common.CreateOneApp;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
@Test
public class CreateAppUrl {	
	/**
	 * 
	 * @author yangw
	 * @version 1.0.0
	 * @project DCE
	 */	
	Base pubMeth = new Base();
	CreateOneApp oneApp = new CreateOneApp();
	WebDriver driver;
	@Test
	public  void urlApplication() throws Exception {
		
		//创建2048应用
		driver = oneApp.createOneApplication(driver);
		
		//进入应用菜单
		WebElement checkApp = driver.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div[3]/div/div/span[1]"));
		checkApp.click();
		Thread.sleep(5000);
		//查看能否访问
		//选择接入点
		WebElement interfaceDot = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/table/tbody/tr[2]/td/div/div/div[1]/div/div[1]"));
		interfaceDot.click();
		Thread.sleep(2000);
		
		//选择内网地址和端口
		WebElement ipPort = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/ul/li[1]/a"));
		String text = ipPort.getText();
		System.out.println(text);
		Thread.sleep(2000);
		driver.quit();
		
		//再打开一个窗口查应用访问是否成功
		System.setProperty("webdriver.gecko.driver", "/Users/yangwei/Documents/seleniumfile/geckodriver");
		driver =new FirefoxDriver();
		String text2 = "http://" + text;
		driver.get(text2);
		
		//取2048
		WebElement get2048 = driver.findElement(By.xpath("/html/body/div/div[1]/h1"));
		String text2048 = get2048.getText();
		System.out.println(text2048);
		Thread.sleep(2000);
		
		String str2048 = "2048";
		if (text2048.equals(str2048) ) {
			System.out.println("url ok");
			pubMeth.rwFile( "用例：CreateApp",  "检查：CheckUrl",  "结果：ok");
		} else {
			System.out.println("url not ok");
			pubMeth.rwFile( "用例：CreateApp",  "检查：CheckUrl",  "结果：fail");
		}
		
    //    driver.quit();
	}

}
