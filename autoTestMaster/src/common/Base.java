package common;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import common.Para;

public class Base {
	
	/**
	 * 
	 * @author yangw
	 * @version 1.00
	 * @project DCE
	 */
	
	@Test
	public WebDriver loginDce(WebDriver driver) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "/Users/yangwei/Documents/seleniumfile/geckodriver");
		driver =new FirefoxDriver();
		
		//登录dce
		driver.get("https://192.168.123.109");
		Thread.sleep(5000);
		WebElement searchUsername = driver.findElement(By.xpath("//input[@messageplacement='top-end']"));//定位用户名
		searchUsername.sendKeys("admin");
		Thread.sleep(2000);
		WebElement searchPassword = driver.findElement(By.xpath("//input[@type='password']"));//定位密码
		searchPassword.sendKeys("admin");
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.xpath("//button[@class='dao-btn blue login-btn']"));//定位button
		submit.click();
		Thread.sleep(5000);
		return driver;
	}
	
	@Test
	public WebDriver loginDceFromExel(WebDriver driver) throws Exception {
		Para paraValue = new Para();
		String[] value = paraValue.paraSeting();
		
		System.setProperty("webdriver.gecko.driver", "/Users/yangwei/Documents/seleniumfile/geckodriver");
		driver =new FirefoxDriver();
		
		//登录dce
		driver.get(value[4]);
		Thread.sleep(5000);
		WebElement searchUsername = driver.findElement(By.xpath("//input[@messageplacement='top-end']"));//定位用户名
		searchUsername.sendKeys(value[0]);
		Thread.sleep(2000);
		WebElement searchPassword = driver.findElement(By.xpath("//input[@type='password']"));//定位密码
		searchPassword.sendKeys(value[1]);
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.xpath("//button[@class='dao-btn blue login-btn']"));//定位button
		submit.click();
		Thread.sleep(5000);
		return driver;	
	}
	
	
	@Test
	//判断创建元素是否存在
	public static boolean isElementExsit(WebDriver driver, By locator) {
		boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			flag = null != element;
		} catch (Exception e) {
			System.out.println("Element:" + locator.toString() + " is not exsit!");
		}
		return flag;
	}
	
	
	@Test
	//写入文件
	public void rwFile(String cases, String message, String value) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("/Users/yangwei/Documents/seleniumfile/dce_autotest.log", true);
			String valueString = String.valueOf(value);
			fw.write(cases + "" + message + "" + valueString + "\r\n");
			fw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

	}
	
	@Test
	//根据reValue值，将结果写入log文件
	public void writeLog(String cases,boolean reValue)throws Exception{	
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

		if (reValue) {
			rwFile(cases , df.format(new Date()) , "Pass");
		} else {
			rwFile(cases , df.format(new Date()) , "Fail");
		}
	}
		
}
