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

public class Base {
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
		
		
		return driver;
	}
	
	@Test
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
	public void rwFile(String cases, String message, String value) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("/Users/yangwei/Documents/dce_autotest.log", true);
			String valuestring = String.valueOf(value);
			fw.write(cases + "" + message + "" + valuestring + "\r\n");
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
	public void writeLog(String cases,boolean reValue)throws Exception{	
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

		if (reValue) {
			rwFile(cases , df.format(new Date()) , "Pass");
		} else {
			rwFile(cases , df.format(new Date()) , "Fail");
		}
	}
	
	
	
}
