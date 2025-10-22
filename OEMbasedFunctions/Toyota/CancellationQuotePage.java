package Toyota;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.GetScreenshot;
import utility.Log;

public class CancellationQuotePage {

	public WebDriver driver;

	public CancellationQuotePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-cancellation-quote")
	public WebElement cancellation;

	public void cancellationQuote() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cancellation-quote")));
			cancellation.click();

			Log.log.debug("Click on Cancellation Quote Tab");
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}
	}

}
