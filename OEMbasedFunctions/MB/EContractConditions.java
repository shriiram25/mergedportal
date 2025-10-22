package MB;

import utility.Log;
import configurations.Hooks;
public class EContractConditions {
	
	public String DealerState=null;
	
	public void eContractConditions( String Category, String FirstName, String LastName, String StreetAddress, String City, String State, String ZipCode, String HomePhone, String VehicleID, String VehicleType, String ChargeToCustomer)
	{
		EContractPage ecp=new EContractPage(Hooks.driver);
		ecp.enterFName(FirstName);
		ecp.enterLName(LastName);
		ecp.enterAddress(StreetAddress);
		ecp.enterCity(City);
		ecp.enterState(State);
		ecp.enterZip(ZipCode);
		ecp.enterPhone(HomePhone);
		ecp.enterVin(VehicleID);
		ecp.clickVinSearch();
		ecp.selectVechileType(VehicleType);
		ecp.enterCustCost(ChargeToCustomer);
		
		//ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
		//psp.clickSubmit();
	}
	
	public void eContractConditionsMBCA( String Category, String FirstName, String LastName, String StreetAddress, String City, String State, String ZipCode, String HomePhone, String WorkPhone, String Email, String VehicleID, String VehicleType, String CustomerCost, String CustomerHST_GST, String CustomerPST, String CustomerQST )
	{
		EContractPage ecp=new EContractPage(Hooks.driver);
		ecp.enterFName(FirstName);
		ecp.enterLName(LastName);
		ecp.enterAddress(StreetAddress);
		ecp.enterCity(City);
		ecp.enterState(State);
		ecp.enterZip(ZipCode);
		ecp.enterPhone(HomePhone);
		ecp.enterWorkPhone(WorkPhone);
		ecp.enterEmail(Email);
		ecp.enterVin(VehicleID);
		ecp.clickVinSearch();
		ecp.selectVechileType(VehicleType);
		ecp.enterCustCost(CustomerCost);
		ecp.enterCustomerHST_GST(CustomerHST_GST);
		
		if(State.equalsIgnoreCase("QC")
				||State.equalsIgnoreCase("BC")
				||State.equalsIgnoreCase("AB")
				||State.equalsIgnoreCase("MB")
				||State.equalsIgnoreCase("SK")
				||State.equalsIgnoreCase("NB")
				||State.equalsIgnoreCase("NU")
				||State.equalsIgnoreCase("ON")
				||State.equalsIgnoreCase("PE")
				||State.equalsIgnoreCase("NS")
				||State.equalsIgnoreCase("NT")
				||State.equalsIgnoreCase("NF")
				||State.equalsIgnoreCase("YT"))		
		{
			if(State.equalsIgnoreCase("QC"))
			{
				ecp.enterCustomerQST(CustomerQST);
			}
			else if(State.equalsIgnoreCase("BC")
					||State.equalsIgnoreCase("MB")
					||State.equalsIgnoreCase("SK"))
			{
				ecp.enterCustomerPST(CustomerPST);				
			}
		}
		else
		{
			DealerState = ecp.getDealerProvince();
			
			if(DealerState.equalsIgnoreCase("QC"))
			{
				ecp.enterCustomerQST(CustomerQST);
			}
			else if(DealerState.equalsIgnoreCase("BC")
					||DealerState.equalsIgnoreCase("MB")
					||DealerState.equalsIgnoreCase("SK")
					||DealerState.equalsIgnoreCase("NF"))
			{
				ecp.enterCustomerPST(CustomerPST);				
			}	
		}	
		
/*//		ecp.selectAssignee();
		ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
		psp.clickSubmit();
		*/
	}
}
