package etsyTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import etsyPages.Homepage;
import testBase.TestBaseClass;

public class HomePageTest extends TestBaseClass{
	
	Homepage hmpg;
	
	
	public HomePageTest()  // constructor for HomePageTest class
	{
		super(); // SUPER KEY WORD REFERS TO SUPERCLASS (PARENT CLASS) OBJECTS. HERE THE PARENT CLASS IS TESTBASE CLASS. 
	}
	
	@BeforeMethod
	public void setup()
	{
		// CALL THE INITIALIZATION METHOD
		
		initialization();
		
		// CREATING AN OBJECT FOR THE HOMEPAGE CLASS;
		
		hmpg = new Homepage();	
	}
	
	@Test(priority=1)
	public void TitleTest()
	{
		String title = hmpg.ValidateHomePageTitle();
		Assert.assertEquals(title, "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");	
		System.out.println("Validated Home page title");
		System.out.println("This test was triggered from Jenkins");
	}
	
	@Test(priority=2)
	public void SigninoptionTest()
	{
		boolean present = hmpg.validatesigninoption();
		Assert.assertTrue(present);
		System.out.println("Validated the presence of signin option in home page");
	}
	
	@Test(priority=3)
	public void SearchTest()
	{
		hmpg.ValidateSearch(prop.getProperty("searchfor"));
		System.out.println("Validated search for functionality");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();	
	}

}
