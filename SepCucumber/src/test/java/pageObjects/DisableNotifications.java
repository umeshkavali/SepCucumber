package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DisableNotifications
{
	
	public static void main(String[] args) 
	{	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver(options);		
		
		driver.get("https://www.axisbank.com/");
		driver.manage().window().maximize();
		
	}
}
