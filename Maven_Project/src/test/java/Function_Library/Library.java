package Function_Library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import Constant_Functions.PbConstant;

public class Library extends PbConstant
{
//WebDriver driver;
//	FileInputStream fis;
	String Expval,Actval;

	
	
	public String login(String username,String password)
	{
		driver.findElement(By.xpath(pr.getProperty("objusername"))).sendKeys(username);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		driver.findElement(By.xpath(pr.getProperty("objpassword"))).sendKeys(password);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(pr.getProperty("objloginbtn"))).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(pr.getProperty("objusername"))).clear();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Expval = "adminflow";
		Actval = driver.getCurrentUrl();
		
		//verify application login or not
		if (Actval.contains(Expval)) 
		{
			System.out.println("login success");
			return"pass";
		}
		else 
		{
		
			System.out.println("login fail");
			return "fail";
		}
	}
	
	

}
