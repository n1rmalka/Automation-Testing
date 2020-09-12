Feature: Validate Search Product and Add to Cart and Place Order

  Scenario Outline: Smoke test of the application from Search product to Add product to Place order
    Given User is on home page
    Then User close the discount popup
    And search product "<searchtext>" and click on search product
    And Click on Quick view
    And Click on plus button and click on add to cart
    And Enter coupon code "<coupon>" and click on apply coupn button
    #And Enter count "<qty>"
    And Click on Change address and enter new local address "<Country>","<State>","<city>","<postalcode>"
    And click on Proceed to checkout button
    And Fill the billing details of the  user "<firstname>","<lastname>","<address1>","<address2>","<State>","<city>","<postalcode>","<phonenumber>","<email>"
    And User entering new password "<Password>"
    And Click on Shipping diffrent address checkbox
    And Fill the shipping details of the  user "<firstname>","<lastname>","<address1>","<address2>","<State>","<city>","<postalcode>","<phonenumber>","<email>"
    And User enter credit card details "<cardnumber>","<cardexpdate>","<cardcvc>"
    And User click on website terms and conditions
    And Click on Place order button
    And Verify the Total amount
    And browser is closed

    Examples: 
      | ID    | Description                            | searchtext | coupon  | qty | Country            | State    | firstname | lastname | address1                 | address2        | State    | city    | postalcode | phonenumber | email      | cardnumber       | cardexpdate | cardcvc | password        |
      | TC_01 | Search Product and Add to cart product | Almond     | SAVEME5 |   1 | United States (US) | New York | Franky    | Dean     | 3647 173rd Court Lansing | LakeView Garden | Illinois | Lansing |      60438 | 985-256-78  | frankydean | 4242424242424242 |        0325 |     123 | Testbesttest@20 |
