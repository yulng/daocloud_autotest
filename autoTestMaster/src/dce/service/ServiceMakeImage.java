package dce.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import common.Base;
import common.CreateOneApp;

@Test
public class ServiceMakeImage {
	/**
	 * 
	 * @author yangw
	 * @version 1.0.0
	 * @project DCE
	 */
	Base pubMeth = new Base();
	WebDriver driver;
	CreateOneApp useAppit = new CreateOneApp();
	
	
	public void makeImage() throws Exception {
		
		//先创建应用
		driver = useAppit.createOneApplication(driver);
		
		//driver = pubMeth.loginDceFromExel(driver);
		pubMeth.rwFile("+++++++++++++++++", "+++++++++++++++++", "+++++++++++++++++");
	
		//进入服务菜单
		WebElement serviceMenu = driver.findElement(By.xpath("/html/body/div[2]/div[1]/nav/div[5]/div[1]/div/span[1]"));
		serviceMenu.click();
		Thread.sleep(2000);
		System.out.println("service menu");
		//点three dot
		WebElement moreMenu = driver.findElement(By.xpath("//button[@class='dao-btn ghost']"));
		moreMenu.click();
		Thread.sleep(2000);
		System.out.println("moreMenu");
		//选择other opertion
		WebElement otherOps = driver.findElement(By.xpath("/html/body/div[4]/div/ul/div[3]/div[1]/li/span"));
		otherOps.click();
		Thread.sleep(2000);
		//选择制作镜像
		WebElement makeImg = driver.findElement(By.xpath("/html/body/div[4]/div/ul/div[3]/div[2]/div/ul/li[1]/span[1]"));
		makeImg.click();
		Thread.sleep(2000);
		
		//select image name
		WebElement imgName = driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div[3]/div[9]/div/div/div[2]/div/div[3]/div/div[2]/div/div/div/div/div/div"));
		imgName.click();
		Thread.sleep(2000);
		
		//select daocloud
		WebElement seleDaocloud = driver.findElement(By.xpath("//div[4]/div/div/div[2]/span"));
		seleDaocloud.click();
		Thread.sleep(2000);
		
		//选择input name
		WebElement inputName = driver.findElement(By.xpath("//input[@placeholder='镜像名称']"));
		inputName.clear();
		inputName.sendKeys("autoservice");
		Thread.sleep(2000);
		
		//选择version
		WebElement inputVersion = driver.findElement(By.xpath("//input[@placeholder='例：latest']"));
		inputVersion.clear();
		inputVersion.sendKeys("3.20.0");
		Thread.sleep(2000);
		
		//制作镜像
		WebElement beginMake = driver.findElement(By.xpath("//button[@class='dao-btn blue']"));
		beginMake.click();
		Thread.sleep(10000);
		
		
	    //回到image
		WebElement turntoImg = driver.findElement(By.xpath("//button[@class='dao-btn blue']"));
		turntoImg.click();
		Thread.sleep(3000);
		
		//进入镜像工场菜单
		WebElement imageCenterMenu = driver.findElement(By.xpath("//div[@id='app']/div/nav/div[4]/div[2]/div/span[1]"));
		imageCenterMenu.click();
		Thread.sleep(2000);
		System.out.println("imageCenterMenu");
		
		//判断应用是否存在
		By locator = By.xpath("//a[@href='#/image-detail/autoservice?ns=daocloud&regName=buildin-registry']");
		boolean reValue = pubMeth.isElementExsit(driver, locator);
		System.out.println(reValue);
		//将结果写入log文件
		pubMeth.writeLog("ServiceImage ", reValue);
		
	//	*/
    //    driver.quit();
	}

}
