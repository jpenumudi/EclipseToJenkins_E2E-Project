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
	
	@Test(priority=7)
	public void HmPg_TitleTest()
	{
		String title = hmpg.ValidateHomePageTitle();
		Assert.assertEquals(title, "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");	
		System.out.println("HomePageTest: 1 - Validated Home page title");

	}
	
	@Test(priority=8)
	public void Hmpg_SigninoptionTest()
	{
		boolean present = hmpg.validatesigninoption();
		Assert.assertTrue(present);
		System.out.println("HomePageTest: 2 - Validated the presence of signin option in home page");
	}
	
	@Test(priority=9)
	public void SearchTest()
	{
		hmpg.ValidateSearch(prop.getProperty("searchfor"));
		System.out.println("HomePageTest: 3 - Validated search for functionality");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();	
	}

}
