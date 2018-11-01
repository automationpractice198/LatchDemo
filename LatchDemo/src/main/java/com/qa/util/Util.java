package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.qa.base.TestBase;

public class Util extends TestBase {
	
	//Method to get the configuration of test driver
		public static String configValue(String key) throws Exception {
			Properties prop = new Properties();
			InputStream FIS = new FileInputStream("/Users/arunaarali/Desktop/mahesh/git/LatchRepository/LatchDemo/src/main/java/com/qa/config/config.properties");
			prop.load(FIS);
			return prop.getProperty(key);
		}
	
	//Method to capture the screenshot
		public static void TakeScreenShot(ITestResult result) throws Exception {
			File file = ((TakesScreenshot)Browser).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(file, new File("/Users/arunaarali/Desktop/mahesh/ScreenShots/"+result.getName()+".jpg"));
		}
}
