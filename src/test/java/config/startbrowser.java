package config;


import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class startbrowser {
   public static WebDriver driver;
   
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","D:\\bala project\\lib\\chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	    }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
  }

}
