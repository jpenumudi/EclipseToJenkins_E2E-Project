package etsyPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBaseClass;

public class Register extends TestBaseClass {
	
	// CREATE PAGE FACTORY OR OBJECT REPOSITORY BY USING @FINDBY ANNOTATION
	
		@FindBy(xpath="//*[@id='gnav-header-inner']/div[4]/nav/ul/li[1]/button")
		WebElement Signin;
		
		@FindBy(xpath="//*[@id='join-neu-form']/div[1]/div/div[1]/div/button")
		WebElement Register;
		
		@FindBy(xpath = "//h1[@id='join-neu-overlay-title']")
		//@FindBy(id="join-neu-overlay-title")
		WebElement heading;
		
		@FindBy(xpath="//input[@id='join_neu_email_field']")
		WebElement email;
		
		@FindBy(xpath="//input[@id='join_neu_first_name_field']")
		WebElement firstname;
		
		@FindBy(xpath="//input[@id='join_neu_password_field']")
		WebElement password;
		
		@FindBy(xpath="//button[@name='submit_attempt']")
		WebElement RegBtn;
		
		@FindBy(linkText = "Terms of Use")
		WebElement termsofuselink;  
		
		// INITIALIZING THE PAGE OBJECTS
		
		public Register() // CONSTRUCTOR CLASS	
		{
			PageFactory.initElements(driver, this); // initElements method is used to initialize the page factory. 
			// this = current class object 	
		}
		
		// ACTIONS 
		
		// VALIDATE THE HEADING ON REGISTER PAGE  -- IS THIS CORRECT 
		
			public String ValidateHeading()
			{
				Signin.click();
				Register.click();
				return heading.getText();
			}
				
		// VALIDATE THE TERMS TO USE LINK (SHOULD NAVIGATE TO TERMS TO LINK PAGE)
		
			public void ValidateTermsLink()
			{
				Signin.click();
				Register.click();
				termsofuselink.click();
				return;			
			}  
				
		// ACTIONS ON WEB ELEMENTS DEFINED ABOVE
		
		public Homepage createaccount(String emailadd, String fname, String pwd)
		{
			Signin.click();
			Register.click();
			email.sendKeys(emailadd);
			firstname.sendKeys(fname);
			password.sendKeys(pwd);
			RegBtn.click();
					
			return new Homepage();
			
		}  

}
