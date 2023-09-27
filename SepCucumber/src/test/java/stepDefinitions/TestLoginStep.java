package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.TestLoginPage;

public class TestLoginStep 
{
	public WebDriver driver;
	public TestLoginPage tlp;
	
	@Given("User launch Chrome Browser")
	public void user_launch_chrome_browser() 
	{
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   
	   tlp = new TestLoginPage(driver);
	   
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("User navigates to the URL {string}")
	public void user_navigates_to_the_url(String url) 
	{
	   driver.get(url);
	}

	@Then("User should mouseHover to Hello SignIn link")
	public void user_should_mouse_hover_to_hello_sign_in_link() 
	{
		WebElement hello_SignIn = driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"));
		WebElement SignInlnk = driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(hello_SignIn).moveToElement(SignInlnk).click().build().perform();
	}

	@When("User enters Email ID as {string}")
	public void user_enters_email_id_as(String email) 
	{
		tlp.setupUsername(email);
	}

	@Then("User should click on Continue button")
	public void user_should_click_on_continue_button() 
	{
		tlp.clickContinueButton();
	}

	@Then("User enters Password as {string}")
	public void user_enters_password_as(String password) 
	{
		tlp.setupPassword(password);
	}

	@Then("User should click on the checkbox")
	public void user_should_click_on_the_checkbox() 
	{
		tlp.CheckboxRememberMe();
	}

	@Then("User dhould click on Signin button")
	public void user_dhould_click_on_signin_button() throws Exception
	{
		tlp.ClickSubmitButton();
		Thread.sleep(3000);;
	}

	@Then("User should verify the page title as {string}")
	public void user_should_verify_the_page_title_as(String title)
	{
	   WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
	   if(logo.isDisplayed())
	   {
		   System.out.println("Successfull");
	   }
	   
	   else
	   {
		   System.out.println("Failed");
	   }
	}

	@Then("User should click on Logout link")
	public void user_should_click_on_logout_link()
	{
		WebElement hello_Umesh = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		WebElement signOut = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(hello_Umesh).moveToElement(signOut).click().build().perform();
		
	}

	@Then("User should close the browser finally")
	public void user_should_close_the_browser_finally() 
	{
	    driver.close();
	}

}
