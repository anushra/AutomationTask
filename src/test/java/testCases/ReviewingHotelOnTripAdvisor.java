package testCases;

import java.util.Set;

import org.testng.annotations.Test;

import pageObjects.TripAdvisorHomePage;
import pageObjects.TripAdvisorListingPage;
import pageObjects.TripAdvisorProductPage;
import pageObjects.TripAdvisorReviewPage;

public class ReviewingHotelOnTripAdvisor extends BaseClass
{
   String searchText = "Club Mahindra";
   String reviewTitle = "Excellent Services";
   String review = "Nice place for a fun trip. Good for family. Nearby bus station.";

   @Test
   public void reviewingHotelOnTripAdvisor() throws InterruptedException
   {
      TripAdvisorHomePage homePage = new TripAdvisorHomePage(driver);
      TripAdvisorListingPage listingPage = new TripAdvisorListingPage(driver);
      TripAdvisorProductPage productPage = new TripAdvisorProductPage(driver);
      TripAdvisorReviewPage reviewPage = new TripAdvisorReviewPage(driver);

      logger.info("Go to tripAdvisor website");
      driver.get("https://www.tripadvisor.in");

      homePage.clickOnSearchButton();

      logger.info("Search on tripAdvisor website");
      homePage.typeInSearchTextBox(searchText);
      homePage.clickOnSearchButtonOnSearchFinder();

      listingPage.clickOnFirstItemAppearedOnSearch();
      logger.info("Clicked on the first search result");

      Set<String> windowHandlers = driver.getWindowHandles();
      java.util.Iterator<String> ir = windowHandlers.iterator();
      String parentWindow = ir.next();

      while (ir.hasNext())
      {
         driver.switchTo().window(ir.next());
         productPage.clickOnWriteAReviewLink();
         Set<String> windowHandlers2 = driver.getWindowHandles();
         java.util.Iterator<String> ir1 = windowHandlers2.iterator();

         String superParentWindow1 = ir1.next();
         String parentWindow1 = ir1.next();
         while (ir1.hasNext())
         {
            driver.switchTo().window(ir1.next());

            reviewPage.clickOnFifthStarInRating();

            reviewPage.typeInReviewTitleTextAreaSection(reviewTitle);
            reviewPage.typeInReviewTextAreaSection(review);
            reviewPage.clickOnFifthStarInHotelServiceRating();
            reviewPage.clickOnFifthStarInRatingValue();
            reviewPage.clickOnFifthStarInRatingHotelCleanliness();
            reviewPage.clickOnSubmitReviewCheckBox();

         }
      }
   }
}
