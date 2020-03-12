package etsyPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBaseClass;

public class Homepage extends TestBaseClass {
	
	// CREATE PAGE FACTORY OR OBJECT REPOSITORY BY USING @FINDBY ANNOTATION
	
		@FindBy(xpath="//*[@id='gnav-header-inner']/div[4]/nav/ul/li[1]/button")
		WebElement signinoption;
		
		@FindBy(name="search_query")
		WebElement searchbar;
		
		@FindBy(xpath="//form[1]/div[1]/div[1]/button[1]/span[1]/*")
		WebElement searchbutton;
		
		// INITIALIZING THE PAGE OBJECTS
		
			public Homepage() // CONSTRUCTOR CLASS	
			{
				PageFactory.initElements(driver, this); 
			}
			
		// ACTIONS 
			
			// Validate title
			
			public String ValidateHomePageTitle()
			{
				return driver.getTitle();
			}
			
			// Validate the presence of Signin option				
			
			public Boolean validatesigninoption()	
			{			
				return signinoption.isDisplayed();
			}
			
			// Validate search functionality 
			
			public void ValidateSearch(String searchkeyword )
			{
				searchbar.sendKeys(searchkeyword);
				searchbutton.click();
			}			

}
