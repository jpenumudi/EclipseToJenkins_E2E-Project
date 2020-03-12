package etsyPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBaseClass;

public class CraftSupplies extends TestBaseClass {
	
	// create page factory for the objects on homenliving page
	
		@FindBy(xpath="//span[contains(text(), 'Craft Supplies')]")
		WebElement CraftSupplieslink;
		
		@FindBy(xpath="//*[@id='search-filter-reset-form']/fieldset[1]/div/button[1]")
		WebElement showmore;
		
		@FindBy(xpath="//label[contains(text(),'FREE shipping')]")
		WebElement freeshippingchkbox;
		
		@FindBy(xpath="//label[contains(text(),'Handmade')]")
		WebElement handmaderadiobtn;
		
		@FindBy(id="shop-location-input")
		WebElement locationtextbox;
		
		@FindBy(xpath="//form[1]/fieldset[6]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/button[1]/span[1]/*")
		WebElement locationarrow;
		
		// INITIALIZING THE PAGE OBJECTS
		
			public CraftSupplies() // CONSTRUCTOR CLASS	
				{
					PageFactory.initElements(driver, this); 
				}
			
			// ACTIONS
		
		// Validate Show more feature
			
		public void ValidateShowMore()
		{
			CraftSupplieslink.click();
			showmore.click();
			return;		
		}
		
		// validate checkbox 
		
		public void ValidateCheckBox()
		{
			CraftSupplieslink.click();
			freeshippingchkbox.click();
			return;		
		}
		
		// validate checkbox 
		
		public void ValidateRadioButton()
		{
			CraftSupplieslink.click();
			handmaderadiobtn.click();
			return;		
		}
		
		public void ValidateTextBox(String location)
		{
			CraftSupplieslink.click();
			locationtextbox.sendKeys(location);
			locationarrow.click();
			return;
		}

}
