package testCases;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.netty.util.internal.SystemPropertyUtil;

public class Program1 extends BaseClass {

    @Test
    public void framesSwitch() throws InterruptedException
    {
    	driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
    	Thread.sleep(3000);
    	
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.linkText("Visit W3Schools.com!")).click();
		Set<String> set=driver.getWindowHandles();
		Iterator<String> ir= set.iterator();
		String parentIterator= ir.next();
		String childIterator=ir.next();
		
		driver.switchTo().window(childIterator);
		driver.findElement(By.id("search2")).sendKeys("html tutorial");
		driver.close();
	    driver.switchTo().window(parentIterator);
	    String text="The a target attribute";
	    List<WebElement> list=driver.findElements(By.tagName("iframe"));
	    System.out.println("no of frames are "+list.size());
	    for(int i=0;i<list.size();i++)
	    {
	    	driver.switchTo().frame(i);
	    	 
	    	
	    	/*if(.contains(text))
	    	{
	    		System.out.println("text is present in frame "+i);
	    	}
	    	else
	    	{
	    		System.out.println("not present");
	    	}*/
	    }
	    
	     	
		
	}
}
