package dce.app;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import common.Base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@Test 
public class CreateApp {

	Base pubMeth=new Base();
	WebDriver driver;
	public void createApp() throws Exception {
		
		
		driver = pubMeth.loginDce(driver);
		pubMeth.rwFile("+++++++++++++++++", "+++++++++++++++++", "+++++++++++++++++");
		//创建应用
		//进入应用菜单
		WebElement appcenter = driver.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div[4]/div/div/span[1]"));//定位应用菜单
		
		//WebElement appcenter = driver.findElement(By.xpath("//div[@id='app']/div/nav/div[4]/div/div/span"));
		appcenter.click();
		Thread.sleep(2000);
		//点部署应用
		WebElement createapp = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[1]/button[1]"));
		createapp.click();
		Thread.sleep(2000);
		//选择一键部署
		WebElement onebutton = driver.findElement(By.xpath("//input[@value='1']"));
		onebutton.click();
		Thread.sleep(2000);
		//继续
		WebElement goon = driver.findElement(By.xpath("//button[@class='dao-btn blue has-icon compact']"));
		goon.click();
		Thread.sleep(2000);
		//搜索输入应用名称
		WebElement searchapp = driver.findElement(By.xpath("//input[@placeholder='搜索应用模版']"));
		searchapp.sendKeys("2048");
		Thread.sleep(2000);
		//选择2048	
		WebElement select2048 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div/div/div/div[2]/div[2]"));
		select2048.click();
		Thread.sleep(2000);
		//继续
		WebElement goon2 = driver.findElement(By.xpath("//button[@class='dao-btn blue has-icon compact']"));
		goon2.click();
		Thread.sleep(2000);
		//输入应用名称
		WebElement inputname = driver.findElement(By.xpath("//input[@message='应用名必须以字母开头']"));
		inputname.clear();
		inputname.sendKeys("autotest2048");
		Thread.sleep(2000);
		//继续
		WebElement goon3 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div[3]/button[2]"));
		goon3.click();
		Thread.sleep(2000);
		//检查并创建		
		//WebElement checkcreate = driver.findElement(By.xpath("//button[@class='dao-btn blue']"));
		WebElement checkcreate = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div[2]/div[3]/div[2]/button[2]"));
		
		checkcreate.click();
		Thread.sleep(5000);
		//进入应用菜单
		WebElement checkapp = driver.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div[4]/div/div/span[1]"));
		checkapp.click();
		Thread.sleep(5000);
		
		By locator = By.xpath("//a[@href='#/app-detail/autotest2048']");
		boolean reValue = pubMeth.isElementExsit(driver, locator);
		System.out.println(reValue);
		
		pubMeth.writeLog("CreateApp ", reValue);
		
		WebElement refresh = driver.findElement(By.xpath("//button[@title='刷新']"));
		refresh.click();
		Thread.sleep(3000);
		
    //    driver.quit();
	}

	//private static WebDriver ChromeDriver() {
		// TODO Auto-generated method stub
	//	return null;
	//}
	

}
