package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage
{

   WebDriver ldriver;

   public AmazonHomePage(WebDriver rdriver)
   {
      ldriver = rdriver;
      PageFactory.initElements(rdriver, this);
   }

   @FindBy(id = "twotabsearchtextbox")
   @CacheLookup
   WebElement searchTextBox;

   @FindBy(xpath = "//input[@type='submit']")
   @CacheLookup
   WebElement searchButton;

   public void typeInSearchTextBox(String searchText)
   {
      searchTextBox.sendKeys("iPhone XR (64GB) � Yellow");
   }

   public void clickOnSearchButton()
   {
      searchButton.click();
   }

}
