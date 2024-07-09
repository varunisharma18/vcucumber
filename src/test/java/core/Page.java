package core;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import utility.TestConfig;

public class Page 
{
  public static WebDriver driver = null;
  
  public String testname = null;
  public String reportname = null;
  
  
  public void openBrowser(String browser,String url,String testname,String reportname) throws Exception 
  {
	  // report init
	  utility.Report.generateReport(reportname, testname);
	  
	  this.testname = testname; // set local vat to global
	  this.reportname = reportname; // set local var to global
	  	    
	  // page init
	  if(browser.equalsIgnoreCase("chrome"))
		{
			 driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.get(url);
		utility.Report.test.log(Status.PASS, MarkupHelper.createLabel( "Browser "+browser+" url "+url+" opens " , ExtentColor.GREEN));
		  
		// to get external xpath..
		PageFactory.initElements(driver, this);
		
		// implicit wait..
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		driver.manage().window().maximize();
	  
  }

  public void closeBrowser() throws Exception
  {
	  driver.quit(); // close browser
	  utility.Report.report.flush(); // end report compulsory
	  
	  // send email.. 
	  
	    String subject = "Report "+reportname;
		
		String messageBody ="report of "+testname+" 2-7-24 TestMessage";
		String attachmentPath= System.getProperty("user.dir")+"\\src\\test\\java\\reports\\"+reportname+".html";
		
		String attachmentName=reportname;
		
			
		utility.monitoringMail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, subject, messageBody, attachmentPath, attachmentName);
		
}

}
