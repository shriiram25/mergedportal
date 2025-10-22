package Toyota;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.GetScreenshot;
import utility.Log;

public class LogOutPage {

	public WebDriver driver;

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * @FindBy(linkText="Login/Account") public WebElement logAcc;
	 */
	@FindBy(xpath = "//*[@id='hiddenLogout']/a")
	public WebElement logO;

	public void logOut() throws InterruptedException {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(logO));
			logO.click();

			Log.log.debug("Click on LogOut Link");
		} catch (Exception e) {
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(), false);
		}

	}

}
