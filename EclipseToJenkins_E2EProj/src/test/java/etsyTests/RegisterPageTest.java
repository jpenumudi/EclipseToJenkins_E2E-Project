package etsyTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import etsyPages.Homepage;
import etsyPages.Register;
import testBase.TestBaseClass;

public class RegisterPageTest extends TestBaseClass {
	
	Register regstr;
	Homepage homepg; 
	
	public RegisterPageTest()  // constructor for RegisterPageTest class
	{
		super(); // it calls super class constructor .. super class is the parent class .. so it will call the parent class constructor
				 // // SUPER KEY WORD REFERS TO SUPERCLASS (PARENT CLASS) OBJECTS. HERE THE PARENT CLASS IS TESTBASE CLASS. 
	}
	
	@BeforeMethod
	public void setup()
	{
		// CALL THE INITIALIZATION METHOD
		
		initialization();
		
		regstr = new Register();	// this object will let us access all the methods of Register class. 		
	}
	
	@Test(priority=1)
	public void RegisterHeadingTest() throws InterruptedException
	{
		Thread.sleep(2000);
		String heading = regstr.ValidateHeading();
		Assert.assertEquals(heading, "Create your account");
		System.out.println("RegisterPageTest: 1- Validated heading on the register page");
	}
	
	
	@Test(priority=2)
	public void TermsofuseLinkTest()
	{
		regstr.ValidateTermsLink();	
		System.out.println("RegisterPageTest: 2 - Validated Terms of Use link");
	}
	
	
	@Test(priority=3)
	public void createaccountTest()
	{
		// createaccount method is returning object of homepage class. so the result of right hand side can be stored in the homepg 
		// reference variable. 
		
		homepg = regstr.createaccount(prop.getProperty("email"), prop.getProperty("firstname"), prop.getProperty("password"));
		System.out.println("RegisterPageTest: 3 - Created an account successfully");
	}  
		
	@AfterMethod
	public void teardown()
	{
		driver.quit();	
	}

}
