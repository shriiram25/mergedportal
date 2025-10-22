package hyundai;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import utility.GetScreenshot;

public class HyundaiEContractingPage {
	
	public WebDriver driver;
	public HyundaiEContractingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="E-Contracting")
	public WebElement econ;
	//Mouse hover in E-Contracting menu
	public void econMenu()
	{
		try{
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("E-Contracting")));
			Actions action=new Actions(driver);
			action.moveToElement(econ).perform();
		}catch(Exception e){			
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
	
	@FindBy(linkText="Product Rates")
	public WebElement productRateMenu;
	
	@FindBy(xpath="//*[@id='remittanceContainer']/div[1]/a[1]/span")
	public WebElement plusSign;
	//Click on Product Rate Menu
	public void proRateMenu()
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver,60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Product Rates")));
			productRateMenu.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='remittanceContainer']/div[1]/a[1]/span")));
			plusSign.click();
		} catch(Exception e){			
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}

}
