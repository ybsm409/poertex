package scripts;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import action.actiondriver;
import config.startbrowser;
import pages.checkout;
import pages.homePage;
import pages.loginpage;
import pages.productdetailpage;
import pages.shoppingcartpage;

public class addtocart extends startbrowser 
{
	public static Properties prop;
  @Test
  public void test1() throws Exception
  {
	  assertEquals("Pass", getscreenshot());
	  Thread.sleep(2000);
  }
  public String getscreenshot() throws Exception
  {
	  try
	  {
		 prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\bala project\\Powertex\\configuration.properties");
		prop.load(ip);
	  actiondriver aDriver=new actiondriver();
	  aDriver.lauchapplication(prop.getProperty("url"));
      assertEquals("Home",driver.getTitle());
      aDriver.click(homePage.loginlnk);
      aDriver.Text(loginpage.userName, prop.getProperty("username"));
      Thread.sleep(1000);
      aDriver.Text(loginpage.pass, prop.getProperty("password"));    
      aDriver.click(loginpage.lginbtn);   
      Thread.sleep(2000);
      String name=driver.findElement(By.xpath("//*[@id=\"menuRight\"]/li[1]/div/span/span")).getText();
      System.out.println(name);
      assertEquals("Neelima !",name);
      Thread.sleep(1000);
      aDriver.click(homePage.productlnk);  
      Thread.sleep(1500);
      aDriver.click(productdetailpage.addtocartbtn);      
      Thread.sleep(1000);
     aDriver.click(productdetailpage.Okbtn);
     Thread.sleep(1000);
     aDriver.click(productdetailpage.shoppincartbtn);
     Thread.sleep(1000);
     aDriver.click(shoppingcartpage.paymentbtn);
     aDriver.Text(checkout.mobTxt, prop.getProperty("mobile"));
     aDriver.Text(checkout.pinTxt, prop.getProperty("pincode"));
     aDriver.click(checkout.getBtn);
     aDriver.wait(checkout.dealerSelect, 30);
     aDriver.click(checkout.dealerSelect);
     //Thread.sleep(5000);
     WebDriverWait wait=new WebDriverWait(driver, 30);
     wait.until(ExpectedConditions.elementToBeClickable(checkout.nextBtn));
     aDriver.click(checkout.nextBtn);
     aDriver.click(checkout.reviewNxtBtn);
     aDriver.click(checkout.codBtn);
     aDriver.click(checkout.procedBtn);
      //Alert alert=driver.switchTo().alert();
      //alert.accept();
      Thread.sleep(2000);
      return "Pass";
	  }
	  catch(AssertionError e)
	  {
		   Thread.sleep(3000);
		    DateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt= new Date();
			File screenshotFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("D:\\bala project\\Result\\"+dateFormat.format(dt)+".png"));
			System.out.println("Assert Fail");
			return "Fail";
	  }
	  catch(NoSuchElementException e)
	  {   
		  Thread.sleep(3000);
		  DateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt= new Date();
			File screenshotFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("D:\\bala project\\Result\\"+dateFormat.format(dt)+".png"));
			System.out.println("Element notfount");
			return "Fail";
	  }
	  catch(Exception e)
	  {   
		  Thread.sleep(3000);
		  DateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt= new Date();
			File screenshotFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("D:\\bala project\\Result\\"+dateFormat.format(dt)+".png"));
			System.out.println("Element not visible");
			return "Fail";
	  }
	  
  }
  }
 

