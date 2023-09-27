package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestLoginPage 
{
	public WebDriver ldriver;
	
	public TestLoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='Account & Lists']")
	@CacheLookup
	WebElement btnhello_SignIn;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']")
	@CacheLookup
	WebElement btnsign_In;
	
	@FindBy(xpath="//input[@id='ap_email']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='continue']")
	@CacheLookup
	WebElement btnContinue;
	
	@FindBy(xpath="//input[@id='ap_password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='rememberMe']")
	@CacheLookup
	WebElement chkRememberMe;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(xpath="//a[@id='nav-logo-sprites']")
	@CacheLookup
	WebElement lnkAmzLogo;
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	@CacheLookup
	WebElement lnkMouseHoverLogout;
	
	@FindBy(xpath="//span[normalize-space()='Sign Out']")
	@CacheLookup
	WebElement lnkLogout;
	
	public void clickHelloSignInIn()
	{
		btnhello_SignIn.click();
	}
	
	public void clickSignInbutton()
	{
		btnsign_In.click();
	}
	
	public void setupUsername(String uname)
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	public void clickContinueButton()
	{
		btnContinue.click();
	}
	
	public void setupPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}
	
	public void CheckboxRememberMe()
	{
		chkRememberMe.click();
	}
	
	public void ClickSubmitButton()
	{
		btnSubmit.click();
	}
	
	public void ClickOnAmazonLogo()
	{
		lnkAmzLogo.click();
	}
	
	public void MouseHoveronLogoutLink()
	{
		lnkMouseHoverLogout.click();
	}
	
	public void ClickonLogoutLink()
	{
		lnkLogout.click();
	}
}
