package com.actitime.genrics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {

		 static {
		 System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//		 System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		 }
		 public static WebDriver driver;
//		 public FileLib f=new FileLib();
		 
		 @BeforeTest
		 public void openBrowser()
		 {
		 Reporter.log("openBrowser",true);

		  driver=new ChromeDriver(); 
		 }
		 
		 
		 @AfterTest
		 public void closeBrowser() throws InterruptedException {
		  Reporter.log("closeBrowser",true);
		  Thread.sleep(5000);
		  driver.close();
		 }
		 
		 
		 @BeforeMethod
		 public void login() {
		  driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.get("http://demo.actitime.com/");
		  Reporter.log("login",true);
		  driver.findElement(By.id("username")).sendKeys("admin");
		  driver.findElement(By.name("pwd")).sendKeys("manager");
		  driver.findElement(By.xpath("//div[text()='Login ']")).click();
		 }
		 
		 
		 @AfterMethod
		 public void logout() throws InterruptedException {
		  Thread.sleep(5000);
		Reporter.log("logout",true);
		  driver.findElement(By.id("logoutLink")).click();
		 }
		 
		
}
