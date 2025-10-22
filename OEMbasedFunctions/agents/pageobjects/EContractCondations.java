package agents.pageobjects;

import configurations.Hooks;

public class EContractCondations {
	
	//public void eContractCon(String Category, String FirstName, String LastName, String StreetAddress, String City, String State, String ZipCode, String HomePhone, String VehicleID, String Odometer, String MSRP_NADA, String VehicleType, String ChargeToCustomer, String AmountFinanced_LeaseCap, String FinancialInstitution, String VehiclePurchasePrice, String AsigneePaymentType)
	public void eContractCon(String Category, String FirstName, String LastName, String StreetAddress, String City, String State, String ZipCode, String HomePhone, String VehicleID, String Odometer, String MSRP_NADA, String VehicleType, String ChargeToCustomer, String AmountFinanced_LeaseCap, String FinancialInstitution, String VehiclePurchasePrice, String AsigneePaymentType)
	{
		System.out.println("econtract");
		EContractPage ecp=new EContractPage(Hooks.driver);
		ecp.enterFName(FirstName);
		ecp.enterLName(LastName);
		ecp.enterAddress(StreetAddress);
		ecp.enterCity(City);
		ecp.enterState(State);
		ecp.enterZip(ZipCode);
		ecp.enterPhone(HomePhone);
		ecp.enterOdometer(Odometer);
		ecp.enterVin(VehicleID);
		ecp.clickVinSearch();
		
			//if(Category.equalsIgnoreCase("SGGP818")||Category.equalsIgnoreCase("Vero Gap Plus Form"))
			if (Category.equalsIgnoreCase("ECSGGPCOUNFMC")||Category.equalsIgnoreCase("SGVPDSA7-FMC318")
					||Category.equalsIgnoreCase("SGGP319")
					||Category.equalsIgnoreCase("ECSGGPCOUN1219")||Category.equalsIgnoreCase("ECSGGPUNFMC"))
			{
				ecp.enterOdometer(Odometer);
				ecp.enterMsrp(MSRP_NADA);
				ecp.selectVechileType(VehicleType);
				ecp.enterCustCost(ChargeToCustomer);
				ecp.enterAmountFinanced(AmountFinanced_LeaseCap);
				ecp.enterFinancialInstitution(FinancialInstitution);
				ecp.enterBankAddress(StreetAddress);
				ecp.enterBankCity(City);
				ecp.enterBankState(State);
				ecp.enterBankZip(ZipCode);			
				
			}
			
			if(Category.equalsIgnoreCase("SGVKEY")||Category.equalsIgnoreCase("SGVPKEY")
					||Category.equalsIgnoreCase("ECSGPKCAN021")
					||Category.equalsIgnoreCase("ECSGUKCAN21")
					||Category.equalsIgnoreCase("ECSGPWCAN0121")
					)
			{
				
				ecp.selectVechileType(VehicleType);
				ecp.enterCustCost(ChargeToCustomer);
				
			
			}
			
			if(Category.equalsIgnoreCase("SGVPC")
					||Category.equalsIgnoreCase("SGLS-CAN")||Category.equalsIgnoreCase("ECSGGPCV0116")
					||Category.equalsIgnoreCase("SGGPCV 1/16"))
			{
				ecp.enterOdometer(Odometer);
				ecp.enterMsrp(MSRP_NADA);
				ecp.selectVechileType(VehicleType);
				ecp.enterCustCost(ChargeToCustomer);
				ecp.enterAmountFinanced(AmountFinanced_LeaseCap);
				ecp.enterFinancialInstitution(FinancialInstitution);

			
			}
			
			if( Category.equalsIgnoreCase("SGVPDSA7-FMC318") || Category.equalsIgnoreCase("AVGPSET 1/16") || Category.equalsIgnoreCase("SGGP25-1115") || Category.equalsIgnoreCase("SGGP-PL1115") || Category.equalsIgnoreCase("SGGPFM") || Category.equalsIgnoreCase("SGGP818") || Category.equalsIgnoreCase("SGMPGP150-1115")||Category.equalsIgnoreCase("SGGP 1/14")||Category.equalsIgnoreCase("SGGPSET-TO TOYOTA GAP"))
			{
				ecp.enterOdometer(Odometer);
				ecp.enterMsrp(MSRP_NADA);				
				ecp.selectVechileType(VehicleType);
				ecp.enterCustCost(ChargeToCustomer);
				ecp.selectAssigneePaymentType(AsigneePaymentType);
				ecp.enterFinancialInstitution(FinancialInstitution);
			
			} 
			
			if(Category.equalsIgnoreCase("SGTRABVSC") 
					|| Category.equalsIgnoreCase("SGVPDWRSA") 
					|| Category.equalsIgnoreCase("SGPWABVSC-GM")
					||Category.equalsIgnoreCase("SGTP")
					||Category.equalsIgnoreCase("SGVTDRKSA-UVP FORM TDRK SA VAS")

					||Category.equalsIgnoreCase("SGPWSAVSC")
					||Category.equalsIgnoreCase("ECSGPDWKSC1220")
					
					
					)
			{
			
				ecp.enterOdometer(Odometer);
				ecp.enterVehiclePurchasePrice(VehiclePurchasePrice);
				ecp.selectVechileType(VehicleType);				
				ecp.enterCustCost(ChargeToCustomer);	
				
				
			}
			
			if (Category.equalsIgnoreCase("SGMGP150-1115") || Category.equalsIgnoreCase("ECWRMGP")||
					Category.equalsIgnoreCase("SGCDWA")||Category.equalsIgnoreCase("SGCDW")||
					Category.equalsIgnoreCase("SGCDWAK")||Category.equalsIgnoreCase("ECSGMVTPREPTN18"))
			{
				ecp.enterMsrp(MSRP_NADA);
				ecp.selectVechileType(VehicleType);
				ecp.enterCustCost(ChargeToCustomer);				
				
			}
			if (Category.equalsIgnoreCase("ECSGLS"))
			{
				ecp.enterOdometer(Odometer);
				ecp.enterMsrp(MSRP_NADA);
				ecp.enterCustCost(ChargeToCustomer);
			
			}
			
			if (Category.equalsIgnoreCase("SGPDRK-INILIAMI")
					||Category.equalsIgnoreCase("SGGPUN1219")
					||Category.equalsIgnoreCase("ECAVGPUN")
					||Category.equalsIgnoreCase("ECAVGPUNFMC")
					||Category.equalsIgnoreCase("ECSGGP319")
					||Category.equalsIgnoreCase("ECSGGPCOUN1219")
					||Category.equalsIgnoreCase("ECSGGPTXUN1219")
					||Category.equalsIgnoreCase("ECSGGPUN1219")
					||Category.equalsIgnoreCase("ECSGGP-VC419")
					||Category.equalsIgnoreCase("ECSGGP0818")
					||Category.equalsIgnoreCase("ECSGGPSETTO1207")
					||Category.equalsIgnoreCase("ECSGGPTXUN1219")
					||Category.equalsIgnoreCase("ECAVGPSET0116")
					||Category.equalsIgnoreCase("ECGAP080116")
					||Category.equalsIgnoreCase("ECSGGP150TX717")
					||Category.equalsIgnoreCase("ECSGGP251115")
					||Category.equalsIgnoreCase("ECSGGPPL1115")
					||Category.equalsIgnoreCase("ECSGGPRET0116")
					||Category.equalsIgnoreCase("ECSGGPTO1115")
					||Category.equalsIgnoreCase("ECVEGP0116")
					||Category.equalsIgnoreCase("ECSGGP-CO")
					||Category.equalsIgnoreCase("ECSGGPCOUN1219")
					||Category.equalsIgnoreCase("ECSGGPCP-CO")
					||Category.equalsIgnoreCase("ECSGMVTP")
					||Category.equalsIgnoreCase("SGPDWKSCSA 1220")
					||Category.equalsIgnoreCase("ECSGGPCP0116")
					)
			{
				ecp.enterOdometer(Odometer);
				ecp.enterMsrp(MSRP_NADA);
				ecp.selectVechileType(VehicleType);
				ecp.selectAssigneePaymentType(AsigneePaymentType);
				ecp.enterCustCost(ChargeToCustomer);
		
				
			}
			
			if(Category.equalsIgnoreCase("ECSGVKEY1-5")||Category.equalsIgnoreCase("ECSGVPKEY-GA519"))
			{
				ecp.enterCustCost(ChargeToCustomer);
				//ecp.enterTerm(Term);
			}
	}

}
