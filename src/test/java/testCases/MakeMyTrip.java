package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;




public class MakeMyTrip extends BaseClass {
	@SuppressWarnings("deprecation")
	@Test
	public void abc() throws InterruptedException
	{
		String date="Fri Nov 11 2022";
		String month="November 2022";
		WebDriverWait wait = new WebDriverWait(driver,40);
		driver.get("https://www.makemytrip.com/");
		WebElement element=driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]"));
		wait.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(10000);
	    
		
		try
		{
         wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='langCardClose']"))));
				driver.findElement(By.xpath("//*[@class='langCardClose']")).click();
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]")).click();
		Thread.sleep(10000);
		
	
		
		while(true)
		{
			String text=driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[2]")).getText();
		    System.out.println(text);
		if(text.equals(month))
		{
			driver.findElement(By.xpath("//div[@aria-label='"+date+"']")).click();
			break;	
		}
		else
		{
			WebElement elementq= driver.findElement(By.xpath("//*[@aria-label='Next Month']"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", elementq);
		}
		}
	     Assert.assertEquals(true, true);
	}

}
