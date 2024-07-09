package core;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Hook extends Page
{
	
	public void openBrowser(String browser,String url,String testname,String reportname) throws Exception 
	  {
		super.openBrowser(browser, url, testname, reportname);
	  }
	
   // reading external xpath
	   // login
	@FindBy(xpath = externalxpath.AmazonXpath.signin)
	public static WebElement signin;
	
	@FindBy(xpath = externalxpath.AmazonXpath.userid)
	public static WebElement userid;
	
	@FindBy(xpath = externalxpath.AmazonXpath.userid2)
	public static WebElement userid2;
	
	@FindBy(xpath = externalxpath.AmazonXpath.ctnbtn)
	public static WebElement ctnbtn;
	
	@FindBy(xpath = externalxpath.AmazonXpath.err1)
	public static WebElement err1;
	
	@FindBy(xpath = externalxpath.AmazonXpath.password)
	public static WebElement password;
	
	@FindBy(xpath = externalxpath.AmazonXpath.submit)
	public static WebElement submit;
	
	@FindBy(xpath = externalxpath.AmazonXpath.err2)
	public static WebElement err2;
	
	// search
	
	@FindBy(xpath = externalxpath.AmazonXpath.searchbox)
	public static WebElement searchbox;
	
	// multiple elements
	@FindBy(xpath = externalxpath.AmazonXpath.productlinks)
	public static List <WebElement> productlinks;
	
	@FindBy(xpath = externalxpath.AmazonXpath.pricelist)
	public static List <WebElement> pricelist;
	
	@FindBy(xpath = externalxpath.AmazonXpath.addtokartbtn)
	public static WebElement addtokartbtn;
	
	
}
