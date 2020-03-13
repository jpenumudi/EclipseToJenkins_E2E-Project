package etsyTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import etsyPages.HomeNLiving;
import testBase.TestBaseClass;

public class HomeNLivingTest extends TestBaseClass{

	HomeNLiving hmnlvng;
	
	public HomeNLivingTest()  // constructor for HomeNLiving class
	{
		super(); // SUPER KEY WORD REFERS TO SUPERCLASS (PARENT CLASS) OBJECTS. HERE THE PARENT CLASS IS TESTBASE CLASS. 
	}
	
	@BeforeMethod
	public void setup()
	{
		// CALL THE INITIALIZATION METHOD
		
		initialization();
		
		// CREATING AN OBJECT FOR THE HOMENLIVING CLASS;
		
		hmnlvng = new HomeNLiving();	
	}
	
	@Test(priority=10)
	public void HNLTitletest()
	{
		String title = hmnlvng.ValidateHomeNLvngTitle();
		Assert.assertEquals(title, "Home & Living | Etsy");
		System.out.println("HomeNLivingTest: 1 - Validated HomeNLiving Title");
	}
	
	@Test(priority=11)
	public void HNLSigninOptionTest()
	{
		boolean present = hmnlvng.validatesigninoption();
		Assert.assertTrue(present);
		System.out.println("HomeNLivingTest: 2 - Validated the presence of signin option");
	}
	
	@Test(priority=12)
	public void SortByTest() throws InterruptedException
	{
		Thread.sleep(2000);
		hmnlvng.SortByList(prop.getProperty("list")); 
		System.out.println("HomeNLivingTest: 3 - Validated Sort By dropdown");
	}
	
	@Test(priority=13)
	public void UrlTest() throws InterruptedException
	{
		String url = hmnlvng.validateTopReviewUrl();
		Assert.assertEquals(url, "https://www.etsy.com/c/home-and-living?explicit=1&order=highest_reviews");	
		System.out.println("HomeNLivingTest: 4 - Validated Top reviews url");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();	
	}
}
