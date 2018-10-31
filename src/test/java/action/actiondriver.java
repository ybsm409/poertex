package action;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.OutputType;


import config.startbrowser;

public class actiondriver {
	public WebDriver driver;

	public actiondriver()
	{
			driver= startbrowser.driver;
	}
	/**
	 * 
	 * @param url user should pass web address
	 */
	public void lauchapplication(String url)
	{
		driver.get(url);
	}
	/**
	 * 
	 * @param location is sendkeys element location
	 */
	public void Text(By locator, String data)
	
	{
		driver.findElement(locator).sendKeys(data);
	}
	/**
	 * 
	 * @param locator clickable location
	 */
	public void click(By locator)
	{
		driver.findElement(locator).click();
	}
	/**
	 * 
	 * @param locator element location
	 * @param Type 1=slectbyvalue, 2=selectbyvisibletext
	 * @param valu 
	 */
	public void dropdown(By locator, int Type,String valu)
	{
		Select dd=new Select(driver.findElement(locator));
				switch(Type)
		{
		case(1): dd.selectByValue(valu);
		break;
		case(2): dd.selectByVisibleText(valu);
		}				
		
	}
	/**
	 * 
	 * @param action 1=accept,2=cancel
	 */
	public void alerthandling(int action)
	{
		Alert alert=driver.switchTo().alert();
		switch(action)
		{
		case(1):alert.accept();
		break;
		case(2):alert.dismiss();
		}
		
	}
	public void screenshort() throws IOException 
	{
		//DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		//Date dt = new Date();
		//File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screenshotFile, new File("E:\\Selenium_Scripts_Nov17\\Results\\"+dateFormat.format(dt)+".png"));
		
		DateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		Date dt= new Date();
		File screenshotFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile,  new File("D:\\bala project\\Result\\"+dateFormat.format(dt)+".png"));
	}
	public void mouseaction(String data1, String data2)
	{
		WebElement element= driver.findElement(By.linkText(data1));
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText(data2)).click();
	}

}