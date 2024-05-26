package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Jenkins 
{
	WebDriver driver;

	@BeforeMethod
	public void lunch()
	{
		System.setProperty("webdriver.chrome.driver","d://chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://orangehrm.qedgetech.com");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);
	}
	@Test
	public void login()
	{
	 driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	 driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Qedge123!@#");
	 driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	}
	@AfterMethod
	public void logout()
	{
		driver.quit();
	}
}
