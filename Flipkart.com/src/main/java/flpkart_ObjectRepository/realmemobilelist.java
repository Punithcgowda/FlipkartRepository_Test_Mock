package flpkart_ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.Excel_Utility_FC;

public class realmemobilelist 
{
	@FindBy(xpath="//div[.='₹10,999']") private WebElement realme10999;
	@FindBy(xpath="//div[.='₹10,999']/../../../..//div[@class='_4rR01T']") private List<WebElement> textxpa;

	
	public realmemobilelist(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getRealme10999() {
		return realme10999;
	}


	public List<WebElement> getTextxpa() {
		return textxpa;
	}
	
	public void getAllTextValueOfMobiles() throws Throwable
	{
	    Excel_Utility_FC excel_util = new Excel_Utility_FC();
		// int i=0;
	 //System.out.println(i +" ");
			for(WebElement ele :textxpa)
			{
				String s = ele.getText();
				System.out.println(s);
				excel_util.insertDataIntoExcel("Sheet3",0,0,s);
				//i++;
			}
			
		}
	}
	

