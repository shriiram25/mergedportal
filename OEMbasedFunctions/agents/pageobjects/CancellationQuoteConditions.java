package agents.pageobjects;

import java.io.IOException;

import org.junit.Assert;

import configurations.Hooks;
//import configurations.Config;

import utility.CurrentDateSelection;
import utility.ExcelReadWrite;
import utility.GetScreenshot;
import utility.Log;

public class CancellationQuoteConditions {

	CancellationQuotePage cqp = new CancellationQuotePage(Hooks.driver);
	
	public void contractSearch(String FirstName, String LastName, String VINNumber, String ContractID)
	{		
		cqp.enterFName(FirstName);
		cqp.enterLName(LastName);
		cqp.enterVin(VINNumber);	
		cqp.clickSubmit();
		cqp.clickContractID(ContractID);
		
	}
	
	public void cancellationConditions(String CancellationDate, String MethodOfCancellation, String CustomerCost, String CancellationReason)
	{
		if(!CancellationDate.equals("")){
			cqp.enterDate(CancellationDate);
		}
		if(!MethodOfCancellation.equals("")){
			cqp.clickMethodOfCancellation(MethodOfCancellation);
		}
		if(!CustomerCost.equals("")){
			cqp.enterCost(CustomerCost);
		}
		if(!CancellationReason.equals("")){
			cqp.selectCancellationReason(CancellationReason);	
		}
		
			
	}
	
	public void ClickSubmit()
	{
		cqp.clickQuoteSubmit();
	}
	
	public String[] matchFactorDRefundCRefund(String ExpectedFactor, String ExpectedDealerRefund, String ExpectedCustomerRefund, String Test_Case, String Dealer, String VINNumber, String FirstName, String LastName, String ContractID ) throws IOException
	{			
		String WebFactor=null;
		String WebDRefund=null;
		String WebCRefund=null;
		String Status=null;	
		
		try{
			
			WebFactor = cqp.ActFactor.getText().trim();
			WebDRefund = cqp.ActDealerRefund.getText().trim();
			WebCRefund = cqp.ActCustomerRefund.getText().trim();
		
			/*System.out.println("Actual Factor"+WebFactor);
			System.out.println("Actual DRefund"+WebDRefund);
			System.out.println("Actual CRefund"+WebCRefund);*/
		
			if(WebFactor.equalsIgnoreCase(ExpectedFactor) && WebDRefund.equalsIgnoreCase(ExpectedDealerRefund) && WebCRefund.equalsIgnoreCase(ExpectedCustomerRefund) )
			{
				Status = "Pass";
			}
			else
			{
				Status = "Fail";
			}
				
			/*String[] valueToWriteNew=null;
			valueToWriteNew = new String[14];
			valueToWriteNew[0]=Test_Case;
			valueToWriteNew[1]=Dealer;
			valueToWriteNew[2]=FirstName;
			valueToWriteNew[3]=LastName;
			valueToWriteNew[4]=ContractID;
			valueToWriteNew[5]=VINNumber;
			valueToWriteNew[6]=WebFactor;
			valueToWriteNew[7]=WebDRefund;
			valueToWriteNew[8]=WebCRefund;
			valueToWriteNew[9]=ExpectedFactor;
			valueToWriteNew[10]=ExpectedDealerRefund;
			valueToWriteNew[11]=ExpectedCustomerRefund;
			valueToWriteNew[12]=Status;
			valueToWriteNew[13]=CurrentDateSelection.getCurrentDate();
		
			ExcelReadWrite ERW=new ExcelReadWrite();
			ERW.writeExcelForm(System.getProperty("user.dir"), "result.xlsx", "Cancellation_Quote_Result",valueToWriteNew);*/
		
			Log.log.debug("Actual Factior is "+WebFactor);
			Log.log.debug("Actual Dealer Refund is "+WebDRefund);
			Log.log.debug("Actual Customer Refund is "+WebCRefund);
			
			if(Hooks.screenShotStatus.equalsIgnoreCase("Yes"))
			{
				GetScreenshot.captureScreenshot();
			}
		
		}
		catch(Exception e){
			GetScreenshot.captureScreenshot();
			Assert.assertTrue(e.getMessage(),false);
		}
				
		String[] data = { WebFactor, WebDRefund, WebCRefund, Status };
		
		return data;		
	}
	
	
}



