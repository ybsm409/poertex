package pages;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public  class screenshot{
    static WebDriver driver;
    public static void takescreenshot() throws IOException
    {
    DateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	Date dt= new Date();
	File screenshotFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotFile , new File("D:\\bala project\\Result\\"+dateFormat.format(dt)+".png"));
	
	}
}