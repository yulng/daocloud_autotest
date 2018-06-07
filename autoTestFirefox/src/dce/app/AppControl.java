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
public class AppControl {	
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
	public  void AppController() throws Exception {
		driver = pubMeth.loginDceFromExel(driver);
		
		//创建2048应用
		//driver = oneApp.createOneApplication(driver);
		
		//进入应用菜单
		WebElement checkApp = driver.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div[4]/div/div/span[1]"));
		checkApp.click();
		Thread.sleep(5000);
	
		//选择控制台
		//interfaceDot = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/table/tbody/tr[1]/td[4]/div/div[1]/div[1]/button"));
		//interfaceDot.click();
		//Thread.sleep(2000);
		//选择应用
		WebElement selectApp = driver.findElement(By.xpath("//a[@href='#/app-detail/autotest2048']"));
		selectApp.click();
		Thread.sleep(2000);
		System.out.println("selectApp");
		//选择容器组菜单
		WebElement selectPod = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/ul[1]/li[3]/div"));
		selectPod.click();
		Thread.sleep(2000);
		System.out.println("selectPod");
		//点容器组
		WebElement enterPod = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div/div/table/tbody/tr/td[1]/a"));
		enterPod.click();
		Thread.sleep(2000);
		System.out.println("enterPod");
		//点容器
		WebElement enterContain = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div/table/tbody/tr/td[1]/a"));
		enterContain.click();
		Thread.sleep(2000);
		System.out.println("enterContain");
		//选择id
		WebElement selectid = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div/div[2]/div"));
		String idnum = selectid.getText();
		Thread.sleep(2000);
		System.out.println("idnum");
		
		
		
		
    //    driver.quit();
	}

}
