Feature: To Test AutoNation Functionality

  @SaveContractAN_BMW
  Scenario Outline: Save Contract
    Given Go to AUrl as "<Test_Case>" and "<UserName>" and "<Password>" and "<Dealer>" and "<DealNumber_OR_Last7Vin>" and "<Full_VIN>" and "<Lienholder>" and "<Product>" and "<Coverage>" and "<Term>" and "<Finance_Amount>" and "<VehicleSalesPrice>" and "<ReferenceNumber>" and "<TermMileage>" and "<Deductible>" and "<CustomerRetail>" and "<FirstName>" and "<LastName>" and "<Address>" and "<City>" and "<State>" and "<Zip>" and "<VehicleCondition>" and "<PaymentType>" and "<Exp_Product_Cost>" and "<Category>" and "<Odometer>" and "<MSRP>" and "<Email>" and "<HomePhone>" and "<WorkPhone>"
    And Click on Log in Link
    And Update cmsid of the dealer
    And Login with UserName and Password
    And Click on Rate and Remit Link
    When Fill Remittance Form
    And Click on Rate and Remit Link
    And Verify Product Cost From Web
 #   And Verify Data From Data Base
  #  And Delete Contract From Web
    Then Log Out From Portal

    Examples: 
      | Test_Case | UserName  | Password | Dealer   | DealNumber_OR_Last7Vin | Full_VIN          | Lienholder | Product                                                      | Coverage                        | Term | Finance_Amount | VehicleSalesPrice | ReferenceNumber | TermMileage | Deductible | CustomerRetail | FirstName | LastName | Address | City  | State | Zip   | VehicleCondition | PaymentType | Exp_Product_Cost | Category          | Odometer | MSRP  | Email         | HomePhone  | WorkPhone  |
      | TC1       | anqaauto3 | qa1234   | N0304640 |                        | WBA5R7C06LFJ33660 |            | BMVKEY-CA-AN - BMW Key for AutoNation remittance purposes    | BMVKEY - ALL                    |   60 |           1400 |                   |                 |             |            |           1800 | TEST1     | TEST1    | TEST    | PLANO | TX    | 75063 | New              | Cash        | $199.00          | ECBMVKEY-CA-AN    |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC2       | anqaauto3 | qa1234   | N0304640 |                        | WBA5R7C06LFJ33460 |            | BMPWSADDAN1114 - BMW TW Cosmetic Contract for AutoNation     | PM-B1 - COSMETIC                |   36 |           1600 |                   |                 |             |            |           2000 | TEST2     | TEST2    | TEST    | PLANO | TX    | 75073 | New              | Cash        | $949.00          | ECBMPWSADDAN1114  |     1000 | 10000 | TEST@TEST.COM | 9898767651 | 6565434389 |
      | TC3       | anqaauto3 | qa1234   | N0391523 |                        | WBA5R7C06LFJ33760 |            | BMTWSADDAN1114 - BMW TW SA form for AutoNation e-con         | TW-B1 - STANDARD                |   12 |           1100 |                   |                 |             |            |           2100 | TEST3     | TEST3    | TEST    | PLANO | TX    | 75093 | New              | Cash        | $440.00          | ECBMTWSADDAN1114  |     1000 | 10000 | TEST@TEST.COM | 9898767654 | 6565434376 |
      | TC4       | anqaauto3 | qa1234   | N1004632 |                        | WBA5R7C06LFJ33160 |            | BMVKEY-CA-AN - BMW Key for AutoNation remittance purposes    | BMVKEY - ALL                    |   36 |            500 |                   |                 |             |            |            700 | TEST4     | TEST4    | TEST    | PLANO | TX    | 75093 | New              | Cash        | $169.00          | ECBMVKEY-CA-AN    |     1000 | 10000 | TEST@TEST.COM | 9898767654 | 6565434376 |
      | TC5       | anqaauto3 | qa1234   | N0291526 |                        | WBY1Z6C30H7A39666 |            | BMVKEYAN - AutoNation BMW Key Replacement for E-Con          | BMVKEY - ALL                    |   24 |           5000 |                   |                 |             |            |           6000 | TEST5     | TEST5    | TEST    | PLANO | TX    | 75093 | New              | Cash        | $129.00          | ECBMVKEYAN        |     1000 | 10000 | TEST@TEST.COM | 9898767654 | 6565434376 |
      | TC6       | anqaauto3 | qa1234   | N0291526 |                        | WBY1Z6C30H7A39666 |            | BMVKEYAN - AutoNation BMW Key Replacement for E-Con          | BMVKEY - ALL                    |   24 |           5000 |                   |                 |             |            |           6000 | TEST6     | TEST6    | TEST    | PLANO | TX    | 75093 | New              | Cash        | $129.00          | ECBMVKEYAN        |     1000 | 10000 | TEST@TEST.COM | 9898767654 | 6565434376 |
      | TC7       | anqaauto3 | qa1234   | N0346529 |                        | 5UXCR6C00L9B32861 |            | BMPWSADDANWA118 - BMW TW Cosmetic Contract for AutoNation    | PM-B2 - BMW COSMETIC TIRE/WHEEL |   24 |           1300 |                   |                 |             |            |           1500 | TEST7     | TEST7    | TEST7   | PLANO | TX    | 75093 | New              | Cash        | $999.00          | ECBMPWSADDANWA118 |     1000 | 10000 | TEST@TEST.COM | 9898767654 | 6565434376 |
      | TC8       | anqaauto3 | qa1234   | N0891508 |                        | WMWXU9C00M2N03831 |            | MIVKEYAN - AutoNation MINI Key Replacement for E-con         | BMVKEY - ALL                    |   12 |           1500 |                   |                 |             |            |            300 | TEST6     | TEST6    | TEST6   | PLANO | TX    | 75063 | New              | Cash        | $129.00          | MIVKEYAN          |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC9       | anqaauto3 | qa1234   | N0891508 |                        | SAJDD5GX2MCK70178 |            | MIVKEYAN - AutoNation MINI Key Replacement for E-con         | BMVKEY - ALL                    |   24 |           1500 |                   |                 |             |            |            300 | TEST7     | TEST7    | TEST7   | PLANO | TX    | 75063 | New              | Cash        | $149.00          | MIVKEYAN          |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC10      | anqaauto3 | qa1234   | N0891508 |                        | KL79MTSL8MB004583 |            | MIVKEYAN - AutoNation MINI Key Replacement for E-con         | BMVKEY - ALL                    |   36 |           1500 |                   |                 |             |            |            500 | TEST8     | TEST8    | TEST8   | PLANO | TX    | 75063 | New              | Cash        | $169.00          | MIVKEYAN          |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC11      | anqaauto3 | qa1234   | N0891508 |                        | KL79MPSL9MB010075 |            | MIVKEYAN - AutoNation MINI Key Replacement for E-con         | BMVKEY - ALL                    |   48 |           1500 |                   |                 |             |            |            700 | TEST9     | TEST9    | TEST9   | PLANO | TX    | 75063 | New              | Cash        | $189.00          | MIVKEYAN          |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC12      | anqaauto3 | qa1234   | N0891508 |                        | KL79MTSL5MB003987 |            | MIVKEYAN - AutoNation MINI Key Replacement for E-con         | BMVKEY - ALL                    |   60 |           1500 |                   |                 |             |            |            900 | TEST10    | TEST10   | TEST10  | PLANO | TX    | 75063 | New              | Cash        | $199.00          | MIVKEYAN          |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC13      | anqaauto3 | qa1234   | N0691568 |                        | WMZYW7C00L3L62743 |            | MIPWSADDAN1114 - MINI Tire and Wheel Cosmetic for AutoNation | PM-MI - COSMETIC                |   12 |           3000 |                   |                 |             |            |            700 | TEST12    | TEST12   | TEST12  | PLANO | TX    | 75063 | New              | Cash        | $564.00          | MIPWSADDAN1114    |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC14      | anqaauto3 | qa1234   | N0691568 |                        | WMWXU3C51H2D32749 |            | MITWSADDAN1114 - MINI Tire and Wheel for AutoNation          | TW-MI - STANDARD                |   24 |           3000 |                   |                 |             |            |            700 | TEST13    | TEST13   | TEST13  | PLANO | TX    | 75063 | New              | Cash        | $605.00          | MITWSADDAN1114    |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |

  @RemitContract_AN_BMW
  Scenario Outline: Remit Contract
    Given Go to AUrl as "<Test_Case>" and "<UserName>" and "<Password>" and "<Dealer>" and "<DealNumber_OR_Last7Vin>" and "<Full_VIN>" and "<Lienholder>" and "<Product>" and "<Coverage>" and "<Term>" and "<Finance_Amount>" and "<VehicleSalesPrice>" and "<ReferenceNumber>" and "<TermMileage>" and "<Deductible>" and "<CustomerRetail>" and "<FirstName>" and "<LastName>" and "<Address>" and "<City>" and "<State>" and "<Zip>" and "<VehicleCondition>" and "<PaymentType>" and "<Exp_Product_Cost>" and "<Category>" and "<Odometer>" and "<MSRP>" and "<Email>" and "<HomePhone>" and "<WorkPhone>"
    And Click on Log in Link
    And Update cmsid of the dealer
    And Login with UserName and Password
    And Click on Rate and Remit Link
    When Fill Remittance Form
    And Click on Rate and Remit Link
    And Verify Product Cost From Web
   # And Verify Data From Data Base
    And Remit Contract From Web
   # And Verify Data From Web_Con_M1 Table
    Then Log Out From Portal

    Examples: 
      | Test_Case | UserName  | Password | Dealer   | DealNumber_OR_Last7Vin | Full_VIN          | Lienholder | Product                                                      | Coverage                        | Term | Finance_Amount | VehicleSalesPrice | ReferenceNumber | TermMileage | Deductible | CustomerRetail | FirstName | LastName | Address | City  | State | Zip   | VehicleCondition | PaymentType | Exp_Product_Cost | Category          | Odometer | MSRP  | Email         | HomePhone  | WorkPhone  |
      | TC1       | anqaauto3 | qa1234   | N0304640 |                        | WBA5R7C06LFJ33660 |            | BMVKEY-CA-AN - BMW Key for AutoNation remittance purposes    | BMVKEY - ALL                    |   60 |           1400 |                   |                 |             |            |           1800 | TEST1     | TEST1    | TEST    | PLANO | TX    | 75063 | New              | Cash        | $199.00          | ECBMVKEY-CA-AN    |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC2       | anqaauto3 | qa1234   | N0304640 |                        | WBA5R7C06LFJ33460 |            | BMPWSADDAN1114 - BMW TW Cosmetic Contract for AutoNation     | PM-B1 - COSMETIC                |   36 |           1600 |                   |                 |             |            |           2000 | TEST2     | TEST2    | TEST    | PLANO | TX    | 75073 | New              | Cash        | $949.00          | ECBMPWSADDAN1114  |     1000 | 10000 | TEST@TEST.COM | 9898767651 | 6565434389 |
      | TC3       | anqaauto3 | qa1234   | N0391523 |                        | WBA5R7C06LFJ33760 |            | BMTWSADDAN1114 - BMW TW SA form for AutoNation e-con         | TW-B1 - STANDARD                |   12 |           1100 |                   |                 |             |            |           2100 | TEST3     | TEST3    | TEST    | PLANO | TX    | 75093 | New              | Cash        | $440.00          | ECBMTWSADDAN1114  |     1000 | 10000 | TEST@TEST.COM | 9898767654 | 6565434376 |
      | TC4       | anqaauto3 | qa1234   | N1004632 |                        | WBA5R7C06LFJ33160 |            | BMVKEY-CA-AN - BMW Key for AutoNation remittance purposes    | BMVKEY - ALL                    |   36 |            500 |                   |                 |             |            |            700 | TEST4     | TEST4    | TEST    | PLANO | TX    | 75093 | New              | Cash        | $169.00          | ECBMVKEY-CA-AN    |     1000 | 10000 | TEST@TEST.COM | 9898767654 | 6565434376 |
      | TC5       | anqaauto3 | qa1234   | N0291526 |                        | WBY1Z6C30H7A39666 |            | BMVKEYAN - AutoNation BMW Key Replacement for E-Con          | BMVKEY - ALL                    |   24 |           5000 |                   |                 |             |            |           6000 | TEST5     | TEST5    | TEST    | PLANO | TX    | 75093 | New              | Cash        | $129.00          | ECBMVKEYAN        |     1000 | 10000 | TEST@TEST.COM | 9898767654 | 6565434376 |
      | TC6       | anqaauto3 | qa1234   | N0291526 |                        | WBY1Z6C30H7A39666 |            | BMVKEYAN - AutoNation BMW Key Replacement for E-Con          | BMVKEY - ALL                    |   24 |           5000 |                   |                 |             |            |           6000 | TEST6     | TEST6    | TEST    | PLANO | TX    | 75093 | New              | Cash        | $129.00          | ECBMVKEYAN        |     1000 | 10000 | TEST@TEST.COM | 9898767654 | 6565434376 |
      | TC7       | anqaauto3 | qa1234   | N0346529 |                        | 5UXCR6C00L9B32861 |            | BMPWSADDANWA118 - BMW TW Cosmetic Contract for AutoNation    | PM-B2 - BMW COSMETIC TIRE/WHEEL |   24 |           1300 |                   |                 |             |            |           1500 | TEST7     | TEST7    | TEST7   | PLANO | TX    | 75093 | New              | Cash        | $999.00          | ECBMPWSADDANWA118 |     1000 | 10000 | TEST@TEST.COM | 9898767654 | 6565434376 |
      | TC8       | anqaauto3 | qa1234   | N0891508 |                        | WMWXU9C00M2N03831 |            | MIVKEYAN - AutoNation MINI Key Replacement for E-con         | BMVKEY - ALL                    |   12 |           1500 |                   |                 |             |            |            300 | TEST6     | TEST6    | TEST6   | PLANO | TX    | 75063 | New              | Cash        | $129.00          | MIVKEYAN          |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC9       | anqaauto3 | qa1234   | N0891508 |                        | SAJDD5GX2MCK70178 |            | MIVKEYAN - AutoNation MINI Key Replacement for E-con         | BMVKEY - ALL                    |   24 |           1500 |                   |                 |             |            |            300 | TEST7     | TEST7    | TEST7   | PLANO | TX    | 75063 | New              | Cash        | $149.00          | MIVKEYAN          |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC10      | anqaauto3 | qa1234   | N0891508 |                        | KL79MTSL8MB004583 |            | MIVKEYAN - AutoNation MINI Key Replacement for E-con         | BMVKEY - ALL                    |   36 |           1500 |                   |                 |             |            |            500 | TEST8     | TEST8    | TEST8   | PLANO | TX    | 75063 | New              | Cash        | $169.00          | MIVKEYAN          |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC11      | anqaauto3 | qa1234   | N0891508 |                        | KL79MPSL9MB010075 |            | MIVKEYAN - AutoNation MINI Key Replacement for E-con         | BMVKEY - ALL                    |   48 |           1500 |                   |                 |             |            |            700 | TEST9     | TEST9    | TEST9   | PLANO | TX    | 75063 | New              | Cash        | $189.00          | MIVKEYAN          |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC12      | anqaauto3 | qa1234   | N0891508 |                        | KL79MTSL5MB003987 |            | MIVKEYAN - AutoNation MINI Key Replacement for E-con         | BMVKEY - ALL                    |   60 |           1500 |                   |                 |             |            |            900 | TEST10    | TEST10   | TEST10  | PLANO | TX    | 75063 | New              | Cash        | $199.00          | MIVKEYAN          |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC13      | anqaauto3 | qa1234   | N0691568 |                        | WMZYW7C00L3L62743 |            | MIPWSADDAN1114 - MINI Tire and Wheel Cosmetic for AutoNation | PM-MI - COSMETIC                |   12 |           3000 |                   |                 |             |            |            700 | TEST12    | TEST12   | TEST12  | PLANO | TX    | 75063 | New              | Cash        | $564.00          | MIPWSADDAN1114    |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |
      | TC14      | anqaauto3 | qa1234   | N0691568 |                        | WMWXU3C51H2D32749 |            | MITWSADDAN1114 - MINI Tire and Wheel for AutoNation          | TW-MI - STANDARD                |   24 |           3000 |                   |                 |             |            |            700 | TEST13    | TEST13   | TEST13  | PLANO | TX    | 75063 | New              | Cash        | $605.00          | MITWSADDAN1114    |     1000 | 10000 | TEST@TEST.COM | 9898767652 | 6565434349 |

  @VinDecoder_AN_BMW
  Scenario Outline: Vin Decoding
    Given Go to Url for Vin Decoding as "<Test_Case>" and "<UserName>" and "<Password>" and "<Dealer>" and "<DealNumber_OR_Last7Vin>" and "<Full_VIN>" and "<Exp_Product_Form>"
    And Click on Log in Link for Vin Decoding
    And Update cmsid of the dealer for VinDecoding
    And Login with UserName and Password for Vin Decoding
    And Click on Rate and Remit Link for Vin Decoding
    When Fill Remittance Form for Vin Decoding
    And Verify Product Form for Vin Decoding
    Then Log Out From Portal for Vin Decoding

    Examples: 
      | Test_Case | UserName  | Password | Dealer   | DealNumber_OR_Last7Vin | Full_VIN          | Exp_Product_Form                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
      |         1 | anqaauto3 | qa1234   | N0304640 |                        | WBA2J1C05L7E61343 | ANGP1219 - AutoNation GAP Agreement@ANGPCV1219 - AutoNation Commercial GAP@ANLS 1/20 - AutoNation Lease Agreement@ANTPIT 12/15 - AutoNation Theft/ID@ANTW 5/18 - Tire and Wheel@ANVPP+KSC - Vehicle Protection Plan Plus Key Service Contract@ANVPP+SC - Vehicle Protection Plan Key Service Contract@BMPWSADDAN1114 - BMW TW Cosmetic Contract for AutoNation@BMTWSADDAN1114 - BMW TW SA form for AutoNation e-con@BMVKEY-CA-AN - BMW Key for AutoNation remittance purposes |
      |         2 | anqaauto3 | qa1234   | N0304640 |                7E61343 |                   | ANGP1219 - AutoNation GAP Agreement@ANGPCV1219 - AutoNation Commercial GAP@ANLS 1/20 - AutoNation Lease Agreement@ANTPIT 12/15 - AutoNation Theft/ID@ANTW 5/18 - Tire and Wheel@ANVPP+KSC - Vehicle Protection Plan Plus Key Service Contract@ANVPP+SC - Vehicle Protection Plan Key Service Contract@BMPWSADDAN1114 - BMW TW Cosmetic Contract for AutoNation@BMTWSADDAN1114 - BMW TW SA form for AutoNation e-con@BMVKEY-CA-AN - BMW Key for AutoNation remittance purposes |

  @CancellationQuote
  Scenario Outline: Get Cancellation Quote
    Given Go to Url for Cancellation Quote as "<Test_Case>" and "<UserName>" and "<Password>" and "<Dealer>" and "<FirstName>" and "<LastName>" and "<Vin>" and "<ContractNumber>" and "<CancellationDate>" and "<MethodOfCancellation>" and "<CustomerCost>" and "<CancellationReason>" and "<Exp_Factor>" and "<Exp_CustomerRefund>" and "<End_Mileage>"
    And Click on Log in Link for Cancellation Quote
    And Update cmsid of the dealer for Cancelation Quote
    And Login with UserName and Password for Cancellation Quote
    And Click on Cancellation Quote Menu
    And Fill the Contract Search Form
    And Click on Submit button
    When Click on a Contract
    And Click on Cancellation Quote button
    And Fill the required data for Cancellation Quote
    And verify Factor and Customer Refund
    Then Log Out from Portal for Cancellation Quote

    Examples: 
      | Test_Case | UserName      | Password        | Dealer   | FirstName | LastName | Vin               | ContractNumber | CancellationDate | MethodOfCancellation | CustomerCost | CancellationReason | Exp_Factor | Exp_CustomerRefund | End_Mileage |
      |         1 | qaautomation1 | automation@1234 | N0591404 |           |          | 2T2ZZMCA2GC016902 |     0023071088 | 2016-09-06       | Rule of 78           |       592.56 | Flat               |    0.77397 | $409.07            |        1000 |
      |         2 | qaautomation1 | automation@1234 | N0591404 | JUAN      | ACEVEDO  |                   |     0023071088 | 2016-09-06       | Pro-rata             |       592.56 | Standard           |    0.77397 | $409.07            |        1000 |

  @Cancellations
  Scenario Outline: Get Cancellations
    Given Go to Url for Cancellations as "<Test_Case>" and "<UserName>" and "<Password>" and "<Agent>" and "<FirstName>" and "<LastName>" and "<Vin>" and "<ContractNumber>" and "<CancellationDate>" and "<MethodOfCancellation>" and "<CustomerCost>" and "<CancellationReason>" and "<Exp_Factor>" and "<Exp_CustomerRefund>"
    And Click on Log in Link for Cancellations
    And Update cmsid of the dealer for Cancelations
    And Login with UserName and Password for Cancellations
    And Click on Cancellation Quote Menu
    And Fill the Contract Search Form for Cancellations
    And Click on Submit button
    When Click on a Contract for Cancellations
    And Click on Cancellation Quote button
    And Fill the required data for Cancellations
    And verify Factor and Customer Refund for Cancellations
    And Click on Complete Cancellation and Verify Message
    Then Log Out from Portal for Cancellations

    Examples: 
      | Test_Case | UserName      | Password        | Agent  | FirstName | LastName | Vin               | ContractNumber | CancellationDate | MethodOfCancellation | CustomerCost | CancellationReason | Exp_Factor | Exp_CustomerRefund |
      |         1 | qaautomation1 | automation@1234 | 000001 |           |          | 4S3BMBC60B3248209 |     0008883416 | 2016-06-16       | Pro-rata             |       427.52 | Standard           |    0.05255 | $0.00              |
