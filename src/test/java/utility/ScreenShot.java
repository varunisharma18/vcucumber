package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.Page;

public class ScreenShot extends Page
{  
	 
    public static void takeScreenshot(String scnname) throws Exception
    {
    	String path = System.getProperty("user.dir")+"//src//test//java//screenshot//"+scnname+".jpg";
    	
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File temp = ts.getScreenshotAs(OutputType.FILE); // take screenshot and stores in tmp location
    	
    	FileUtils.copyFile(temp, new File(path));
    } 
}
