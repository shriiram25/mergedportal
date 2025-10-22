package hyundai;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.GetScreenshot;

public class VerifyProductLookUpRate {

	public WebDriver driver;
	
	public VerifyProductLookUpRate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="rateTables")
	public WebElement rateTables; 
	
	public void verifyRate(String coverage, String term, String deductible, String rate){
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rateTables")));
			
			List<WebElement> tagList=rateTables.findElements(By.tagName("tbody"));
			if(tagList.size()>0)
			{
				System.out.println("tagListSIZE:- "+tagList.size());
				List<WebElement> trList=tagList.get(0).findElements(By.tagName("tr"));
				if(trList.size()>0)
				{
					System.out.println("trListSize:- "+trList.size());
					for(int i=0;i<trList.size();i++)
					{
						List<WebElement> tdList=trList.get(i).findElements(By.tagName("td"));
						System.out.println("tdListSize:- "+tdList.size());
						String Coverage=tdList.get(2).getText().trim();
						String Term=tdList.get(3).getText();
						String Deductible=tdList.get(4).getText().trim();						
						String Rate=tdList.get(6).getText().trim();
					
						
						System.out.println("Coverage:- "+Coverage);
						System.out.println("Deductible:- "+Deductible);
						System.out.println("Term:- "+Term);
						System.out.println("Rate:- "+Rate);
						
					}
				}
			}
		
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	
}
