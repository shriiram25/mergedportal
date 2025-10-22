package nissaninfiniti.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Assert;
import configurations.Hooks;
import utility.GetScreenshot;
import utility.Log;

public class QVGSFormConditions {
	
	public WebDriver driver;
	
	public QVGSFormConditions(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cList")
	public WebElement QVGSTable;
	
	public void conditionsQGVS(String Term, String Kilometers)
	{
		String rbutnId=null;
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cList")));
			wait.until(ExpectedConditions.visibilityOf(QVGSTable));
					
			List<WebElement> tagList=QVGSTable.findElements(By.tagName("tbody"));
			if(tagList.size()>0)
			{
				//System.out.println("tagListSIZE:- "+tagList.size());
				List<WebElement> trList=tagList.get(0).findElements(By.tagName("tr"));
				if(trList.size()>0)
				{
					//System.out.println("trListSize:- "+trList.size());
					for(int i=0;i<trList.size();i++)
					{
						List<WebElement> tdList=trList.get(i).findElements(By.tagName("td"));
						//System.out.println("tdListSize:- "+tdList.size());
						String webTerm=tdList.get(0).getText().trim();
						String webKM=tdList.get(1).getText().trim();
						
						if( webTerm.equalsIgnoreCase(Term.trim()) && webKM.equalsIgnoreCase(Kilometers.trim()) )
						{
							String rowId=trList.get(i).getAttribute("id");
							//System.out.println("rowId:- "+rowId);
							rowId=rowId.substring(8,10);
							//System.out.println("rowId:- "+rowId);
							if(rowId.endsWith("-"))
							{
								rbutnId="termselect-"+rowId.substring(0,1);
							}
							else
							{
								rbutnId="termselect-"+rowId;
							}
							//System.out.println("rbutnId:- "+rbutnId);							
							//System.out.println("Before Element");
							WebElement element=driver.findElement(By.id(rbutnId));
							//System.out.println("After Element");
							wait.until(ExpectedConditions.elementToBeClickable(By.id(rbutnId)));
							//Thread.sleep(3000L);
							//System.out.println("Before Click");
							element.click();
							//System.out.println("After Click");
							Log.log.debug("Click on Selection Radio Button");
						}
					}
				}
			}
		}catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
	}
}
