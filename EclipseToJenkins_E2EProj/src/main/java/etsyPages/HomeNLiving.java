package etsyPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBaseClass;

public class HomeNLiving extends TestBaseClass{
	
	// create page factory for the objects on homenliving page
	
		@FindBy(xpath="//span[@id='catnav-primary-link-891']")
		WebElement HomeNlivinglink;
		
		@FindBy(xpath="//*[@id='gnav-header-inner']/div[4]/nav/ul/li[1]/button")
		WebElement signinoption;
		
		@FindBy(xpath="//span[@class='wt-menu__trigger__label']")
		WebElement sortbydropdown;
		
		@FindBy(xpath="//a[contains(text(),'Top Customer Reviews')]")
		WebElement topreview;
		
		// INITIALIZING THE PAGE OBJECTS
		
				public HomeNLiving() // CONSTRUCTOR CLASS	
				{
					PageFactory.initElements(driver, this); 
				}
		
		// ACTIONS
				
			// Validate Title
				
				public String ValidateHomeNLvngTitle()
				{
					HomeNlivinglink.click();
					return driver.getTitle();
				}
			
			// Validate the presence of Signin option				
				
				public Boolean validatesigninoption()	
				{	
					HomeNlivinglink.click();
					return signinoption.isDisplayed();
				}
			
			// Validate Sort By functionality
				
				public void SortByList(String list) throws InterruptedException
				{
					HomeNlivinglink.click();				
					sortbydropdown.click();
					Actions action = new Actions(driver);
					action.moveToElement(topreview).click().build().perform();
					
					return;
				}
				
			// Validate url after selecting top reviews under sort by
				
				public String validateTopReviewUrl() throws InterruptedException
				{
					HomeNlivinglink.click();				
					sortbydropdown.click();
					Actions action = new Actions(driver);
					action.moveToElement(topreview).click().build().perform();
					return driver.getCurrentUrl();
				}


}
