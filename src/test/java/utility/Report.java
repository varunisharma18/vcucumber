package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report 
{
	public static ExtentSparkReporter spark; // class
	public static ExtentReports report; // class
	public static ExtentTest test;
	
	public static void generateReport(String reportname,String testname) throws Exception
	{
		String path = System.getProperty("user.dir")+"//src//test//java//reports//"+reportname+".html";
		
		  report = new ExtentReports();
		  spark = new ExtentSparkReporter( path );
			
			report.attachReporter(spark);
			spark.config().setDocumentTitle(reportname);
		        // Name of the report
		    spark.config().setReportName(reportname);
		        // Dark Theme
		    spark.config().setTheme(Theme.STANDARD);
		    
		    test = report.createTest(testname);

	}

}
