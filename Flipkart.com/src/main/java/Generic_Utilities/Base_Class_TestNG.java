package Generic_Utilities;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Base_Class_TestNG 
{
  
public FileUtility flib = new FileUtility();
  public WebdriverUtility web_util = new WebdriverUtility();
  public Excel_Utility_FC excel_util = new Excel_Utility_FC();
  public Java_Utility jlib = new Java_Utility();
  
  
  public WebDriver driver;
// public static WebDriver driver1;

  
  /*
   * Used to lunch the browser
   */
  @BeforeClass
  public void Cofig_BC() throws Throwable
  {
	  System.out.println("Controle come inside Beforeclass");
	  String BROWSER = flib.getPropertyKeyValue("browser");
	  System.out.println("Taked chrome value "+BROWSER);
	  
	  if(BROWSER.equalsIgnoreCase("chrome"))
	   {
		  
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		//driver1=  new ChromeDriver();
	   }
	   else if(BROWSER.equalsIgnoreCase("firefox"))
	   {
		   driver =new FirefoxDriver();
	   } 
	  
	  web_util.maximizeWinow(driver);
	  

	  System.out.println("Browser lounched and Maximised ");
	
  }
  
  
  /*
   * used to login to the application
   */
  
 @BeforeMethod 
 
 public void Config_BM() throws Throwable
 {
	String URL = flib.getPropertyKeyValue("url");
	System.out.println("Url value is fetched  "+URL);
	driver.get(URL);
	web_util.waitTillPageGetLoad(driver);
	System.out.println("Page Loaded");

 }
 

 /*
  * used to logout from application
  */
 @AfterMethod
 public void Cofig_AM()
 {
	System.out.println("There is no logged in to logout from flipkart");
 }
//close the browser
	@AfterClass
	public void config_AC()
	{
		driver.close();
	}
}
