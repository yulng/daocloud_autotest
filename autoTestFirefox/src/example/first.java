package example;

	//package com.example.tests;

	    import java.util.regex.Pattern;
		import java.util.concurrent.TimeUnit;
		import org.testng.annotations.*;
		import static org.testng.Assert.*;
		import org.openqa.selenium.*;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.support.ui.Select;
			
   public class first {
	
		  private WebDriver driver;
			
		  private String baseUrl;
		  private boolean acceptNextAlert = true;
		  private StringBuffer verificationErrors = new StringBuffer();

		 // @BeforeClass(alwaysRun = true)
		 // public void setUp() throws Exception {
		 //   
		 //   baseUrl = "https://www.katalon.com/";
		 //   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 // }

		  @Test
		  public void testChrome() throws Exception {
			 
			System.setProperty("webdriver.gecko.driver", "/Users/yangwei/Documents/seleniumfile/geckodriver");
			driver = new FirefoxDriver();
			driver.get("https://192.168.123.109");
		    driver.findElement(By.xpath("//div[@id='app']/div/nav/div[4]/div/div/span")).click();
		    driver.findElement(By.xpath("//div[@id='app']/div/nav/div[5]/div/div/span")).click();
		    driver.findElement(By.xpath("//div[@id='app']/div/nav/div[5]/div[2]/div/span")).click();
		  }

		//  @AfterClass(alwaysRun = true)
		//  public void tearDown() throws Exception {
		//    driver.quit();
		//    String verificationErrorString = verificationErrors.toString();
		//    if (!"".equals(verificationErrorString)) {
		//      fail(verificationErrorString);
		//    }
		 // }

		  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		  private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
		}


