package etsyPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBaseClass;

public class Sign_in extends TestBaseClass {
	
	// CREATE PAGE FACTORY OR OBJECT REPOSITORY BY USING @FINDBY ANNOTATION
	
	@FindBy(xpath="//*[@id='gnav-header-inner']/div[4]/nav/ul/li[1]/button")
	WebElement Signin;
	
	@FindBy(xpath = "//input[@id='join_neu_email_field']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='join_neu_password_field']")
	WebElement password;
	
	@FindBy(xpath="//span[@class='checkbox-label']")
	WebElement checkbox;
	
	@FindBy(xpath="//button[@name='submit_attempt']")
	WebElement signinbutton;
	
	@FindBy(xpath="//form[1]/div[1]/div[1]/div[1]/div[1]/button[1]")
	WebElement RegisterButton;
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgotpwdlink;
	
	
	// INITIALIZING THE PAGE OBJECTS
	
	public Sign_in() // CONSTRUCTOR CLASS	
	{
		PageFactory.initElements(driver, this); // initElements method is used to initialize the page factory. 
		// this = current class object 	
	}
	
	// ACTIONS 
	
	// VALIDATE THE PRESENCE OF REGISTER BUTTON 
	
	public Boolean validateregisterbtn()
	{
		Signin.click();
		return RegisterButton.isDisplayed();
	}
	
	// VALIDATE FORGOT YOUR PASSWORD LINK
	
	public void ValidateForgtoPwdLink()
	{
		Signin.click();
		forgotpwdlink.click();
		return;
	}
	
	// ACTIONS ON WEB ELEMENTS DEFINED ABOVE
			
	public Homepage login(String emailadd, String pwd)
	{
		Signin.click();
		email.sendKeys(emailadd);
		password.sendKeys(pwd);
		checkbox.click();
		signinbutton.click();
					
		return new Homepage();
	}
	

}
