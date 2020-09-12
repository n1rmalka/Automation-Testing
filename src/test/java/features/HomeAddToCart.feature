Feature: Validate Add product To Cart and Place Order

  Scenario Outline: Smoke test of the application from Add product to Place order
    Given User is on home page
    Then User close the discount popup
    When User adds a product to cart
    And user click on term & condtions checkbox
    And clicks checkout button
    #Then click here to login link should be displayed
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
      | ID    | Description                        | firstname | lastname | address1                 | address2 | State    | city    | postalcode | phonenumber | email    | cardnumber       | cardexpdate | cardcvc | password        |
      | TC_01 | End to End test of the application | Evan      | More     | 3647 173rd Court Lansing | Circle   | Illinois | Lansing |      60438 | 987-456-78  | evanmore | 4242424242424242 |        0325 |     123 | Testbesttest@20 |
