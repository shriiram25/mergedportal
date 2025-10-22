package bmw.pageobjects;

import configurations.Hooks;

public class EContractConditions {

	
	public void eContractConditions( String Category, String FirstName, String LastName, String StreetAddress, String City, String State, String ZipCode, String HomePhone, String VehicleID, String Odometer, String VehiclePurchasePrice, String VehicleType, String ChargeToCustomer, String AmountFinanced_LeaseCap, String FinancialInstitution)
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
		ecp.enterOdometer(Odometer);
		ecp.enterVehiclePurchasePrice(VehiclePurchasePrice);
		ecp.selectVechileType(VehicleType);
		ecp.enterCustCost(ChargeToCustomer);
		
		if(Category.equalsIgnoreCase("BMGP 4/19") ||Category.equalsIgnoreCase("MIGPPL") ||Category.equalsIgnoreCase("MIGP 4/19") || Category.equalsIgnoreCase("BMGPPL 4/19"))
		{
			ecp.enterAmountFinanced(AmountFinanced_LeaseCap);
			ecp.enterFinancialInstitution(FinancialInstitution);
			ecp.enterBankAddress(StreetAddress);
			ecp.enterBankCity(City);
			ecp.enterBankState(State);
			ecp.enterBankZip(ZipCode);
			
			ecp.selectVechilefinanceType("Finance");
		}
		
		ProductSelectionPage psp=new ProductSelectionPage(Hooks.driver);
		psp.clickSubmit();
	}
}
