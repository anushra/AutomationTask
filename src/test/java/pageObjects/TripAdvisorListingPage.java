package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripAdvisorListingPage {
	 WebDriver ldriver;
		
		
		public TripAdvisorListingPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath="(//div[@class='ui_columns'])[1]")
		@CacheLookup
		WebElement firstItemAppearedOnSearch;
		
		public void clickOnFirstItemAppearedOnSearch()
		{
			firstItemAppearedOnSearch.click();
		}


}
