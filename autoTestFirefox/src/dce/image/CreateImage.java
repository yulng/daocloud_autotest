package dce.image;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import common.Base;

@Test
public class CreateImage {
	/**
	 * 
	 * @author yangw
	 * @version 1.0.0
	 * @project DCE
	 */
	Base pubMeth=new Base();
	WebDriver driver;
	public void createImage() throws Exception {
		
		//driver = pubMeth.loginDce(driver);
		driver = pubMeth.loginDceFromExel(driver);
		
		pubMeth.rwFile("+++++++++++++++++", "+++++++++++++++++", "+++++++++++++++++");
		//创建镜像
		//进入镜像工场菜单
		WebElement imageCenter = driver.findElement(By.xpath("//div[@id='app']/div/nav/div[4]/div[2]/div/span[1]"));
		imageCenter.click();
		Thread.sleep(2000);
		System.out.println("image menu");
		//点创建镜像
		WebElement createImage = driver.findElement(By.xpath("//button[@class='dao-btn blue has-icon']"));
		createImage.click();
		Thread.sleep(2000);
		System.out.println("create image");
		//选择名称输入
		WebElement inputName = driver.findElement(By.xpath("//input[@placeholder='镜像名称']"));
		inputName.clear();
		inputName.sendKeys("autoimage");
		Thread.sleep(2000);
		//方式
		WebElement selectType = driver.findElement(By.xpath("//input[@value='pullCode']"));
		selectType.click();
		Thread.sleep(2000);
		//下一步
		WebElement nextg = driver.findElement(By.xpath("//button[@class='dao-btn blue']"));
		nextg.click();
		Thread.sleep(2000);
		//选择代码源	
		WebElement selectCode = driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/div[2]/div[2]/div/div[2]/div/div/div[4]/div/div/div[2]/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div[2]/span/div"));
		selectCode.click();
		Thread.sleep(2000);
		//选择github
		WebElement selectGithub = driver.findElement(By.xpath("//div[4]/span/div"));
		selectGithub.click();
		Thread.sleep(2000);
		//输入git link
		WebElement inputGit= driver.findElement(By.xpath("//input[@placeholder='例：git://example.com:namespace/repo.git']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(inputGit).click().perform();
		inputGit.clear();
		inputGit.sendKeys("https://github.com/DaoCloud/dao-2048.git");
		//http://github.com/DaoCloud/dao-2048.git
		Thread.sleep(2000);
		//创建
		WebElement creatSubmit = driver.findElement(By.xpath("//button[@class='dao-btn blue']"));
		creatSubmit.click();
		Thread.sleep(10000);
		
	    //回到主页面
		driver.get("https://192.168.123.109");
		System.out.println("clickOther");
		Thread.sleep(2000);
		
		//进入镜像工场菜单
		WebElement imageCenterMenu = driver.findElement(By.xpath("//div[@id='app']/div/nav/div[4]/div[2]/div/span[1]"));
		imageCenterMenu.click();
		Thread.sleep(2000);
		System.out.println("imageCenterMenu");
		
		//判断应用是否存在
		By locator = By.xpath("//a[@href='#/image-detail/autoimage?ns=daocloud&regName=buildin-registry']");
		boolean reValue = pubMeth.isElementExsit(driver, locator);
		System.out.println(reValue);
		//将结果写入log文件
		pubMeth.writeLog("CreateImage ", reValue);
		
		
    //    driver.quit();
	}
}
