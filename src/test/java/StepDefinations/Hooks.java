package StepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseTest.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {
	
	
	@After
	public void getScreenshot(Scenario s) throws IOException
	
	{
		if(s.isFailed())
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File target=new File(System.getProperty("user.dir")+"\\Screenshot\\screenshot.png");
			FileUtils.copyFile(src,target);

			
			
			
			
		}
	}

}
