package nissaninfiniti.pageobjects;

import configurations.Hooks;
import utility.Log;

public class EContractConditions {
	
	public String DealerProvince=null;
	
	public void eContractConditions( String Category, String FirstName, String LastName, String StreetAddress, String City, String Province, String PostalCode, String HomePhone, String BusPhone, String Email, String CosignerFirstName, String CosignerLastName, String CosignerStreetAddress, String CosignerCity, String CosignerProvince, String CosignerPostalCode, String CosignerHomePhone, String CosignerBusPhone, String VehicleID, String Odometer, String MSRP_CBB, String VehicleType, String DecalNumber, String CustomerPurchasePrice, String CustomerHST_GST, String CustomerPST, String CustomerQST, String AmountFinanced_LeaseCap, String ChooseAssignee)
			//, String ExpDealerCost, String ExpDealerHST_GST, String ExpDealerPST, String ExpDealerQST, String TestCase, String Portal, String Dealer, String Product, String Coverage, String Term)
	{
		
		
		EContractPage ecp = new EContractPage(Hooks.driver);
		ecp.enterFName(FirstName);
		ecp.enterLName(LastName);
		ecp.enterAddress(StreetAddress);
		ecp.enterCity(City);
		ecp.enterProvince(Province);
		ecp.enterPostalCode(PostalCode);
		ecp.enterHomePhone(HomePhone);
		ecp.enterBusPhone(BusPhone);
		ecp.enterEmail(Email);
		
		if(Category.equalsIgnoreCase("NILS-CAN")||Category.equalsIgnoreCase("NILS-CAN-FR")||Category.equalsIgnoreCase("NIGP-CAN")||Category.equalsIgnoreCase("NIGP-CAN-FR")||Category.equalsIgnoreCase("NITP-CAN-FR")||Category.equalsIgnoreCase("INLS-CAN")||Category.equalsIgnoreCase("INGP-CAN")||Category.equalsIgnoreCase("INGP-CAN-FR")||Category.equalsIgnoreCase("INTP-CAN-FR")||Category.equalsIgnoreCase("NITP-CAN")||Category.equalsIgnoreCase("INTP-CAN"))
		{
			ecp.enterCosignerFName(CosignerFirstName);
			ecp.enterCosignerLName(CosignerLastName);
			ecp.enterCosignerAddress(CosignerStreetAddress);
			ecp.enterCosignerCity(CosignerCity);
			ecp.enterCosignerProvince(CosignerProvince);
			ecp.enterCosignerPostalCode(CosignerPostalCode);
			ecp.enterCosignerHomePhone(CosignerHomePhone);
			ecp.enterCosignerBusPhone(CosignerBusPhone);
		}
		
		ecp.enterVin(VehicleID);
		ecp.clickVinSearch();
		ecp.enterOdometer(Odometer);
		ecp.enterMSRP_CBB(MSRP_CBB);
		ecp.selectVechileType(VehicleType);
		
		if(Category.equalsIgnoreCase("NITP-CAN")||Category.equalsIgnoreCase("INTP-CAN")||Category.equalsIgnoreCase("NITP-CAN-FR")||Category.equalsIgnoreCase("INTP-CAN-FR")||Category.equalsIgnoreCase("ECNITPCAN0516")||Category.equalsIgnoreCase("ECINTPCAN0516")||Category.equalsIgnoreCase("ECNITPBC0516")||Category.equalsIgnoreCase("ECINTPBC0516")||Category.equalsIgnoreCase("ECNITPCANFR516")||Category.equalsIgnoreCase("ECINTPCANFR516")||Category.equalsIgnoreCase("ECQGTPCAN-NI")||Category.equalsIgnoreCase("ECQGTPCANFR-NI")||Category.equalsIgnoreCase("ECQGTPCAN-IN")||Category.equalsIgnoreCase("ECQGTPCANFR-IN")||Category.equalsIgnoreCase("ECQGTPBC-IN")||Category.equalsIgnoreCase("ECQGTPBC-NI"))
		{
			ecp.enterDecalNumber(DecalNumber);
		}
		
		ecp.enterCustomerPurchasePrice(CustomerPurchasePrice);
		ecp.enterCustomerHST_GST(CustomerHST_GST);
		
		if(Province.equalsIgnoreCase("QC")||Province.equalsIgnoreCase("BC")||Province.equalsIgnoreCase("MB")||Province.equalsIgnoreCase("SK")||Province.equalsIgnoreCase("NB")||Province.equalsIgnoreCase("NU")||Province.equalsIgnoreCase("ON")||Province.equalsIgnoreCase("PE")||Province.equalsIgnoreCase("NS")||Province.equalsIgnoreCase("NT"))		
		{
			if(Province.equalsIgnoreCase("QC"))
			{
				ecp.enterCustomerQST(CustomerQST);
			}
			else if(Province.equalsIgnoreCase("BC")||Province.equalsIgnoreCase("MB")||Province.equalsIgnoreCase("SK"))
			{
				ecp.enterCustomerPST(CustomerPST);				
			}
		}
		else
		{
			DealerProvince = ecp.getDealerProvince();
			
			if(DealerProvince.equalsIgnoreCase("QC"))
			{
				ecp.enterCustomerQST(CustomerQST);
			}
			else if(DealerProvince.equalsIgnoreCase("BC")||DealerProvince.equalsIgnoreCase("MB")||DealerProvince.equalsIgnoreCase("SK"))
			{
				ecp.enterCustomerPST(CustomerPST);				
			}	
		}
		
		ecp.enterAmountFinanced_LeaseCap(AmountFinanced_LeaseCap);
		
		//if(Category.equalsIgnoreCase("NITP-CAN")||Category.equalsIgnoreCase("INTP-CAN")||Category.equalsIgnoreCase("NITP-CAN-FR")||Category.equalsIgnoreCase("INTP-CAN-FR"))
		if(Category.equalsIgnoreCase("NILS-CAN")||Category.equalsIgnoreCase("NILS-CAN-FR")||Category.equalsIgnoreCase("NIGP-CAN")||Category.equalsIgnoreCase("NIGP-CAN-FR")||Category.equalsIgnoreCase("INLS-CAN")||Category.equalsIgnoreCase("INGP-CAN")||Category.equalsIgnoreCase("INGP-CAN-FR"))
		{
			//Nothing
		}
		else 
		{
			ecp.selectAssignee(ChooseAssignee);
		}
		
		/*String ExpectedDealerCost="370.00";
		String ExpectedDealerHST_GST="48.10";
		String ExpectedDealerQST="0.00";
		String ExpectedDealerPST="0.00";*/		
		
		/*DealerTaxPage dtp = new DealerTaxPage(Hooks.driver);
		//dtp.verifyDealerTax(ExpDealerCost, ExpDealerHST_GST, ExpDealerQST, ExpDealerPST, Province);
		dtp.verifyDealerTax(ExpDealerCost, ExpDealerHST_GST, ExpDealerQST, ExpDealerPST, Province, TestCase, Portal, Dealer, VehicleID, Product, Coverage, Term, FirstName, LastName);
		ProductSelectionPage psp = new ProductSelectionPage(Hooks.driver);
		psp.clickSubmit();*/
		
	}
	
	public void eContractConditionsQVGS(String Category, String VehicleID, String MSRP_CBB, String Odometer, String Coverage, String Deductible, String Term, String Kilometers, String FirstName, String LastName, String StreetAddress, String City, String Province, String PostalCode, String HomePhone, String BusPhone, String Email, String CustomerPurchasePrice, String CustomerHST_GST, String CustomerQST, String CustomerPST) throws Exception
	{
		ProductSelectionPage psp = new ProductSelectionPage(Hooks.driver);
		EContractPage ecp = new EContractPage(Hooks.driver);
		QVGSFormConditions qfc = new QVGSFormConditions(Hooks.driver);
		
		ecp.enterVin(VehicleID);
		ecp.clickVinDecoder();
		ecp.enterMSRP_CBB(MSRP_CBB);
		ecp.enterOdometer(Odometer);
		ecp.enterInServiceDate();
		ecp.clickContinueBtn();
		
		psp.selectCoverage(Coverage);
		
		ecp.selectDeductible(Deductible);
		
		qfc.conditionsQGVS(Term, Kilometers);
		
		ecp.clickContinueBtn2();
		
		ecp.enterFName(FirstName);
		ecp.enterLName(LastName);
		ecp.enterAddress(StreetAddress);
		ecp.enterCity(City);
		ecp.enterProvince(Province);
		ecp.enterPostalCode(PostalCode);
		ecp.enterHomePhone(HomePhone);
		ecp.enterBusPhone(BusPhone);
		ecp.enterEmail(Email);
		
		ecp.clickContinueBtn3();
		
		ecp.enterCustomerPurchasePrice(CustomerPurchasePrice);
		ecp.enterCustomerHST_GST(CustomerHST_GST);
		
		/*if(Province.equalsIgnoreCase("QC"))
		{
			ecp.enterCustomerQST(CustomerQST);
		}
		if(Province.equalsIgnoreCase("BC")||Province.equalsIgnoreCase("MB"))
		{
			ecp.enterCustomerPST(CustomerPST);
		}*/
		
		if(Province.equalsIgnoreCase("QC")||Province.equalsIgnoreCase("BC")||Province.equalsIgnoreCase("MB")||Province.equalsIgnoreCase("SK")||Province.equalsIgnoreCase("NB")||Province.equalsIgnoreCase("NU")||Province.equalsIgnoreCase("ON")||Province.equalsIgnoreCase("PE")||Province.equalsIgnoreCase("NS")||Province.equalsIgnoreCase("NT"))		
		{
			if(Province.equalsIgnoreCase("QC"))
			{
				ecp.enterCustomerQST(CustomerQST);
			}
			else if(Province.equalsIgnoreCase("BC")||Province.equalsIgnoreCase("MB")||Province.equalsIgnoreCase("SK"))
			{
				ecp.enterCustomerPST(CustomerPST);				
			}
		}
		else
		{
			DealerProvince = ecp.getDealerProvince();
			
			if(DealerProvince.equalsIgnoreCase("QC"))
			{
				ecp.enterCustomerQST(CustomerQST);
			}
			else if(DealerProvince.equalsIgnoreCase("BC")||DealerProvince.equalsIgnoreCase("MB")||DealerProvince.equalsIgnoreCase("SK"))
			{
				ecp.enterCustomerPST(CustomerPST);				
			}	
		}
		
		ecp.clickCashDeal();
		//ecp.clickContinueBtn4();		
		
	}
	
}
