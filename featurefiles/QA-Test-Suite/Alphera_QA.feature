Feature: To Test Alphera Portal Functionalities

  @SaveContract_Alphera_QA
  Scenario Outline: Add a New Contract
    Given Go to url with data as "<TestCase>" and "<Portal>" and "<Language>"and "<Dealer>"
    And Login as "<UserName>" and "<Password>" and "<Captcha>"
    When Click on add New eContract
    And Decode the VIN "<Vin>"
    And Enter contract purchase information "<Vin>" and "<Trim>" and "<Inservicedate>" and "<ContractPurchaseDate>" and "<Vehicle_Purchase>" and "<Vehicle_Purchase_Date>" and "<Vehicle_condtion>" and "<FinanceType>" and "<odometer>" and "<Province>"
    And Select product and get rates "<SelectProduct>" and "<BundleSelection>" and "<Plan>" and "<Term>" and "<TermMiles>" and "<Deductible>" and "<RetailPrice>" and "<DealerCost>" and "<FirstServiceInterval>" and "<FinalServiceInterval>" and "<RegistrationCode>"
    And Verify Dealer Cost and Retail Price "<DealerCost>" and "<RetailPrice>"
    And Enter customer details "<isThisaBussiness>" and "<customerAgreementLanguage>" and "<BussinessName>" and "<FirstName>" and "<LastName>" and "<Address>" and "<PostalCode>" and "<PhoneNumber1>" and "<EmailAddress>" and "<Co-Signer>" and "<cos-First Name>" and "<cos-Last Name>" and "<cos-Address>" and "<cos-Postal Code>" and "<cos-Phone Number 1>" and "<cos-Email Address>" and "<SelectProduct>"
    And Enter vehicle purchase price and finance info "<SelectProduct>" and "<VehicleMSRP>" and "<FinanceAmount>" and  "<APR>" and "<GrossCapCost>" and "<Vehicleprice>"
    And Select Lienholder "<Lienholder>" and "<SelectProduct>"
    And Save the contract
    And Go to the summary page
    Then Logout out from the portal

    Examples: 
      | TestCase | Portal  | Language | Dealer   | UserName | Password | Captcha | Vin               | Make | Model | Trim               | Year | Inservicedate | ContractPurchaseDate | Vehicle_Purchase | Vehicle_Purchase_Date | Vehicle_condtion | FinanceType | odometer | SelectProduct                      | BundleSelection | Plan                      | Term | TermMiles | Deductible | FirstServiceInterval | FinalServiceInterval | RegistrationCode | DealerCost | RetailPrice | isThisaBussiness | BussinessName | FirstName | LastName     | Address    | PostalCode | PhoneNumber1 | EmailAddress  | Co-Signer | cos-FirstName | cos-LastName | cos-Address | cos-PostalCode | cos-PhoneNumber1 | cos-EmailAddress | VehicleMSRP | FinanceAmount | APR | GrossCapCost | Vehicleprice | Lienholder |
      | 66       | Alphera |          | AL124261 | alqaauto | ******   |         | WAUAFAFL0GN014016 | AUDI | A3    | 1.8T  PREMIUM PLUS | 2016 | 08-19-2017    | 09/25/2019           | Yes              | 09/21/2018            | NEW              | FINANCE     | 5000     | ALPHERA VEHICLE SERVICE PROTECTION |                 | VSC PROTECTION - PLATINUM | 48   | 100000    | 100        |                      |                      |                  | 1478       | 2000        | No               |               | TESTQA034 | TESTRASQA034 | 123 STREET | 90013      | 9999999999   | test@test.com | No        |               |              |             |                |                  |                  | 10000       | 15000         | 0.5 | 10000        | 25000        |            |
      | 67       | Alphera |          | AL124261 | alqaauto | ******   |         | WAU2GAFC1CN093532 | AUDI | A3    | 1.8T  PREMIUM PLUS | 2016 | 08-11-2017    | 09/25/2019           | Yes              | 09/21/2018            | Pre-Owned        | FINANCE     | 20000    | BMW GAP PROTECTION                 |                 | GAP PROTECTION            | 12   |           | 0          |                      |                      |                  | 225        | 280         | No               |               | TESTQA035 | TESTRASQA035 | 123 STREET | 90013      | 9999999999   | test@test.com | No        |               |              |             |                |                  |                  | 10000       | 15000         | 0.5 | 10000        | 25000        |            |

  @SubmitContract_Alphera_QA
  Scenario Outline: Save and Submit the New Contract
    Given Go to url with data as "<TestCase>" and "<Portal>" and "<Language>"and "<Dealer>"
    And Login as "<UserName>" and "<Password>" and "<Captcha>"
    When Click on add New eContract
    And Decode the VIN "<Vin>"
    And Enter contract purchase information "<Vin>" and "<Trim>" and "<Inservicedate>" and "<ContractPurchaseDate>" and "<Vehicle_Purchase>" and "<Vehicle_Purchase_Date>" and "<Vehicle_condtion>" and "<FinanceType>" and "<odometer>" and "<Province>"
    And Select product and get rates "<SelectProduct>" and "<BundleSelection>" and "<Plan>" and "<Term>" and "<TermMiles>" and "<Deductible>" and "<RetailPrice>" and "<DealerCost>" and "<FirstServiceInterval>" and "<FinalServiceInterval>" and "<RegistrationCode>"
    And Verify Dealer Cost and Retail Price "<DealerCost>" and "<RetailPrice>"
    And Enter customer details "<isThisaBussiness>" and "<customerAgreementLanguage>" and "<BussinessName>" and "<FirstName>" and "<LastName>" and "<Address>" and "<PostalCode>" and "<PhoneNumber1>" and "<EmailAddress>" and "<Co-Signer>" and "<cos-First Name>" and "<cos-Last Name>" and "<cos-Address>" and "<cos-Postal Code>" and "<cos-Phone Number 1>" and "<cos-Email Address>" and "<SelectProduct>"
    And Enter vehicle purchase price and finance info "<SelectProduct>" and "<VehicleMSRP>" and "<FinanceAmount>" and  "<APR>" and "<GrossCapCost>" and "<Vehicleprice>"
    And Select Lienholder "<Lienholder>" and "<SelectProduct>"
    And Save the contract
    And Go to the summary page
    And Click on Manage Saved eContracts
    And Select the contract with Last Name "<LastName>", VIN "<Vin>", Product "<SelectProduct>" and Portal "<Portal>"
    And Submit the contract
    Then Logout out from the portal

    Examples: 
      | TestCase | Portal  | Language | Dealer   | UserName | Password | Captcha | Vin               | Make | Model | Trim               | Year | Inservicedate | ContractPurchaseDate | Vehicle_Purchase | Vehicle_Purchase_Date | Vehicle_condtion | FinanceType | odometer | SelectProduct                      | BundleSelection | Plan                      | Term | TermMiles | Deductible | FirstServiceInterval | FinalServiceInterval | RegistrationCode | DealerCost | RetailPrice | isThisaBussiness | BussinessName | FirstName | LastName     | Address    | PostalCode | PhoneNumber1 | EmailAddress  | Co-Signer | cos-FirstName | cos-LastName | cos-Address | cos-PostalCode | cos-PhoneNumber1 | cos-EmailAddress | VehicleMSRP | FinanceAmount | APR | GrossCapCost | Vehicleprice | Lienholder |
      | 66       | Alphera |          | AL124261 | alqaauto | ******   |         | WAUAFAFL0GN014016 | AUDI | A3    | 1.8T  PREMIUM PLUS | 2016 | 08-19-2017    | 09/25/2019           | Yes              | 09/21/2018            | NEW              | FINANCE     | 5000     | ALPHERA VEHICLE SERVICE PROTECTION |                 | VSC PROTECTION - PLATINUM | 48   | 100000    | 100        |                      |                      |                  | 1478       | 2000        | No               |               | TESTQA034 | TESTRASQA034 | 123 STREET | 90013      | 9999999999   | test@test.com | No        |               |              |             |                |                  |                  | 10000       | 15000         | 0.5 | 10000        | 25000        |            |
      | 67       | Alphera |          | AL124261 | alqaauto | ******   |         | WAU2GAFC1CN093532 | AUDI | A3    | 1.8T  PREMIUM PLUS | 2016 | 08-11-2017    | 09/25/2019           | Yes              | 09/21/2018            | Pre-Owned        | FINANCE     | 20000    | BMW GAP PROTECTION                 |                 | GAP PROTECTION            | 12   |           | 0          |                      |                      |                  | 225        | 280         | No               |               | TESTQA035 | TESTRASQA035 | 123 STREET | 90013      | 9999999999   | test@test.com | No        |               |              |             |                |                  |                  | 10000       | 15000         | 0.5 | 10000        | 25000        |            |
