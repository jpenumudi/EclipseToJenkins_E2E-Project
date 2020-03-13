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
	
	@Test(priority=1)
	public void Titletest()
	{
		String title = hmnlvng.ValidateHomeNLvngTitle();
		Assert.assertEquals(title, "Home & Living | Etsy");
		System.out.println("Validated the HomeNLiving Title");
	}
	
	@Test(priority=2)
	public void SigninOptionTest()
	{
		boolean present = hmnlvng.validatesigninoption();
		Assert.assertTrue(present);
		System.out.println("Validated the presence of signin option");
	}
	
	@Test(priority=3)
	public void SortByTest() throws InterruptedException
	{
		Thread.sleep(2000);
		hmnlvng.SortByList(prop.getProperty("list")); 
		System.out.println("Validated Sort By dropdown");
	}
	
	@Test(priority=4)
	public void ValidateUrlTest() throws InterruptedException
	{
		String url = hmnlvng.validateTopReviewUrl();
		Assert.assertEquals(url, "https://www.etsy.com/c/home-and-living?explicit=1&order=highest_reviews");	
		System.out.println("Validated Top reviews url");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();	
	}
}
