package dce.template;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.Base;

@Test
public class CreateTemplate {
	/**
	 * 
	 * @author yangw
	 * @version 1.0.0
	 * @project DCE
	 */
	Base pubMeth=new Base();
	WebDriver driver;
	public void createTemplate() throws Exception {
		
		
		//driver = pubMeth.loginDce(driver);
		driver = pubMeth.loginDceFromExel(driver);
		
		pubMeth.rwFile("+++++++++++++++++", "+++++++++++++++++", "+++++++++++++++++");
		//创建应用模版
		//进入template menu
		WebElement appTemp = driver.findElement(By.xpath("//div[@id='app']/div/nav/div[4]/div/div/span"));
		appTemp.click();
		Thread.sleep(2000);
		System.out.println("template menu");
		//点创建template
		WebElement createTemp = driver.findElement(By.xpath("//button[@class='dao-btn has-icon blue']"));
		createTemp.click();
		Thread.sleep(2000);
		System.out.println("create template");
		//input name
		WebElement inputName = driver.findElement(By.xpath("//input[@placeholder='例: my_micro_service']"));
		inputName.clear();
		inputName.sendKeys("autotemplate");
		Thread.sleep(2000);
		//try 2048
		WebElement try2048 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[3]/div/div/div[2]/div/div[6]/div[2]/div[2]/a[1]"));
		try2048.click();
		Thread.sleep(2000);
		//confirm
		WebElement confirm = driver.findElement(By.xpath("//button[@class='dao-btn blue']"));
		confirm.click();
		Thread.sleep(2000);
		
		//使用此模版部署
		//search
		WebElement search = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[1]/div[1]/div/div/div[1]/input"));
		search.clear();
		search.sendKeys("autotemplate");
		Thread.sleep(2000);
		
		
		//search out
		WebElement selectTemp = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/a/div/div[2]/div[3]"));
		selectTemp.click();
		Thread.sleep(2000);
		
		//search input
		WebElement enterTemp = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span"));
		String getName = enterTemp.getText();
		System.out.println("name="+getName);
		Thread.sleep(2000);
		
		
		//String str1= "autotemplate";
		String str2 = new String("autotemplate");
		
		if ( getName.equals(str2) ) {
			System.out.println("template install ok");	
			pubMeth.rwFile("用例：CreateTemplate" , "结果：pass", "'value='+getName");
		} else {
			System.out.println("template have not exist ");	
			pubMeth.rwFile("用例：CreateTemplate" , "结果：fail", "'value='+getName");
		}
		
	
    }
}
