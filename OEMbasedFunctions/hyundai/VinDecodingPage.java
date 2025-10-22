package hyundai;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.CurrentDateSelection;
import utility.ExcelReadWrite;

public class VinDecodingPage {
	
	public WebDriver driver;
	
	public VinDecodingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="formNumber")
	public WebElement pForm;
	
	public void productForm(String TestCase, String forms, String DealerID, String VinNumber, String programType, String currentOdometer, String FormType)
	{
		try{
			Thread.sleep(10000L);
			String sizeStatus=null;
			int passCount=0;
			String passStatus=null;
			String finalStatus=null;
			List<String> expList = Arrays.asList(forms.split("@"));
			Select sel=new Select(pForm);
			List<WebElement> list=sel.getOptions();
			
			if(expList.size()==list.size()-1)
			{
				sizeStatus="Pass";
			}else{
				sizeStatus="Fail";
			}
			
			for(int i=1;i<list.size();i++)
			{
				//System.out.println(list.get(i).getText());
				for(int j=0;j<expList.size();j++)
				{
					//System.out.println("String:-"+expList.get(j));
					if(list.get(i).getText().trim().equalsIgnoreCase(expList.get(j).trim()))
					{
						passCount=passCount+1;
					}					
				}
			}
			if(passCount==expList.size())
			{
				passStatus="Pass";
			}else{
				passStatus="Fail";
			}
			
			if(sizeStatus.equalsIgnoreCase("Pass") && passStatus.equalsIgnoreCase("Pass"))
			{
				finalStatus="Pass";
			}else{
				finalStatus="Fail";
			}
			
			//System.out.println("sizeStatus:-"+sizeStatus);
			//System.out.println("passStatus:-"+passStatus);
			//System.out.println("finalStatus:-"+finalStatus);
			
			String toDayDate=CurrentDateSelection.getCurrentDate();
			String[] valueToWriteNew=null;
	        valueToWriteNew = new String[8];
	        valueToWriteNew[0]=TestCase;
	 		valueToWriteNew[1]=DealerID;
	 		valueToWriteNew[2]=FormType;
	 		valueToWriteNew[3]=VinNumber;
	 		valueToWriteNew[4]=programType;
	 		valueToWriteNew[5]=currentOdometer;
	 		valueToWriteNew[6]=finalStatus;
	 		valueToWriteNew[7]=toDayDate;
	 		
	 		ExcelReadWrite ERW=new ExcelReadWrite();
	 		ERW.writeExcelForm(System.getProperty("user.dir"), "VSCresult.xlsx", "VIN_Decoding_Result",valueToWriteNew);
						
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
