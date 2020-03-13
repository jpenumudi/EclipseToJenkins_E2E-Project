package etsyTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import etsyPages.Homepage;
import etsyPages.Sign_in;
import testBase.TestBaseClass;

public class SigninPageTest extends TestBaseClass{
	
	Sign_in signin;
	Homepage homepg; 
	
	public SigninPageTest()  // constructor for RegisterPageTest class
	{
		super(); // it calls super class constructor .. super class is the parent class .. so it will call the parent class constructor
				// SUPER KEY WORD REFERS TO SUPERCLASS (PARENT CLASS) OBJECTS. HERE THE PARENT CLASS IS TESTBASE CLASS. 
	}
	
	@BeforeMethod
	public void setup() 
	{
		// CALL THE INITIALIZATION METHOD
		
		initialization();
		
		signin = new Sign_in();	// this object will let us access all the methods of sign in class. 
		
	}
	
	@Test(priority=4)
	public void RegisterBtnTest()
	{
		boolean result = signin.validateregisterbtn();
		Assert.assertTrue(result);
		System.out.println("SigninPageTest: 1 - Validated the presence of register button");
	}  
	
	@Test(priority=5)
	public void Forgot_pwd_test()	{
		signin.ValidateForgtoPwdLink();
		
		System.out.println("SigninPageTest: 2 - Validated forgot password link");
	}
	
	@Test(priority=6)
	public void LoginTest()
	{
		homepg = signin.login(prop.getProperty("email"), prop.getProperty("password"));
		
		System.out.println("SigninPageTest: 3 - Logged into etsy.com site and navigated to the home page");
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();	
	}

}
