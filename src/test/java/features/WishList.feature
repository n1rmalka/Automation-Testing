Feature: Validate Login To Application and Add to product to wishlist

  Scenario Outline: Login to Application and Add product to wishlist
    Given User is on home page
    Then User close the discount popup
    And Click on Signin and verify the title
    And Enter "<username>", "<password>" and click on submit button
    And Click on wishlist
    And Click on product and add more quantity "<qty>"
    And Click on heart icon
    And Click on Browse wishlist
    And Click on Add to cart
    And Enter coupon code "<coupon>" and click on apply coupn button
    And Click on Change address and enter new local address "<Country>","<State>","<city>","<postalcode>"
    And click on Proceed to checkout button
    And Fill the billing details of the  user "<firstname>","<lastname>","<address1>","<address2>","<State>","<city>","<postalcode>","<phonenumber>","<email>"
    And User entering new password "<Password>" and "<confirmpasword>"
    And Click on Shipping diffrent address checkbox
    And Fill the shipping details of the  user "<firstname>","<lastname>","<address1>","<address2>","<State>","<city>","<postalcode>","<phonenumber>","<email>"
    And User enter credit card details "<cardnumber>","<cardexpdate>","<cardcvc>"
    And User click on website terms and conditions
    And Click on Place order button
    And Verify the Total amount
    And browser is closed

    Examples: 
      | ID    | Description                                      | title              | username                    | password        | coupon  | qty | firstname | lastname | address1                 | address2        | State    | city    | postalcode | phonenumber | email       | cardnumber       | cardexpdate | cardcvc |
      | TC_01 | Login to Application and add product to wishlist | Returning Customer | atdemouser96@mailinator.com | Testbesttest@20 | SAVEME5 |   4 | Nirmal    | Patel    | 3647 173rd Court Lansing | LakeView Garden | Illinois | Lansing |      10001 |        9856 | nirmalpatel | 4242424242424242 |        0325 |     123 |
