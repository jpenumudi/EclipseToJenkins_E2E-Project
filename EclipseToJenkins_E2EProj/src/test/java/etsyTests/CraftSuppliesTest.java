package etsyTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import etsyPages.CraftSupplies;
import testBase.TestBaseClass;

public class CraftSuppliesTest extends TestBaseClass {
	
	CraftSupplies craftsup;
	
	public CraftSuppliesTest()  // constructor for HomeNLiving class
	{
		super(); // SUPER KEY WORD REFERS TO SUPERCLASS (PARENT CLASS) OBJECTS. HERE THE PARENT CLASS IS TESTBASE CLASS. 
	}
	
	@BeforeMethod
	public void setup()
	{
		// CALL THE INITIALIZATION METHOD
		
		initialization();
		
		// CREATING AN OBJECT FOR THE CRAFTSUPPLIES CLASS;
		
		 craftsup = new CraftSupplies();		
	}
	
	@Test(priority=1) 
	public void ShowMoreTest() throws InterruptedException
	{
		Thread.sleep(2000);
		craftsup.ValidateShowMore();
		System.out.println("Validated Show more link");
	}
	
	@Test(priority=2)
	public void CheckBoxTest() throws InterruptedException
	{
		Thread.sleep(2000);
		craftsup.ValidateCheckBox();
		System.out.println("Validated check box");
	}
	
	@Test(priority=3)
	public void RadioButtonTest() throws InterruptedException
	{
		Thread.sleep(2000);
		craftsup.ValidateRadioButton();
		System.out.println("Validated Radio Button");
	}
	
	@Test(priority=4)
	public void locationTest()
	{
		craftsup.ValidateTextBox(prop.getProperty("location"));
		System.out.println("Validation Custom location field");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();	
	}		

}
