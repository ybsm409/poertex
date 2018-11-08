package pages;

import org.openqa.selenium.By;

public class homePage {
    public static By welcomename=By.xpath("//span[@id=\\\"menuRight\\\"]/li[1]/div/span/span");
	public static By loginlnk=By.xpath("//*[@id=\"menuRight\"]/li[2]/a");
	public static By productlnk=By.xpath("//*[@id=\"carousel-example\"]/div/div/div/div[2]/div/div/div[1]/div/img");
	public static By wishlistbtn=By.xpath("//*[@id=\"carousel-example\"]/div/div/div/div[3]/div/div/div[1]/div/i");
	public static By powertoolscatbtn=By.className("Power Tools");
	public static By impBtn=By.xpath("//a[contains(text(),'IMPACT DRILL')]");
	public static By noimproduct=By.xpath("//div[4]/div/div/div/div/h2");
	public static By noimproduct1=By.xpath("//div[3]/div/div/div/h2");
	public static By noimproduct2=By.xpath("//*[@id=\"electricdrill\"]/div/div/div[1]/h2");
	public static By angBtn=By.xpath("//*[@id=\"offerswrap\"]/div/div/ul/li[3]/a");
	public static By eledrillBtn=By.xpath("//*[@id=\"offerswrap\"]/div/div/ul/li[2]/a");
	public static By allBtn=By.xpath("//*[@id=\"offerswrap\"]/div/div/ul/li[1]/a");
	public static By viewBtn=By.cssSelector("div.products_rack > button");
 }
