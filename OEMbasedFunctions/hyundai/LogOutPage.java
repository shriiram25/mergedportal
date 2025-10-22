package hyundai;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.GetScreenshot;

public class LogOutPage {
	
	public WebDriver driver;
	
	public LogOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Login/Account")
	public WebElement loginAcc;
	
	@FindBy(linkText="Logout")
	public WebElement logout;
	//Click on Log Out Menu
	public void logOut(){
		try{			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			Actions action=new Actions(driver);			
			action.moveToElement(loginAcc).perform();			
			wait.until(ExpectedConditions.elementToBeClickable(logout));
			logout.click();
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			e.printStackTrace();
		}
	}
	
	//@FindBy(xpath="[@title='Logout' and @href='/auth/logout']")
	@FindBy(linkText="Logout")
	public WebElement logoutLink;
	
	public void clickLogoutLink(){
		try{			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(logoutLink));			
			logoutLink.click();			
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			e.printStackTrace();
		}
	}
	
}
