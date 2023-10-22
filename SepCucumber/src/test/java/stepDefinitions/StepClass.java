package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.PageClass;

public class StepClass 
{
	public WebDriver driver;
	public PageClass tlp;
	
	@Given("User launch Chrome Browser")
	public void user_launch_chrome_browser() 
	{
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   
	   tlp = new PageClass(driver);
	   
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

	@Then("User should click on Signin button")
	public void user_dhould_click_on_signin_button() throws Exception
	{
		tlp.ClickSubmitButton();
		Thread.sleep(3000);
	}

	@Then("User should verify the page title as {string}")
	public void user_should_verify_the_page_title_as(String title)
	{
	   WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
	   if(logo.isDisplayed())
	   {
		   System.out.println("Page Title is:"+title);
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
		
		
	    driver.quit();
	}
	
//	**********************************************Adding An Item to Cart********************************************************
	
		
	@Then("User should select {string} from the dropdown")
	public void user_should_select_from_the_dropdown(String string) throws Exception 
	{
		WebElement drpdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		
		Select all = new Select(drpdown);
		System.out.println(all);
		all.selectByVisibleText("All Categories");
		
		// Getting the size of the Dropdown List
		List<WebElement> drpvalues = all.getOptions();
		System.out.println("Printing the total number of Dropdown Values:"+drpvalues.size());
		
		// Printing all the values in a Console Window
		for(WebElement value:drpvalues)
		{
			System.out.println(value.getText());
		}
		
		Thread.sleep(3000);
	}

	@Then("User should enter {string}")
	public void user_should_enter(String pname) 
	{
	   tlp.EnterPixelInTheSearch(pname);
	}

	@Then("User should click on Search button")
	public void user_should_click_on_search_button() 
	{
	   tlp.ClickOnSearchButton();
	}

	@Then("User should select the {string} from the search page")
	public void user_should_select_the_from_the_search_page(String string) throws Exception 
	{
	  WebElement pixel_Link = driver.findElement(By.linkText("Pixel 7 Pro 5G (Snow, 12GB RAM, 256GB Storage) Smartphone"));
	  pixel_Link.click();
	  Thread.sleep(3000);
	  
	  Set<String> windowIds = driver.getWindowHandles();
	  System.out.println("Printing the Page Title ID's:"+windowIds);
	  
	  for(String winId:windowIds)
	  {
		 String title = driver.switchTo().window(winId).getTitle();
		 Thread.sleep(2000);
		  if(title.equals("Pixel 7 Pro 5G (Snow, 12GB RAM, 256GB Storage) Smartphone : Amazon.in: Electronics"))
		  {
			  driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		  }
	  }
	  
	}

//	@Then("User should click on Add to Cart button")
//	public void user_should_click_on_add_to_cart_button() 
//	{
//	  tlp.ClickOnAddToCartButton();
//	}

	@Then("User should verify the Text as {string}")
	public void user_should_verify_the_text_as(String text) 
	{
	    String confirmation = driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")).getText();
	    if(confirmation.equals("Added to Cart"))
	    {
	    	System.out.println("We are good until now");
	    }
	    
	    else
	    {
	    	System.out.println("We are in the wring path");
	    }
	}
	
//	************************************Deleting the Item from Cart************************************
	
	@Then("User should click on Cart button")
	public void user_should_click_on_cart_button() 
	{
		tlp.ClickOnCart();
	}

	@Then("User should verify the {string} header")
	public void user_should_verify_the_header(String header) 
	{
		tlp.EmptyCart();
	}

	@Then("User should click on delete button")
	public void user_should_click_on_delete_button()
	{
		tlp.DeleteAnItemFromCart();	    
	}

}