Feature: To Test Fuccillo Portal Functionalities

  @SaveContract_Fuccillo_QA
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
      | TestCase | Portal   | Language | Dealer   | UserName | Password | Captcha | Vin               | Make | Model | Trim | Year | Inservicedate | ContractPurchaseDate | Vehicle_Purchase | Vehicle_Purchase_Date | Vehicle_condtion | FinanceType | odometer | SelectProduct                | BundleSelection | Plan                | Term | TermMiles | Deductible | FirstServiceInterval | FinalServiceInterval | RegistrationCode | DealerCost | RetailPrice | isThisaBussiness | BussinessName | FirstName | LastName  | Address    | PostalCode | PhoneNumber1 | EmailAddress  | Co-Signer | cos-FirstName | cos-LastName | cos-Address | cos-PostalCode | cos-PhoneNumber1 | cos-EmailAddress | VehicleMSRP | FinanceAmount | APR | GrossCapCost | Vehicleprice | Lienholder         |
      |       68 | Fuccillo |          | HYUNY062 | fcqaauto | ******   |         | KMHD84LF5HU066454 |      |       |      |      | 2022-01-08    | 2022-01-08           | Yes              |                       | New              | FINANCE     |       53 | FUCCILLO PREPAID MAINTENANCE |                 | STANDARD OIL OPTION |   36 |     36000 |          0 |                      |                      |                  |     383.65 |         795 | No               |               | TESTQA036 | TESTQA036 | 123 STREET |      12345 |   1234567899 | test@test.com | No        |               |              |             |                |                  |                  |       10000 |         15000 | 0.5 |        10000 |        25000 | KIA MOTORS FINANCE |
      |       69 | Fuccillo |          | HYUNY062 | fcqaauto | ******   |         | KM8J3CA4XHU392676 |      |       |      |      | 2022-01-08    | 2022-01-08           | Yes              |                       | New              | FINANCE     |       14 | FUCCILLO PREPAID MAINTENANCE |                 | STANDARD OIL OPTION |   48 |     48000 |          0 |                      |                      |                  |     472.55 |         895 | No               |               | TESTQA037 | TESTQA037 | 123 STREET |      12345 |   1234567899 | test@test.com | No        |               |              |             |                |                  |                  |       10000 |         15000 | 0.5 |        10000 |        25000 | KIA MOTORS FINANCE |

  @SubmitContract_Fuccillo_QA
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
      | TestCase | Portal   | Language | Dealer   | UserName | Password | Captcha | Vin               | Make | Model | Trim | Year | Inservicedate | ContractPurchaseDate | Vehicle_Purchase | Vehicle_Purchase_Date | Vehicle_condtion | FinanceType | odometer | SelectProduct                | BundleSelection | Plan                | Term | TermMiles | Deductible | FirstServiceInterval | FinalServiceInterval | RegistrationCode | DealerCost | RetailPrice | isThisaBussiness | BussinessName | FirstName | LastName     | Address    | PostalCode | PhoneNumber1 | EmailAddress  | Co-Signer | cos-FirstName | cos-LastName | cos-Address | cos-PostalCode | cos-PhoneNumber1 | cos-EmailAddress | VehicleMSRP | FinanceAmount | APR | GrossCapCost | Vehicleprice | Lienholder         |
      |       68 | Fuccillo |          | HYUNY062 | fcqaauto | ******   |         | KMHD84LF5HU066464 |      |       |      |      | 2022-01-08    | 2022-01-08           | Yes              |                       | New              | FINANCE     |       53 | FUCCILLO PREPAID MAINTENANCE |                 | STANDARD OIL OPTION |   36 |     36000 |          0 |                      |                      |                  |     383.65 |         795 | No               |               | TESTQA036 | TESTRASQA036 | 123 STREET |      12345 |   1234567899 | test@test.com | No        |               |              |             |                |                  |                  |       10000 |         15000 | 0.5 |        10000 |        25000 | KIA MOTORS FINANCE |
      |       69 | Fuccillo |          | HYUNY062 | fcqaauto | ******   |         | KM8J3CA4XHU392676 |      |       |      |      | 2022-01-08    | 2022-01-08           | Yes              |                       | New              | FINANCE     |       14 | FUCCILLO PREPAID MAINTENANCE |                 | STANDARD OIL OPTION |   48 |     48000 |          0 |                      |                      |                  |     472.55 |         895 | No               |               | TESTQA037 | TESTRASQA037 | 123 STREET |      12345 |   1234567899 | test@test.com | No        |               |              |             |                |                  |                  |       10000 |         15000 | 0.5 |        10000 |        25000 | KIA MOTORS FINANCE |
