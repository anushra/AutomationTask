package testCases;

import org.testng.annotations.Test;

import pageObjects.AmazonHomePage;
import pageObjects.AmazonlistingPage;
import pageObjects.FlipkartHomePage;
import pageObjects.FlipkartListingPage;

public class CompareProductPriceOnBothWebsite extends BaseClass
{
   String searchText = "iPhone XR (64GB) Yellow";

   @Test
   public void compareProductPrice() throws InterruptedException
   {
      AmazonHomePage amazonhp = new AmazonHomePage(driver);
      AmazonlistingPage amazonlp = new AmazonlistingPage(driver);
      FlipkartHomePage flipkarthp = new FlipkartHomePage(driver);
      FlipkartListingPage flipkartlp = new FlipkartListingPage(driver);

      driver.get("https://www.amazon.in");
      logger.info("Login to amazon website");
      amazonhp.typeInSearchTextBox(searchText);
      logger.info("typed in search text box");
      amazonhp.clickOnSearchButton();
      logger.info("click on search button");

      int productPriceOnAmazon = Integer.parseInt(amazonlp.getProductPrice(searchText));
      logger.info("get the price of the product from the amazon site" + productPriceOnAmazon);

      Thread.sleep(2000);

      driver.get("https://www.flipkart.com/");
      logger.info("Login to flipkart website");
      flipkarthp.clickOnLoginPopUpCloseButton();
      flipkarthp.typeSearchTextInSearchTextBox(searchText);
      logger.info("typed in search text box");
      flipkarthp.clickOnSearchButton();
      logger.info("click on search button");

      int productPriceOnFlipkart = Integer.parseInt(flipkartlp.getProductPrice(searchText));
      logger.info("get the price of the product from the flipkart site" + productPriceOnFlipkart);

      if (productPriceOnAmazon < productPriceOnFlipkart)
      {
         System.out.println("Price on amazon website is lesser " + productPriceOnAmazon);
         logger.info("Printed the lesser Price");
      }
      else
      {
         System.out.println("Price on flipkart website is lesser " + productPriceOnFlipkart);
         logger.info("Printed the lesser Price");
      }

   }

}
