package flpkart_ObjectRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebdriverUtility;

public class flipkart_Home_Page 
{
	@FindBy(xpath="//button[.='✕']") private WebElement closepopUp;
	@FindBy(xpath="//input[@type='text' and @placeholder='Search for products, brands and more']") 
	                private WebElement searchBar ;
	@FindBy(xpath="//a[.='Login']") private WebElement loginButton;
	@FindBy(xpath="//div[.='Sign Up']") private WebElement sighnUpButton;
	@FindBy(xpath="//div[.='My Profile']") private WebElement myProfile;
	
	public flipkart_Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getClosepopUp() {
		return closepopUp;
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getSighnUpButton() {
		return sighnUpButton;
	}

	public WebElement getMyProfile() {
		return myProfile;
	}
	
	public void search_For_Products(String product) throws AWTException, InterruptedException
	{
		closepopUp.click();
		
		searchBar.sendKeys(product);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
//	    WebdriverUtility web_util = new WebdriverUtility();
//	    web_util.handlekeyBoardfunctionality();
		
	}

}
