package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;



//public class ListenerImpClass implements ITestListener 
//{
//
//    public void onTestFailure(ITestResult result) 
//	{
//		String testName = result.getMethod().getMethodName();
//		System.out.println("-----I am Listening-----");
//         
//		TakesScreenshot ts = (TakesScreenshot) (Base_Class_TestNG.driver1);
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		 File dest = new File("./Screenshot/"+testName+LocalDateTime.now().toString().replace(":", "_")+".png");
//		 try 
//		 {
//			FileUtils.copyFile(src, dest);
//		 }
//		 catch (IOException e) 
//		 {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		 }	



