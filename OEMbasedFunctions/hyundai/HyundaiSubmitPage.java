package hyundai;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HyundaiSubmitPage {

	public WebDriver driver;
	public int gId = 0;
	public int gId1 = 0;

	public HyundaiSubmitPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='paySelected']/span")
	public WebElement paySel;

	@FindBy(id = "DataTables_Table_0")
	public WebElement rTable;

	public void remittanceSubmit() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("DataTables_Table_0")));

			List<WebElement> list = rTable.findElements(By.tagName("tr"));
			// System.out.println("List Size:-"+list.size());
			if (list.size() == 0) {
				System.out.println("Data Not Found");
			} else {				
				for (int i = 2; i < list.size(); i++) {
					String rawId = list.get(i).getAttribute("id");
					// System.out.println("rawId:-"+rawId);
					rawId = rawId.substring(4);
					// System.out.println("rawId:-"+rawId);
					int rawIdInt = Integer.parseInt(rawId);
					// System.out.println("rawIdInt:-"+rawIdInt);
					if (rawIdInt > gId) {
						gId = rawIdInt;
					}
					// System.out.println("GreaterNo"+gId);
				}

				String actFirst = "//*[@id='applyMultiple_";
				String actLast = "']";
				String actuaRes = actFirst + gId + actLast;
				// System.out.println("actuaRes:-"+actuaRes);

				if (!driver.findElement(By.xpath(actuaRes)).isSelected()) {
					driver.findElement(By.xpath(actuaRes)).click();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void paySelected() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='paySelected']/span")));
			paySel.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(id = "payByCheckAnchor")
	public WebElement pbca;
	
	@FindBy(/*xpath = "//*[@id='printRemittance']/a[1]"*/ id="printRemittance")
	WebElement backtoremi;

	@SuppressWarnings("finally")
	public String sendRemittance() {
		String status = "";
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(pbca));
			pbca.click();
			status = "Pass";
			wait.until(ExpectedConditions.elementToBeClickable(backtoremi));			
		} catch (Exception e) {
			status = "Fail";
			e.printStackTrace();
		} finally {
			return status;
		}
		
	}
	
	@FindBy(xpath=".//*[@id='msg']/ul/li")
	public WebElement msg;

	public void remittanceDelete() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DataTables_Table_0")));

			List<WebElement> list = rTable.findElements(By.tagName("tr"));
			//System.out.println("List Size:-"+list.size());
			if (list.size() == 0) {
				//System.out.println("Data Not Found");
			} else {
				//String[] valueToWrite = null;
				//String[] valueToWriteNew = null;
				//String status = null;
				
				for (int i = 2; i < list.size(); i++) {
					String rawId = list.get(i).getAttribute("id");
					//System.out.println("rawId:-"+rawId);///
					rawId = rawId.substring(4);
					//System.out.println("rawId:-"+rawId);///
					int rawIdInt = Integer.parseInt(rawId);
					//System.out.println("rawIdInt:-"+rawIdInt);///
					if (rawIdInt > gId1) {
						gId1 = rawIdInt;
					}
					//System.out.println("GreaterNo"+gId1);
				}

				String actFirst = "//*[@id='row_";
				String actLast = "']/td[9]/a/img";
				String actuaRes = actFirst + gId1 + actLast;
				//System.out.println("actuaRes:-"+actuaRes);
				driver.findElement(By.xpath(actuaRes)).click();
				Alert alert = driver.switchTo().alert();
				alert.accept();				
				getDeletedMsg();
				
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}
	}
	
	public void getDeletedMsg(){
		try {
			boolean status = false;
			String text = "";
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(msg));
			//text = msg.getText().trim();
			for (int i = 0; i <= 3; i++) {
				text = msg.getText().trim();
				System.out.println("MESSAGE:- "+text);
				System.out.println("Number:- "+i);
				if (text.equalsIgnoreCase("Deleted remittance successfully.")) {
					status = true;
					break;
				} else if (!text.equalsIgnoreCase("Deleted remittance successfully.")) {
					status = false;
					Thread.sleep(5000L);
				} 				
			}
			
			if(status) {
				System.out.println(text);
			} else {
				Assert.assertTrue("Remittance Not Saved", false);
			}
			
		} catch (Exception e) {			
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	

}
