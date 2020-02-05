package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripAdvisorHomePage
{
   WebDriver ldriver;

   public TripAdvisorHomePage(WebDriver rdriver)
   {
      ldriver = rdriver;
      PageFactory.initElements(rdriver, this);
   }

   @FindBy(xpath = "//span[contains(text(),'Search')]")
   @CacheLookup
   WebElement searchTextBox;

   @FindBy(id = "mainSearch")
   @CacheLookup
   WebElement searchTextBoxOnsearchFinder;

   @FindBy(id = "SEARCH_BUTTON")
   @CacheLookup
   WebElement searchButtonOnSearchFinder;

   public void typeInSearchTextBox(String searchText)
   {
      searchTextBoxOnsearchFinder.sendKeys(searchText);
   }

   public void clickOnSearchButton()
   {
      searchTextBox.click();
   }

   public void clickOnSearchButtonOnSearchFinder()
   {
      searchButtonOnSearchFinder.click();
   }

}
