package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage {
	
	WebDriver ldriver;
		
		public FlipkartHomePage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath="//button[contains(text(),'✕')]")
		@CacheLookup
		WebElement closeButtonOnLoginPopUp;
		
		@FindBy(name="q")
		@CacheLookup
		WebElement searchTextBox;

		@FindBy(xpath="//button[@type='submit']")
		@CacheLookup
		WebElement searchButton;
		
		
		public void clickOnLoginPopUpCloseButton()
		{
			closeButtonOnLoginPopUp.click();
		}
		
		public void typeSearchTextInSearchTextBox(String searchText)
		{
			searchTextBox.sendKeys(searchText);
		}

		public void clickOnSearchButton()
		{
			searchButton.click();
		}
		
		

}
