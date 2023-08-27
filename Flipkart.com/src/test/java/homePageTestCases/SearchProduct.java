package homePageTestCases;

import org.testng.annotations.Test;

import Generic_Utilities.Base_Class_TestNG;
import Generic_Utilities.Excel_Utility_FC;
import Generic_Utilities.FileUtility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebdriverUtility;
import flpkart_ObjectRepository.flipkart_Home_Page;
import flpkart_ObjectRepository.realmemobilelist;

public class SearchProduct extends Base_Class_TestNG
{
	//this method is just for login search realme phone 
	
	public FileUtility flib = new FileUtility();
	  public WebdriverUtility web_util = new WebdriverUtility();
	  public Excel_Utility_FC excel_util = new Excel_Utility_FC();
	  public Java_Utility jlib = new Java_Utility();
	
	@Test
	
	public void searchMobiles() throws Throwable
	{
		flipkart_Home_Page fhg = new flipkart_Home_Page(driver);
		String productname=excel_util.getoExcelData("Sheet2",0, 1);
		System.out.println("got product name from excel "+productname);
		fhg.search_For_Products(productname);
	}
	
	@Test
	
	public void storeAllMobileNames() throws Throwable
	{
		flipkart_Home_Page fhg = new flipkart_Home_Page(driver);
		String productname=excel_util.getoExcelData("Sheet2",0, 0);
		System.out.println("got product name from excel "+productname);
		fhg.search_For_Products(productname);
		realmemobilelist mobile = new realmemobilelist(driver);
		mobile.getAllTextValueOfMobiles();
		 
	}

}
