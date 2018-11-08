package scripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import action.actiondriver;
import config.startbrowser;
import pages.homePage;

public class ex extends startbrowser
{
	public WebDriver driver;
	public static Properties prop;
  @Test
  public void f() throws Exception 
  {
	  
	  actiondriver aDriver=new actiondriver();
	  prop = new Properties();
	  try {
		  FileInputStream ip = new FileInputStream("D:\\bala project\\Powertex\\configuration.properties");
		  

		  prop.load(ip);
	 
	  aDriver.lauchapplication(prop.getProperty("url"));
	  Thread.sleep(2000);
	  
	  aDriver.click(homePage.impBtn);
	  Thread.sleep(3000);
	  System.out.println("Hi");
	  aDriver.click(homePage.noimproduct);
	  //System.out.println("HEllo");
	 //String message=driver.findElement(By.xpath("//*[@id=\"impactdrill\"]/div/div/div[1]")).getText();       	 
	 String message=aDriver.getdata(homePage.noimproduct);
	  System.out.println(message); 
	  String actmessage="Products are not Available";
	  
	  if(message.equals(actmessage))
	  {
		  System.out.println("if");
		  aDriver.click(homePage.angBtn);
		  Thread.sleep(2000);
		  String message1=aDriver.getdata(homePage.noimproduct1);
		  System.out.println(message1);
		  if(message1.equals(actmessage))
		  {
			  System.out.println("if2");
			  aDriver.click(homePage.eledrillBtn);
			  Thread.sleep(1000);
			  String message2=aDriver.getdata(homePage.noimproduct2);
			  if(message2.equals(actmessage))
			  {
				  System.out.println("if3");
				  aDriver.click(homePage.allBtn);
				  Thread.sleep(2000);
				  aDriver.click(homePage.viewBtn);
				  Thread.sleep(2000);
				  System.out.println("All");
			  }
		  }
	  }
	  else
	  {
		  System.out.println("Else");
		  aDriver.click(homePage.viewBtn);
		  Thread.sleep(2000);
	  }
	  }
	  catch(NoSuchElementException e)
	  {   
		  
			System.out.println("Element notfount");
			
	  }
	  catch(Exception e)
	  {   
		  
			System.out.println("Element not visible");
		
	  }
  }
}


