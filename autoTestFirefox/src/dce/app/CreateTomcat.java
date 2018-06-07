package dce.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.Base;
@Test
public class CreateTomcat {
	/**
	 * 
	 * @author yangw
	 * @version 1.0.0
	 * @project DCE
	 */	
	Base pubMeth=new Base();
	WebDriver driver;
	
 @Test
	public  void createTomcatApp() throws Exception {
		driver = pubMeth.loginDceFromExel(driver);
		pubMeth.rwFile("+++++++++++++++++", "+++++++++++++++++", "+++++++++++++++++");
		//创建应用
		//进入应用菜单
		WebElement appCenter = driver.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div[4]/div/div/span[1]"));//定位应用菜单
		
		//WebElement appcenter = driver.findElement(By.xpath("//div[@id='app']/div/nav/div[4]/div/div/span"));
		appCenter.click();
		System.out.println("app");
		Thread.sleep(2000);
		//点部署应用
		WebElement createApp = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[1]/button[1]"));
		createApp.click();
		Thread.sleep(2000);
		//选择一键部署
		WebElement oneButton = driver.findElement(By.xpath("//input[@value='1']"));
		oneButton.click();
		Thread.sleep(2000);
		//继续
		WebElement goOn = driver.findElement(By.xpath("//button[@class='dao-btn blue has-icon compact']"));
		goOn.click();
		Thread.sleep(2000);
		//搜索输入应用名称
		WebElement searchApp = driver.findElement(By.xpath("//input[@placeholder='搜索应用模版']"));
		searchApp.sendKeys("tom");
		Thread.sleep(2000);
		//选择tomcat	
		WebElement selecttom = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div/div/div/div[2]/div[2]"));
		selecttom.click();
		Thread.sleep(2000);
		//继续
		WebElement goOn2 = driver.findElement(By.xpath("//button[@class='dao-btn blue has-icon compact']"));
		goOn2.click();
		Thread.sleep(2000);

		//继续
		WebElement goOn3 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div[2]/div[2]/div[3]/button[2]"));
		goOn3.click();
		Thread.sleep(2000);
		//检查并创建		
		//WebElement checkcreate = driver.findElement(By.xpath("//button[@class='dao-btn blue']"));
		WebElement checkCreate = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div[2]/div[3]/div[2]/button[2]"));
		checkCreate.click();
		Thread.sleep(5000);
	
		//进入应用菜单
		WebElement checkApp = driver.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div[4]/div/div/span[1]"));
		checkApp.click();
		Thread.sleep(5000);
		
		//刷新
		WebElement refresh = driver.findElement(By.xpath("//button[@title='刷新']"));
		refresh.click();
		Thread.sleep(3000);
		
		//判断应用是否存在
		By locator = By.xpath("//a[@href='#/app-detail/tomcat']");
		boolean reValue = pubMeth.isElementExsit(driver, locator);
		System.out.println(reValue);
		
		//将结果写入log文件
		pubMeth.writeLog("用例：CreateAppTomcat ", reValue);
		
	}
}

