package testcases;

import org.junit.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordTest extends Hook
{
	
	public boolean x = false;
	public static boolean login = false;
	
	@Given("userid is valid and password textbox displayed")
	public void userid_is_valid_and_password_textbox_displayed() 
	{
	    if(UseridTest.user == true)
	    {
	    	x = true;
	    	utility.Report.test = utility.Report.report.createTest("passwordtest");
	  	  
	    }
	    else
	    {
	    	  
	    	Assert.fail("error..");
	    }
	}
	@When("enter a valid password {string}")
	public void enter_a_valid_password(String string) 
	{
	    if(x == true)
	    {
	    	password.sendKeys(string);
	    	submit.click();
	    }
	}
	@Then("i should login")
	public void i_should_login() throws Exception
	{
		 try {
			  utility.Report.test.log(Status.FAIL, MarkupHelper.createLabel( err2.getText(), ExtentColor.RED));
		      Assert.fail(err2.getText());
			  
		  }
		  catch(Exception e)
		  {
		utility.Report.test.log(Status.PASS, MarkupHelper.createLabel( "password is valid ", ExtentColor.GREEN));
		utility.ScreenShot.takeScreenshot("Login");	 
		
		login = true;
		
		  }
		
	}



}
