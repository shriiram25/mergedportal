package vroom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ErrorMessage;
import utility.ExcelReadWrite;
import utility.GetScreenshot;

public class LienholderInfoPage_Vroom {
	public WebDriver driver;

	public LienholderInfoPage_Vroom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "NoLienholderCheckBox") 
	public WebElement NoLienholderCheckBox;

	public void lienHolder(String lien) 
	{
	  try{
		  WebDriverWait wait = new WebDriverWait(driver, 20); 
		  if (lien.equalsIgnoreCase("null") || lien.equalsIgnoreCase("")) 
		   {
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("NoLienholderCheckBox")));
			 driver.findElement(By.id("NoLienholderCheckBox")).click(); 
		   } 
		  else
		   {
			 lienBtn(); // Function for master lien holder button
		     lienFilter(lien); // funtion for selecting required lien holder
		   }
		 }
	  catch (Exception e)
	      {
			GetScreenshot.captureScreenshot();// Get screen shot.
			Assert.assertTrue(e.getMessage(), false);
		  }
	}

	@FindBy(id = "lien-btn") // To locate the button with id 'lien-btn' in DOM
	public WebElement lienbtn; // Declaring a WebElement named lienbtn

	public void lienBtn() // Function for selecting the master lienholder button
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lien-btn"))); 
			lienbtn.click(); // clicking the master lienholder button
		    }
		catch (Exception e) {
			GetScreenshot.captureScreenshot(); // Get screen shot.
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "saveandaddproduct") // To locate the button with id 'saveandaddproduct' in DOM
	public WebElement saveandadd; // Declaring a WebElement named saveandadd

	public void saveAndAddProduct() // Function for selecting the saveandaddproduct button
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); // Setting waiting time of web driver
			wait.until(ExpectedConditions.elementToBeClickable(saveandadd));
			saveandadd.click(); // clicking the master save and add product button
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("go-to-summary")));
			
		} catch (Exception e) {
			GetScreenshot.captureScreenshot(); // Get screen shot.
			ErrorMessage.captureErrorMessage("errorMsgLien"); 
			Assert.assertTrue(e.getMessage(), false);
		}
	}

	@FindBy(id = "lien-filter") // To locate the button with id 'lien-filter' in
								// DOM
	public WebElement lienFilter; // Declaring a WebElement named lienFilter

	public void lienFilter(String lien) // Function for sending data to lien
										// text box
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lien-filter"))); 
			lienFilter.sendKeys(lien); // sending the data to the text field
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[text() = '" + lien + "']/following-sibling::td[2]/button"))); 
			driver.findElement(By.xpath("//tr/td[text() = '" + lien + "']/following-sibling::td[2]/button")).click(); 
		} catch (Exception e) {
			GetScreenshot.captureScreenshot(); // Get screen shot.
			Assert.assertTrue(e.getMessage(), false);
		}
	}

}
