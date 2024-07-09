package testcases;

import org.junit.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import core.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UseridTest extends Hook
{
	public static boolean user = false;
	
	@Given("i open {string} and get url {string} test name {string} report name {string}")
	public void i_open_and_get_url_test_name_report_name(String browser, String url, String testname, String reportname) throws Exception
	{
	    openBrowser(browser,url,testname,reportname);
	}
	@Given("click signin")
	public void click_signin() 
	{
		utility.Report.test = utility.Report.report.createTest("useridtest");
		  
	    signin.click();
	}
	@When("I enter valid userid {string}")
	public void i_enter_valid_userid(String username) 
	{
		   try {
	    userid.sendKeys(username);
		   }
		   catch(Exception e)
		   {
		  userid2.sendKeys(username);
		   }
	}
	@When("click continue button")
	public void click_continue_button() 
	{
	    ctnbtn.click();
	}
	@Then("I error should not come")
	public void i_error_should_not_come() 
	{
		   try {
	   String err =  err1.getText();
	   utility.Report.test.log(Status.FAIL, MarkupHelper.createLabel( err1.getText(), ExtentColor.RED));
	     Assert.fail(err1.getText());
	      
		   }
		   catch(Exception ee)
		   {
			   utility.Report.test.log(Status.PASS, MarkupHelper.createLabel( "userid is valid ", ExtentColor.GREEN));
					   
		   }
	}
	@Then("password should come")
	public void password_should_come() throws Exception 
	{
	    if(password.isDisplayed())
	    {
	    	 utility.Report.test.log(Status.PASS, MarkupHelper.createLabel(" password is displayed ", ExtentColor.GREEN));
				user =true;   	
	    }
	    else
	   {
	    	 utility.Report.test.log(Status.FAIL, MarkupHelper.createLabel( "password not displayed ", ExtentColor.RED));
				
	    }
	    
	    
	}


}
