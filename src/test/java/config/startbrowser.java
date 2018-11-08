package config;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class startbrowser {
   public static WebDriver driver;
   protected ThreadLocal<RemoteWebDriver> threadDriver = null;
  @Parameters("browser") 
  @BeforeClass
  public void beforeClass(String browser) throws MalformedURLException {
	  if(browser.equals("firefox"))
	 {
		   //String Node = "http://192.168.20.229:5566/wd/hub";
			//DesiredCapabilities cap = DesiredCapabilities.firefox();
			//cap.setBrowserName("firefox");
			//driver = new RemoteWebDriver(new URL(Node), cap);
		  System.setProperty("webdriver.gecko.driver","D:\\bala project\\lib\\geckodriver.exe");
		  driver =new FirefoxDriver(); 
	 }
	  else if(browser.equals("chrome"))
	  { 
		  //String Node = "http://192.168.20.229:5567/wd/hub";
			//DesiredCapabilities cap = DesiredCapabilities.chrome();
			//cap.setBrowserName("chrome");
			//driver = new RemoteWebDriver(new URL(Node), cap);
		  System.setProperty("webdriver.chrome.driver","D:\\bala project\\lib\\chromedriver.exe");
		  driver =new ChromeDriver();
	  }
	  
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
	    }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
  }

}
