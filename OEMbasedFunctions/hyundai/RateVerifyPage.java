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

import utility.CurrentDateSelection;
import utility.ExcelReadWrite;

public class RateVerifyPage {

	public WebDriver driver;
	public int gId = 0;
	public String ER = null;
	public int totalPosition;

	public RateVerifyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "submit")
	public WebElement sub;

	public void SubContractRem() throws InterruptedException {
		//Thread.sleep(15000L);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(sub));
		sub.click();		
	}

	@FindBy(xpath=".//*[@id='msg']/ul/li")
	public WebElement msg;
	
	public void getRemittanceSavedMsg(){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(msg));
			String text = msg.getText().trim();
			//System.out.println("MESSAGE is:-"+text);
			if(!text.equalsIgnoreCase("Remittance Saved!")){
				Assert.assertTrue("Remittance Not Saved", false);
			}
			
		} catch (Exception e) {			
			Assert.assertTrue(e.getMessage(), false);
		}
	}
	
	@FindBy(id = "DataTables_Table_0")
	public WebElement remTable;
	
	@FindBy(xpath=".//tr[1]/td[3]")
	public WebElement getVIN;

	public String[] getDataFromUINew(String TestCase, String ExpectedRate, String Fname, String VIN, String UName,
			String Month, String cove, String FormType) throws Exception {
		
		String rateStatus = null;
		
		getRemittanceSavedMsg();
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DataTables_Table_0")));

			String vin = getVIN.getText().trim();
			
			List<WebElement> list = remTable.findElements(By.tagName("tr"));
			List<WebElement> listth = remTable.findElements(By.tagName("th"));
			// System.out.println("List Size:-"+list.size());
			
			if(listth.size()!=0)
			
			{
				for (int j=0;j<listth.size();j++)
					if(listth.get(j).getText().equals("Total"))
					totalPosition=j+1;
			}
			
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
						if (VIN.equalsIgnoreCase(vin)) {
							gId = rawIdInt;
						}
					}

				}
				

				String actFirst = "//*[@id='row_";
				String actLast = "']/td["+totalPosition+"]";
				String actuaRes = actFirst + gId + actLast;
				// System.out.println("actuaRes:-"+actuaRes);
				String actualResult = driver.findElement(By.xpath(actuaRes)).getText();
				// System.out.println("actualResult:-"+actualResult);
				actualResult = actualResult.trim();
				ER = actualResult;

				if (ExpectedRate.equalsIgnoreCase(actualResult)) {
					rateStatus = "Pass";
				} else {
					rateStatus = "Fail";
				}
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] data = { ER, rateStatus, Integer.toString(gId) };

		return data;
	}

	@FindBy(xpath = "//*[@id='printRemittance']/table/tbody[2]/tr/td[1]")
	public WebElement printVin;

	@FindBy(xpath = "//*[@id='printRemittance']/table/tbody[2]/tr/td[2]")
	public WebElement printName;

	@FindBy(xpath = "//*[@id='printRemittance']/table/tbody[2]/tr/td[6]")
	public WebElement printProductCost;

	public void matchDataFromPrintScreen(String VIN, String firstName, String lastName, String expRate, String dealer,
			String productTerm, String cov, String FormType) {
		try {
			String pVin = printVin.getText().trim();
			String pName = printName.getText().trim();
			String printPC = printProductCost.getText().trim();
			// System.out.println("pVin"+pVin);
			// System.out.println("pName"+pName);
			// System.out.println("printPC"+printPC);
			String finalName = firstName + " " + lastName;
			// System.out.println("finalName"+finalName);
			String printStatus;
			if (VIN.equalsIgnoreCase(pVin) && finalName.equalsIgnoreCase(pName) && expRate.equalsIgnoreCase(printPC)) {
				printStatus = "Pass";
			} else {
				printStatus = "Fail";
			}
			// System.out.println("printStatus:-"+printStatus);

			String[] valueToWritePrint = null;
			valueToWritePrint = new String[12];
			valueToWritePrint[0] = dealer;
			valueToWritePrint[1] = finalName;
			valueToWritePrint[2] = VIN;
			valueToWritePrint[3] = expRate;
			valueToWritePrint[4] = pName;
			valueToWritePrint[5] = pVin;
			valueToWritePrint[6] = printPC;
			valueToWritePrint[7] = printStatus;
			valueToWritePrint[8] = productTerm;
			valueToWritePrint[9] = cov;
			valueToWritePrint[10] = CurrentDateSelection.getCurrentDate();
			valueToWritePrint[11] = FormType;
			ExcelReadWrite ERW = new ExcelReadWrite();
			ERW.writeExcelForm(System.getProperty("user.dir"), "VSCresult.xlsx", "Print_Page_Result",
					valueToWritePrint);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//*[@id='printRemittance']/a[1]")
	WebElement backtoremi;
	
	@FindBy(xpath="//*[@id='remittanceContainer']/div[1]/a[1]/span")
	public WebElement plusSign;
	
	public void backToRem() {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(backtoremi));			
			backtoremi.click();
			wait.until(ExpectedConditions.elementToBeClickable(plusSign));
		} catch (Exception e) {			
			System.out.println("This Remittance is already submitted");
		}
		
	}
}
