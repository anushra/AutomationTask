package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonlistingPage
{

   WebDriver ldriver;
   String productPriceOnAmazon;

   public AmazonlistingPage(WebDriver rdriver)
   {
      ldriver = rdriver;
      PageFactory.initElements(rdriver, this);
   }

   @FindBy(xpath = "((//span[@class='a-price-whole']/ancestor::div[@class='sg-row'])[1]//span[contains(text(),'Apple iPhone XR (64GB) - Yellow')]//ancestor::div[@class='sg-row'])[1]//div[@class='sg-row'][2]//span[@class='a-price-whole']")
   @CacheLookup
   WebElement productPrice;

   public String getProductPrice(String searchText)
   {
      return productPriceOnAmazon = productPrice.getText().replaceAll(",", "");
   }

}
