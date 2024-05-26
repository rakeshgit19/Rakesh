package Constant_Functions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class PbConstant 
{
	public static WebDriver driver;
	public static FileInputStream fis;
	String Expval,Actval;
	public static Properties pr;
	@BeforeMethod
	public String lunch() throws IOException
	{

		System.setProperty("webdriver.chrome.driver", "d://chromeDriver.exe");
		driver = new ChromeDriver();
		fis = new FileInputStream("D:\\Framework_Rakesh\\Maven_Project\\src\\test\\java\\Configure\\OR.Properties");
		pr = new Properties();
		pr.load(fis);
		driver.get(pr.getProperty("objurl"));
		driver.manage().window().maximize();
		
		Expval = "login ";
		Actval = driver.findElement(By.xpath(pr.getProperty("objloginbtn"))).getText();
		System.out.println(Actval);
		
		//verify application open or not
		if (Actval.equalsIgnoreCase(Expval)) 
		{
			System.out.println("Application open successfully");
			return "pass";
		}
		else 
		{
			System.out.println("Application not open successfully");
			return "fail";
		}
	}
	
	@AfterMethod
	public String logout()
	{
		driver.findElement(By.xpath(pr.getProperty("objlogout"))).click();
		Expval = "Primusbank";
		Actval = driver.getCurrentUrl();
		System.out.println(Actval);
		
		//verify logout
		if (Actval.contains(Expval)) 
		{
			System.out.println("logout success");
			return "pass";
		}
		else 
		{

			System.out.println("logout unsuccess");
			return "fail";
		}
	}
	
}
