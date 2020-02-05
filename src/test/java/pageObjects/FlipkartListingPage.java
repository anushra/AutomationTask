package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartListingPage
{
   WebDriver ldriver;
   String productPriceOnFlipkart;

   public FlipkartListingPage(WebDriver rdriver)
   {
      ldriver = rdriver;
      PageFactory.initElements(rdriver, this);
   }

   @FindBy(xpath = "//div[@class='_1vC4OE _2rQ-NK']/ancestor::div[@class='_1-2Iqu row']//div[contains(text(),'Apple iPhone XR (Yellow, 64 GB)')]//ancestor::div[@class='_1-2Iqu row']//div[@class='_1vC4OE _2rQ-NK']")
   @CacheLookup
   WebElement productPrice;

   public String getProductPrice(String searchText)
   {
      return productPriceOnFlipkart = productPrice.getText().replaceAll(",", "").substring(1);
   }

}
