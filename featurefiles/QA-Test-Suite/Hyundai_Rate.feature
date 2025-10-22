Feature: To Test Hyundai Rate Look Up functionality

  @RateLookUp
  Scenario Outline: Rate Look Up
    Given select urlforRL "<Portal>"
    Given Go to Url as "<TestCase>" and "<Dealer>" and "<UserName>" and "<Password>" and "<VIN>" and "<Odometer>" and "<Product>" and "<Coverage>" and "<Term>" and "<MaxTerm>" and "<MaxAmount>" and "<Deductible>" and "<Rate>"
    And Login to the Portal
    And Redirect to the rate look up url
    When Fill the Product Rate Look up details VIN and Odometer
    And Click on the Product
    And Verify the Rate
    Then Logout from the Portal

    Examples: 
      | TestCase | Portal     | Dealer   | UserName      | Password  | VIN               | Odometer | Product              | Coverage                                           | Term        | MaxTerm | MaxAmount | Deductible | Rate      |
      #|        1 | Hyundai | HYUFL008 | HYUFL008REMIT | hyu@dlr@2 | KMHCU4AE3DU461402 |     1000 | HPP TIRE & WHEEL PROTECTION  | TIRE & WHEEL                                       |          24 |         |             |          0 | $195.00   |
      #|        2 | Hyundai | HYUFL008 | HYUFL008REMIT | hyu@dlr@2 | KMHCU4AE3DU461402 |     1000 | HPP DENT & DING PROTECTION   | DENT & DING PROTECTION                             |          48 |         |             |          0 | $160.00   |
      #|        3 | Hyundai | HYUFL008 | HYUFL008REMIT | hyu@dlr@2 | KMHCU4AE3DU461402 |     1000 | HPP KEY REPLACEMENT          | KEY REPLACEMENT                                    |          36 |         |             |          0 | $165.00   |
      |        4 | Hyundai | HYUFL008 | HYUFL008REMIT | hyu@dlr@2 | KMHCU4AE3DU461483 |     1000 | HPP THEFT PROTECTION | THEFT PROTECTION - $5000 BENEFIT                   |          60 |         |           |          0 | $135.00   |
      #|        5 | Hyundai | HYUFL008 | HYUFL008REMIT | hyu@dlr@2 | KMHCU4AE3DU461402 |     1000 | HPP CPO WRAP         | PLATINUM $100 DEDUCTIBLE - HPP CPO WRAP SERVICE CO | 120 /120000 |         |           |          0 | $1,179.00 |
      #|        6 | Hyundai | HYUFL008 | HYUFL008REMIT | hyu@dlr!1 | KMHCU4AE3DU461402 |     1000 | HPP PRE-PAID MAINTENANCE     | HPP PPM WITH TIRE ROTATIONS - NON-TURBO (12k - 7,5 | 72 /72000   |         |             |          0 | $424.00   |
      #|        7 | Hyundai | HYUFL008 | HYUFL008REMIT | hyu@dlr!1 | KMHCU4AE3DU461402 |     1000 | HPP TERM PROTECTION PLUS     | HPP TERM PROTECTION PLUS VEHICLE SERVICE CONTRACT  | 48 /48000   |         |             |          0 | $415.00   |
      #|        8 | Hyundai | HYUFL008 | HYUFL008REMIT | hyu@dlr!1 | KMHCU4AE3DU461402 |     1000 | HPP VEHICLE SERVICE CONTRACT | PLATINUM - HPP VEHICLE SERVICE CONTRACT - TIER 1   | 60 /75000   |         |             |        100 | $743.00   |
      #|        9 | Hyundai | HYUFL008 | HYUFL008REMIT | hyu@dlr!1 | KMHCU4AE3DU461402 |     1000 | HPP GAP                      | SETTLEMENT GAP 150% MSRP - TIER 1                  |             |      72 |             |          0 | $385.00   |
      #|       10 | Hyundai | HYUFL008 | HYUFL008REMIT | hyu@dlr!1 | KMHCU4AE3DU461402 |     1000 | HPP EXCESS WEAR AND USE      | HYUNDAI EXCESS WEAR & USE - TIER 1 - ALL VEHICLES  |             |      72 | $150,000.00 |          0 | $458.00   |
