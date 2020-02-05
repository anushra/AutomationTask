package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripAdvisorReviewPage {
	
	 WebDriver ldriver;
		
		public TripAdvisorReviewPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath="//span[@id='bubble_rating' or  @data-value='5']")
		@CacheLookup
		WebElement FifthStarInOverallHotelService;
		
		@FindBy(id="ReviewText")
		@CacheLookup
		WebElement reviewTextArea;
		
		@FindBy(id="ReviewTitle")
		@CacheLookup
		WebElement reviewTitleTextArea;
		
		
		@FindBy(xpath="//span[@id='qid12_bubbles']")
		@CacheLookup
		WebElement FifthStarInHotelService;
		
		@FindBy(xpath="//span[@id='qid190_bubbles']")
		@CacheLookup
		WebElement FifthStarInHotelValue ;
		
		@FindBy(xpath="//span[@id='qid14_bubbles']")
		@CacheLookup
		WebElement FifthStarInHotelCleanliness;
		
		@FindBy(id="noFraud")
		@CacheLookup
		WebElement submitReviewCheckBox;
		
		public void clickOnFifthStarInRating()
		{
			Actions action = new Actions(ldriver);
			Action ac=action.moveToElement(FifthStarInOverallHotelService).build();
			ac.perform();
			FifthStarInOverallHotelService.click();
		}
		
		public void typeInReviewTitleTextAreaSection(String reviewTitle)
		{
			reviewTextArea.sendKeys(reviewTitle);
		}
		
		public void typeInReviewTextAreaSection(String review)
		{
			reviewTextArea.sendKeys(review);
		}
		
		
		public void clickOnFifthStarInHotelServiceRating()
		{
			FifthStarInHotelService.click();
		}
		
		public void clickOnFifthStarInRatingValue()
		{
			FifthStarInHotelValue.click();
		}
		
		public void clickOnFifthStarInRatingHotelCleanliness()
		{
			FifthStarInHotelCleanliness.click();
		}
		
		public void clickOnSubmitReviewCheckBox()
		{
			submitReviewCheckBox.click();
		}

}
