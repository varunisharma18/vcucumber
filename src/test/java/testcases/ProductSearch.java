package testcases;

import java.util.Iterator;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Examples;

public class ProductSearch extends Hook
{
	
	String productn = null;
	
	@Given("i am logged in")
	public void i_am_logged_in() 
	{
	    if(PasswordTest.login == true)
	    {
	    	utility.Report.test = utility.Report.report.createTest("productsearch");
			  
	    }
	    else
	    {
	    	
	    }
	}
	@When("^i search for product (.*) and price (.*)")
	public void i_search_for_product_and_price(String productn, int productp) 
	{
		this.productn = productn;
		  searchbox.clear();
		  searchbox.sendKeys(productn+" in range "+productp);
		  Actions a = new Actions(driver);
		  a.sendKeys(Keys.ENTER).perform();
		 
	}
	@Then("product must come")
	public void product_must_come() throws Exception 
	{
		 if(productlinks.size() == 0 )
		  {
			  utility.Report.test.log(Status.FAIL, MarkupHelper.createLabel( "No search result found ", ExtentColor.RED));
			  
			  Assert.fail("No search result found");
		  }
		  else {
			  utility.Report.test.log(Status.PASS, MarkupHelper.createLabel( "searching Shirt ", ExtentColor.GREEN));
			  utility.ScreenShot.takeScreenshot("SearchResult-"+productn);	 
				
		Iterator <WebElement> it1 =  productlinks.iterator(); // get data from List
		Iterator <WebElement> it2 = productlinks.iterator(); // get data from List
		   
		int count = 0;
		
		    while(it1.hasNext() && it2.hasNext())
		    {
		    	count++;
		    	   
		    WebElement product =	it1.next(); // getting WebElement from List
		    WebElement price = it2.next();
		    
		    utility.Report.test.log(Status.PASS, MarkupHelper.createLabel( "Product link  "+product.getText()+" price "+price.getText(), ExtentColor.GREEN));
			
		          if(count == 5) // click on 5th product
		          {
		        String url =	  product.getText();
		    //    driver.findElement(By.linkText(url)).click(); // new tab
		        
		        break;
		          }
		    }
		        }
	
	}

	@Then("close browser")
	public void close_browser() throws Exception
	{
		
		//closeBrowser();
	}
	
}
