package dce.module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import common.Base;
@Test
public class CreateModule {
	/**
	 * 
	 * @author yangw
	 * @version 1.0.0
	 * @project DCE
	 */
	Base pubMeth=new Base();
	WebDriver driver;
	public void createModule() throws Exception {
		
		//driver = pubMeth.loginDce(driver);
		driver = pubMeth.loginDceFromExel(driver);
		
		pubMeth.rwFile("+++++++++++++++++", "+++++++++++++++++", "+++++++++++++++++");
		//创建module
		//进入module triangle
		WebElement moduleCenter = driver.findElement(By.xpath("//div[@id='app']/div/nav/div[8]/div/div/span"));
		moduleCenter.click();
		Thread.sleep(2000);
		System.out.println("module triangle");
		//进入module
		WebElement moduleManage = driver.findElement(By.xpath("//div[@id='app']/div/nav/div[8]/div/ul/li[2]/span"));
		moduleManage.click();
		Thread.sleep(2000);
		System.out.println("module menu");
		//点手动创建模块
		WebElement createModule = driver.findElement(By.xpath("//button[@class='dao-btn has-icon green']"));
		createModule.click();
		Thread.sleep(2000);
		System.out.println("create image");
		//选择internet install
		WebElement selectInstall = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[3]/div/div/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div/label"));
		selectInstall.click();
		Thread.sleep(2000);
		//input
		WebElement imageAddress = driver.findElement(By.xpath("//input[@class='dao-control image-addr']"));
		imageAddress.clear();
		imageAddress.sendKeys("daocloud.io/daocloud/ingress-controller-installer");
		Thread.sleep(5000);
		//下一步
		WebElement nextg = driver.findElement(By.xpath("//button[@class='dao-btn blue']"));
		nextg.click();
		Thread.sleep(2000);
		//check
		WebElement checkInstall = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[3]/div/div/div/div[3]/button[4]"));
		checkInstall.click();
		Thread.sleep(10000);
		//confirm install
		WebElement confirmInstall = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[3]/div/div/div/div[3]/button[5]"));
		confirmInstall.click();
		Thread.sleep(15000);
		
		//刷新
		WebElement refresh = driver.findElement(By.xpath("//button[@title='刷新']"));
		refresh.click();
		Thread.sleep(2000);	
		
		//再刷新
		WebElement refresh2 = driver.findElement(By.xpath("//button[@title='刷新']"));
		refresh2.click();
		Thread.sleep(2000);	
		
		
		//module name
		WebElement getName = driver.findElement(By.xpath("//span[@class='plugin-name']"));
		String getValue = getName.getText();
		System.out.println("valule="+getValue);
		Thread.sleep(2000);
		
		//String str1= "IngressControllerInstaller";
		String str2 = new String("IngressControllerInstaller");
		
		if ( getValue.equals(str2) ) {
			System.out.println("plugin install ok");	
			pubMeth.rwFile("用例：CreateModule" , "结果：pass", "'value'+getValue");
		} else {
			System.out.println("plugin have not exist ");	
			pubMeth.rwFile("用例：CreateModule" , "结果：fail", "'value'+getValue");
		}
		
	
    }
}
