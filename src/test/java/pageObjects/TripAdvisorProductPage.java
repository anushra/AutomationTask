package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripAdvisorProductPage {
	
	 WebDriver ldriver;
		
		
		public TripAdvisorProductPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}

		@FindBy(xpath="//a[contains(text(),'Write a review')]")
		@CacheLookup
		WebElement writeAReviewLink;
		
		
		public void clickOnWriteAReviewLink()
		{
			writeAReviewLink.click();
		}
		
		
}
